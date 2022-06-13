package com.kopylov.telegrambotlogger.bot;

import com.kopylov.telegrambotlogger.dao.MessageDAO;
import com.kopylov.telegrambotlogger.util.PropertiesReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramBotLogger extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return PropertiesReader.readProperty("bot.username");
    }

    @Override
    public String getBotToken() {
        return PropertiesReader.readProperty("bot.token");
    }

    @Override
    public void onUpdateReceived(Update update) {
    }
}

