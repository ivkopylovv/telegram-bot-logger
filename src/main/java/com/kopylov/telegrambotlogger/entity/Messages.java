package com.kopylov.telegrambotlogger.entity;

import com.kopylov.telegrambotlogger.constants.DataType;
import com.kopylov.telegrambotlogger.constants.MessageType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Messages {
    @Id
    private Long messageId;
    private Date date;

    @Enumerated(STRING)
    private MessageType messageType;

    @Enumerated(STRING)
    private DataType dataType;
    private String messageData;
}
