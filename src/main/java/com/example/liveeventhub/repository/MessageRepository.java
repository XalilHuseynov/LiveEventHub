package com.example.liveeventhub.repository;

import com.example.liveeventhub.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByEventId(Long eventId);
}
