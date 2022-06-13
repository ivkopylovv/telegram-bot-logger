package com.kopylov.telegrambotlogger.dao;

import com.kopylov.telegrambotlogger.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
