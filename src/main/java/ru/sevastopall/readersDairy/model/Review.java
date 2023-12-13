package ru.sevastopall.readersDairy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String text;

    private int mark;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    private LocalDateTime publicationTime;
}
