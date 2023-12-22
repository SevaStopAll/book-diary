package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.model.Review;
import ru.sevastopall.readersDairy.model.User;
import ru.sevastopall.readersDairy.repository.ReviewRepository;
import ru.sevastopall.readersDairy.service.ReviewService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleReviewService implements ReviewService {
    private final ReviewRepository reviewRepository;


    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public List<Review> findByBook(Book book) {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
