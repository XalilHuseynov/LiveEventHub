package com.example.liveeventhub.service;

import com.example.liveeventhub.model.Event;
import com.example.liveeventhub.model.Message;
import com.example.liveeventhub.repository.EventRepository;
import com.example.liveeventhub.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {

    private MessageRepository messageRepository;
    private EventRepository eventRepository;


    public void saveMessage(Long eventId, String sender, String content){
        Event event = eventRepository.findById(eventId).orElseThrow(()->new RuntimeException("not found"));

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setEvent(event);
        message.setTimestamp(LocalDateTime.now());

        messageRepository.save(message);
    }




}
