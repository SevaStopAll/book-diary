package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.model.File;
import ru.sevastopall.readersDairy.repository.BookRepository;
import ru.sevastopall.readersDairy.service.BookService;
import ru.sevastopall.readersDairy.service.FileService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SimpleBookService implements BookService {
    private final BookRepository bookRepository;
    private final FileService fileService;


    @Override
    public Book save(Book book, FileDto image) {
        if ((Optional.ofNullable(image.getContent()).isEmpty())) {
            book.setFileId(1);
        }
        File savedImage = fileService.save(image);
        book.setFileId(savedImage.getId());
        return bookRepository.save(book);
    }
    @Override
    public Book saveWithoutPicture(Book book) {
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

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }
}
