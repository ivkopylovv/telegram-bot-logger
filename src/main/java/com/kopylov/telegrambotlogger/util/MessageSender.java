package com.kopylov.telegrambotlogger.util;

import com.kopylov.telegrambotlogger.constants.MessageFormat;
import com.kopylov.telegrambotlogger.entity.Messages;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class MessageSender {

    public static SendMessage sendCommonMessage(String username, Long chatId, Messages message) {
        return SendMessage
                .builder()
                .chatId(chatId.toString())
                .text(String.format(
                        MessageFormat.COMMON_FORMAT,
                        username,
                        message.getMessageType().toString().toLowerCase(),
                        DateHelper.convertDateToString(message.getDate())))
                .build();
    }

    public static SendMessage sendText(Long chatId, Messages message) {
        return SendMessage
                .builder()
                .chatId(chatId.toString())
                .text(message.getMessageData())
                .build();
    }

    public static SendSticker sendSticker(Long chatId, Messages message) {
        return SendSticker
                .builder()
                .chatId(chatId.toString())
                .sticker(new InputFile(message.getMessageData()))
                .build();
    }

    public static SendPhoto sendPhoto(Long chatId, Messages message) {
        return SendPhoto
                .builder()
                .chatId(chatId.toString())
                .photo(new InputFile(message.getMessageData()))
                .build();
    }

    public static SendVideo sendVideo(Long chatId, Messages message) {
        return SendVideo
                .builder()
                .chatId(chatId.toString())
                .video(new InputFile(message.getMessageData()))
                .build();
    }

    public static SendDocument sendDocument(Long chatId, Messages message) {
        return SendDocument
                .builder()
                .chatId(chatId.toString())
                .document(new InputFile(message.getMessageData()))
                .build();
    }

    public static SendVoice sendVoice(Long chatId, Messages message) {
        return SendVoice
                .builder()
                .chatId(chatId.toString())
                .voice(new InputFile(message.getMessageData()))
                .build();
    }
}
