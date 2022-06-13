package com.kopylov.telegrambotlogger.entity;

import com.kopylov.telegrambotlogger.embeddable.ChatId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @EmbeddedId
    private ChatId chatId;
}
