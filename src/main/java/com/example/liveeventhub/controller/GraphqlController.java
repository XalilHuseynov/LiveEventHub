package com.example.liveeventhub.controller;

import com.example.liveeventhub.model.Event;
import com.example.liveeventhub.model.Message;
import com.example.liveeventhub.repository.MessageRepository;
import com.example.liveeventhub.service.EventService;
import com.example.liveeventhub.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphqlController {


    private final EventService eventService;
    private final RedisService redisService;
    private final MessageRepository messageRepository;


    @QueryMapping
    public List<Event> getEvents(){
        return eventService.getAll();
    }


    @QueryMapping
    public List<Message> getMessages(@Argument Long eventId){
        return messageRepository.findByEventId(eventId);
    }

    @MutationMapping
    public Event createEvent(@Argument String title){
        return eventService.create(title);
    }


    @MutationMapping
    public String joinEvent(@Argument Long eventId, @Argument String user){
        redisService.join(eventId,user);
        return user+" successfully joined ";
    }

}
