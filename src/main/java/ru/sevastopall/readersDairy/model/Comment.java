package ru.sevastopall.readersDairy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="review_id", nullable=false)
    private Review review;

    private String text;

    private LocalDate publicationTime;
}
