package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(long id);

    List<Book> findAll();
}
