package com.kopylov.telegrambotlogger.service;

import com.kopylov.telegrambotlogger.dao.MessageDAO;
import com.kopylov.telegrambotlogger.dto.DataTypeDto;
import com.kopylov.telegrambotlogger.dto.MessageTypeDto;
import com.kopylov.telegrambotlogger.entity.Messages;
import com.kopylov.telegrambotlogger.util.MessageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;


@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageDAO messageDAO;

    public Messages saveMessage(Message message) {
        DataTypeDto dataTypeDto = MessageHelper.findDataType(message);
        MessageTypeDto messageTypeDto = MessageHelper.findMessageType(message);
        Messages newMessage = new Messages(
                Long.valueOf(message.getMessageId()),
                messageTypeDto.getDate(),
                messageTypeDto.getMessageType(),
                dataTypeDto.getDataType(),
                dataTypeDto.getData()
        );

        return messageDAO.save(newMessage);
    }
}
