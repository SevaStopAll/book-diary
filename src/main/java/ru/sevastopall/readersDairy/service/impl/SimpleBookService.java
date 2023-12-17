package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.repository.BookRepository;
import ru.sevastopall.readersDairy.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleBookService implements BookService {
    private final BookRepository bookRepository;


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
