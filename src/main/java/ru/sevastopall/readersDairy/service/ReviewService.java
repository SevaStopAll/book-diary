package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.model.Review;
import ru.sevastopall.readersDairy.model.User;

import java.util.List;

public interface ReviewService {

    Review save(Review review);

    Review findById(Long id);

    List<Review> findByBook(Book book);

    List<Review> findByUser(User user);
}
