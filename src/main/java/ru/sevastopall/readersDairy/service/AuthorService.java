package ru.sevastopall.readersDairy.service;

import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author, FileDto image);

    Author findById(long id);

    List<Author> findByFirstName(String firstName);

    Author findByLastName(String lastName);

    //TODO проверить реализацию поиска по ГОДУ РОЖДЕНИЯ

    List<Author> findAll();

    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
