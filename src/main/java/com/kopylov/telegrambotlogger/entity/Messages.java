package com.kopylov.telegrambotlogger.entity;

import com.kopylov.telegrambotlogger.constants.DataType;
import com.kopylov.telegrambotlogger.constants.MessageType;
import com.kopylov.telegrambotlogger.helper.EnumConverter;
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
public class Messages {
    @Id
    private Long messageId;
    private Date date;

    @Convert(converter = EnumConverter.class)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Convert(converter = EnumConverter.class)
    @Enumerated(EnumType.STRING)
    private DataType dataType;
    private String messageData;
}
