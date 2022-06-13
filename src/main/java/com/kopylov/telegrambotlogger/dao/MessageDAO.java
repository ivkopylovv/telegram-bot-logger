package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO extends CrudRepository<Message, Long> {
    Message findByMessageId(Long id);
}
