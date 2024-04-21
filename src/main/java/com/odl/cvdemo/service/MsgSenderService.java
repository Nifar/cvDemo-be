package com.odl.cvdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odl.cvdemo.DTO.ContactForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class MsgSenderService {

    @Value("${bot.chatId}")
    private Long chatId;
    private final TgBot tgBot;
    private final ObjectMapper objectMapper;

    public void sendNotify(ContactForm form) {
        try {
            sendNotify(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(form));
        } catch (JsonProcessingException ignore) {
        }
    }

    private void sendNotify(String msgText) {
        var update = new Update();
        var msg = new Message();
        var chat = new Chat();
        chat.setId(chatId);
        msg.setChat(chat);
        msg.setText(msgText);
        update.setMessage(msg);
        tgBot.onUpdateReceived(update);
    }
}
