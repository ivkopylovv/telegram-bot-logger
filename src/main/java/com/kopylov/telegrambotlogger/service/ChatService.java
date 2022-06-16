package com.kopylov.telegrambotlogger.service;

import com.kopylov.telegrambotlogger.dao.ChatDAO;
import com.kopylov.telegrambotlogger.dto.ChatDto;
import com.kopylov.telegrambotlogger.embeddable.ChatId;
import com.kopylov.telegrambotlogger.entity.Chat;
import com.kopylov.telegrambotlogger.entity.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatDAO chatDAO;

    public void saveChatEntity(ChatDto chatDto) {
        ChatId chatId = new ChatId(chatDto.getChatId(), chatDto.getUser(), chatDto.getMessage());
        chatDAO.save(new Chat(chatId));
    }

    public List<Messages> getMessagesByIdAndUsername(Long chatId, String username) {
        return chatDAO.findMessagesByChatIdAndUsername(chatId, username);
    }

    public List<Messages> getMessagesByChatIdAndUsernameAndPeriod(
            Long chatId, String username, Date startDate, Date endDate) {
        return chatDAO.findMessagesByChatIdAndUsernameAndPeriod(chatId, username, startDate, endDate);
    }

}
