package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author findById(long id);

    Author findByFirstName(String firstName);

    Author findByLastName(String lastName);

    List<Author> findByBirthdate(LocalDate localDate);
}
