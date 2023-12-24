package ru.sevastopall.readersDairy.service;

import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book, FileDto image);

    Book findById(long id);

    Optional<Book> findByTitle(String title);

    List<Book> findAll();
}
