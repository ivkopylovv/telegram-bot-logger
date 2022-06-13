package com.kopylov.telegrambotlogger.bot;

import com.kopylov.telegrambotlogger.dto.ChatDto;
import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.entity.Users;
import com.kopylov.telegrambotlogger.handler.ChatService;
import com.kopylov.telegrambotlogger.handler.MessageService;
import com.kopylov.telegrambotlogger.handler.UserService;
import com.kopylov.telegrambotlogger.helper.PropertiesReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramBotLogger extends TelegramLongPollingBot {
    private final MessageService messageService;
    private final UserService userService;
    private final ChatService chatService;

    @Override
    public String getBotUsername() {
        return PropertiesReader.readProperty("bot.username");
    }

    @Override
    public String getBotToken() {
        return PropertiesReader.readProperty("bot.token");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasCallbackQuery()) {
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
    }
}

