package com.kopylov.telegrambotlogger.entity;

import com.kopylov.telegrambotlogger.constants.DataType;
import com.kopylov.telegrambotlogger.constants.MessageType;
import com.kopylov.telegrambotlogger.util.EnumConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private Long messageId;
    private Date date;
    @Convert(converter = EnumConverter.class)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;
    private String text;
    @Convert(converter = EnumConverter.class)
    @Enumerated(EnumType.STRING)
    private DataType dataType;
}
