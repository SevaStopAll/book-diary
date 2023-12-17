package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Comment;
import ru.sevastopall.readersDairy.model.Review;
import ru.sevastopall.readersDairy.repository.CommentRepository;
import ru.sevastopall.readersDairy.service.CommentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleCommentService implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByReview(Review review) {
        return commentRepository.findByReview(review);
    }
}
