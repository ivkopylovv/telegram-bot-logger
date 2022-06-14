package com.kopylov.telegrambotlogger.service;

import com.kopylov.telegrambotlogger.dao.ChatDAO;
import com.kopylov.telegrambotlogger.dto.ChatDto;
import com.kopylov.telegrambotlogger.embeddable.ChatId;
import com.kopylov.telegrambotlogger.entity.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatDAO chatDAO;

    public void saveChatEntity(ChatDto chatDto) {
        ChatId chatId = new ChatId(chatDto.getChatId(), chatDto.getUser(), chatDto.getMessage());
        chatDAO.save(new Chat(chatId));
    }
}