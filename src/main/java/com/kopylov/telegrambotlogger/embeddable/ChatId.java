package com.kopylov.telegrambotlogger.embeddable;

import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.entity.Users;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ChatId implements Serializable {
    private Long chatId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private Messages message;
}
