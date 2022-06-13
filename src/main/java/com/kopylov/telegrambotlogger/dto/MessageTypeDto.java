package com.kopylov.telegrambotlogger.dto;

import com.kopylov.telegrambotlogger.constants.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class MessageTypeDto {
    private MessageType messageType;
    private Date date;
}
