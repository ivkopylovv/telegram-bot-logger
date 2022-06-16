package com.kopylov.telegrambotlogger.dto;

import com.kopylov.telegrambotlogger.entity.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MessagesUsernameDto {
    List<Messages> messages;
    String username;
}
