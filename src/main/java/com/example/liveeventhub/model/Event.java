package com.example.liveeventhub.model;

import com.example.liveeventhub.Enum.STATUS;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private STATUS status =STATUS.ACTIVE;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Message> messages;
}