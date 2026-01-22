package com.example.liveeventhub.controller;

import com.example.liveeventhub.model.Message;
import com.example.liveeventhub.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController{

    private final MessageService messageService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{eventId}")
    public void sendMessage(@DestinationVariable Long eventId, Message message){

        messageService.saveMessage(eventId,message.getSender(),message.getContent());

        simpMessagingTemplate.convertAndSend("/topic/event/"+eventId, message);

    }

}
