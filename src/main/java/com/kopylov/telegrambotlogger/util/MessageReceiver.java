package com.kopylov.telegrambotlogger.util;

import com.kopylov.telegrambotlogger.constants.ErrorMessage;
import com.kopylov.telegrambotlogger.dto.DataTypeDto;
import com.kopylov.telegrambotlogger.dto.MessageTypeDto;
import com.kopylov.telegrambotlogger.exception.UnknownMessageContentException;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.kopylov.telegrambotlogger.constants.DataType.*;
import static com.kopylov.telegrambotlogger.constants.MessageType.*;

public class MessageReceiver {

    public static DataTypeDto findDataType(Message message) {
        if (message.getPinnedMessage() != null) {
            message = message.getPinnedMessage();
        }
        if (message.hasText()) {
            return new DataTypeDto(TEXT, message.getText());
        } else if (message.hasDocument()) {
            return new DataTypeDto(DOCUMENT, message.getDocument().getFileId());
        } else if (message.hasAudio()) {
            return new DataTypeDto(AUDIO, message.getAudio().getFileId());
        } else if (message.hasPhoto()) {
            return new DataTypeDto(PHOTO, message.getDocument().getFileId());
        } else if (message.hasVideo()) {
            return new DataTypeDto(VIDEO, message.getVideo().getFileId());
        } else if (message.hasSticker()) {
            return new DataTypeDto(STICKER, message.getSticker().getFileId());
        } else if (message.hasVoice()) {
            return new DataTypeDto(VOICE, message.getVoice().getFileId());
        } else {
            throw new UnknownMessageContentException(ErrorMessage.UNKNOWN_TYPE);
        }
    }

    public static MessageTypeDto findMessageType(Message message) {
        if (message.getEditDate() == null) {
            if (message.getForwardDate() != null) {
                return new MessageTypeDto(FORWARDED, DateHelper.getMessageDate(message.getForwardDate()));
            } else if (message.isReply()) {
                return new MessageTypeDto(REPLIED, DateHelper.getMessageDate(message.getDate()));
            } else if (message.getPinnedMessage() != null) {
                return new MessageTypeDto(PINNED, DateHelper.getMessageDate(message.getPinnedMessage().getDate()));
            } else {
                return new MessageTypeDto(SENT, DateHelper.getMessageDate(message.getDate()));
            }
        } else {
            return new MessageTypeDto(EDITED, DateHelper.getMessageDate(message.getEditDate()));
        }
    }
}
