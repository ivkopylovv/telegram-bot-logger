package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.embeddable.ChatId;
import com.kopylov.telegrambotlogger.entity.Chat;
import com.kopylov.telegrambotlogger.entity.Messages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChatDAO extends CrudRepository<Chat, ChatId> {
    @Query("select m from Chat c " +
            "join c.chatId.message m " +
            "join c.chatId.user u " +
            "where c.chatId.chatId = :chatId and c.chatId.user.username = :username")
    List<Messages> findMessagesByChatIdAndUsername(Long chatId, String username);

    @Query("select m from Chat c " +
            "join c.chatId.message m " +
            "join c.chatId.user u " +
            "where c.chatId.chatId = :chatId and c.chatId.user.username = :username " +
            "and m.date > :startDate and m.date < :endDate")
    List<Messages> findMessagesByChatIdAndUsernameAndPeriod(Long chatId, String username, Date startDate, Date endDate);
}
