package com.example.liveeventhub.service;


import com.example.liveeventhub.Enum.STATUS;
import com.example.liveeventhub.model.Event;
import com.example.liveeventhub.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event create(String title){
        Event event = new Event();
        event.setTitle(title);
        event.setStatus(STATUS.ACTIVE);
        eventRepository.save(event);
        return event;
    }


    public List<Event> getAll(){
        return eventRepository.findAll();
    }







}
