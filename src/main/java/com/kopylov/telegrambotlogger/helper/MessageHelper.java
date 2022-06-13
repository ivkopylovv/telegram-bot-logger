package com.kopylov.telegrambotlogger.helper;

import com.kopylov.telegrambotlogger.constants.DataType;
import com.kopylov.telegrambotlogger.constants.ErrorMessage;
import com.kopylov.telegrambotlogger.constants.MessageType;
import com.kopylov.telegrambotlogger.dto.DataTypeDto;
import com.kopylov.telegrambotlogger.dto.MessageTypeDto;
import com.kopylov.telegrambotlogger.exception.UnknownMessageContentException;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Date;

public class MessageHelper {

    public static DataTypeDto findDataType(Message message) {
        if (message.hasText()) {
            return new DataTypeDto(DataType.TEXT, message.getText());
        } else if (message.hasDocument()) {
            return new DataTypeDto(DataType.DOCUMENT, message.getDocument().getFileId());
        } else if (message.hasAudio()) {
            return new DataTypeDto(DataType.AUDIO, message.getAudio().getFileId());
        } else if (message.hasPhoto()) {
            return new DataTypeDto(DataType.PHOTO, message.getDocument().getFileId());
        } else if (message.hasVideo()) {
            return new DataTypeDto(DataType.VIDEO, message.getVideo().getFileId());
        } else if (message.hasSticker()) {
            return new DataTypeDto(DataType.STICKER, message.getSticker().getFileId());
        } else if (message.hasVoice()) {
            return new DataTypeDto(DataType.VOICE, message.getVoice().getFileId());
        } else {
            throw new UnknownMessageContentException(ErrorMessage.UNKNOWN_TYPE);
        }
    }

    public static MessageTypeDto findMessageType(Message message) {
        if (message.getEditDate() == null) {
            if (message.getForwardDate() != null) {
                return new MessageTypeDto(MessageType.FORWARDED, new Date(message.getForwardDate()));
            } else if (message.isReply()) {
                return new MessageTypeDto(MessageType.REPLIED, new Date(message.getDate()));
            } else if (message.getPinnedMessage() != null) {
                return new MessageTypeDto(MessageType.PINNED, new Date(message.getPinnedMessage().getDate()));
            } else {
                return new MessageTypeDto(MessageType.SENT, new Date(message.getDate()));
            }
        } else {
            return new MessageTypeDto(MessageType.EDITED, new Date(message.getEditDate()));
        }
    }
}
