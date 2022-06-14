package com.kopylov.telegrambotlogger.service;

import com.kopylov.telegrambotlogger.dao.UserDAO;
import com.kopylov.telegrambotlogger.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public Users saveUser(User user) {

        return userDAO.findByUserId(user.getId())
                .orElse(userDAO.save(
                        new Users(user.getId(), user.getFirstName(), user.getLastName(), user.getUserName()))
                );
    }
}
