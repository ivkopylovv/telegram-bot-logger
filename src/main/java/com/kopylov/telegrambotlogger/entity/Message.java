package com.kopylov.telegrambotlogger.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long id;
    private String text;
    private Date date;
    private String type;
    private String chatId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
