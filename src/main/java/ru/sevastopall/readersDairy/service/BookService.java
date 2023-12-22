package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);

    Book findById(long id);

    Optional<Book> findByTitle(String title);

    List<Book> findAll();
}
