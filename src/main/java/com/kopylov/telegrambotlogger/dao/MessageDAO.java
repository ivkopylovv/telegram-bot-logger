package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageDAO extends CrudRepository<Messages, Long> {
    Optional<Messages> findByMessageId(Long id);
}
