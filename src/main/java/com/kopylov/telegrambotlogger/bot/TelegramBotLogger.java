package com.kopylov.telegrambotlogger.bot;

import com.kopylov.telegrambotlogger.exception.UnknownMessageContentException;
import com.kopylov.telegrambotlogger.handler.ChatHandler;
import com.kopylov.telegrambotlogger.util.PropertiesReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class TelegramBotLogger extends TelegramLongPollingBot {
    private final ChatHandler chatHandler;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (!update.hasCallbackQuery()) {
                chatHandler.handleMessage(update);
            }
        } catch (UnknownMessageContentException e) {
            try {
                execute(SendMessage.builder().text(e.getMessage()).build());
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return PropertiesReader.readProperty("bot.username");
    }

    @Override
    public String getBotToken() {
        return PropertiesReader.readProperty("bot.token");
    }
}

