package com.kopylov.telegrambotlogger.bot;

import com.kopylov.telegrambotlogger.helper.PropertiesReader;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
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
           Message message = update.getMessage();
           if (message.hasText()) {
               try {
                   execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Hello").build());
               } catch (TelegramApiException e) {
                   e.printStackTrace();
               }
           }
    }
}

