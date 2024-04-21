package com.odl.cvdemo.config;

import com.odl.cvdemo.service.TgBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TgBotConfig {
    @Bean
    public TelegramBotsApi telegramBotsApi(TgBot tgBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(tgBot);
        return api;
    }
}