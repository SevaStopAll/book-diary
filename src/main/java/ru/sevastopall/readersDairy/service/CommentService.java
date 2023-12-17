package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Comment;
import ru.sevastopall.readersDairy.model.Review;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);

    List<Comment> findByReview(Review review);
}
