package com.kopylov.telegrambotlogger.bot;

import com.kopylov.telegrambotlogger.constants.ErrorMessage;
import com.kopylov.telegrambotlogger.dto.ChatDto;
import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.entity.Users;
import com.kopylov.telegrambotlogger.exception.UnknownMessageContentException;
import com.kopylov.telegrambotlogger.service.ChatService;
import com.kopylov.telegrambotlogger.service.MessageService;
import com.kopylov.telegrambotlogger.service.UserService;
import com.kopylov.telegrambotlogger.util.MessageSender;
import com.kopylov.telegrambotlogger.util.PropertiesReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TelegramBotLogger extends TelegramLongPollingBot {
    private final MessageService messageService;
    private final UserService userService;
    private final ChatService chatService;

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasEntities()) {
                handleCommand(update);
            } else {
                handleMessage(update);
            }
        } catch (UnknownMessageContentException e) {
            execute(SendMessage.builder().text(e.getMessage()).build());
        }
    }

    @Override
    public String getBotUsername() {
        return PropertiesReader.readProperty("bot.username");
    }

    @Override
    public String getBotToken() {
        return PropertiesReader.readProperty("bot.token");
    }

    private void handleMessage(Update update) {
        Message newMessage = null;

        if (update.hasEditedMessage()) {
            newMessage = update.getEditedMessage();
        } else if (update.hasMessage()) {
            newMessage = update.getMessage();
        }

        Users user = userService.saveUser(newMessage.getFrom());
        Messages message = messageService.saveMessage(newMessage);
        chatService.saveChatEntity(new ChatDto(newMessage.getChatId(), user, message));
    }

    @SneakyThrows
    private void handleCommand(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String username = message.getFrom().getUserName();
        List<Messages> messages = chatService.getMessagesByIdAndUsername(chatId, username);

        for (Messages m : messages) {
            execute(MessageSender.sendCommonMessage(username, chatId, m));
            sendMessageByType(chatId, m);
        }
    }

    @SneakyThrows
    private void sendMessageByType(Long chatId, Messages message) {
        switch (message.getDataType()) {
            case TEXT:
                execute(MessageSender.sendText(chatId, message));
                break;
            case VIDEO:
                execute(MessageSender.sendVideo(chatId, message));
                break;
            case STICKER:
                execute(MessageSender.sendSticker(chatId, message));
                break;
            case VOICE:
                execute(MessageSender.sendVoice(chatId, message));
                break;
            case DOCUMENT:
                execute(MessageSender.sendDocument(chatId, message));
                break;
            case PHOTO:
                execute(MessageSender.sendPhoto(chatId, message));
                break;
            default:
                throw new UnknownMessageContentException(ErrorMessage.UNKNOWN_TYPE);
        }
    }
}

