package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.embeddable.ChatId;
import com.kopylov.telegrambotlogger.entity.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatDAO extends CrudRepository<Chat, ChatId> {

}
