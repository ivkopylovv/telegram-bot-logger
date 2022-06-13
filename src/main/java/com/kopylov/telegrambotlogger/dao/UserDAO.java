package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends CrudRepository<Users, Long> {
    Optional<Users> findByUserId(Long userId);
}
