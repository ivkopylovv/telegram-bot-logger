package com.kopylov.telegrambotlogger.handler;

import com.kopylov.telegrambotlogger.dto.ChatDto;
import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.entity.Users;
import com.kopylov.telegrambotlogger.service.ChatService;
import com.kopylov.telegrambotlogger.service.MessageService;
import com.kopylov.telegrambotlogger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class ChatHandler {
    private final MessageService messageService;
    private final UserService userService;
    private final ChatService chatService;

    public void handleMessage(Update update) {
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
