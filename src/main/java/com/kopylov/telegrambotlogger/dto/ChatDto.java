package com.kopylov.telegrambotlogger.dto;

import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChatDto {
    private Long chatId;
    private Users user;
    private Messages message;
}
