package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.readersDairy.model.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByLastName(String lastName);

    Author findByFirstName(String firstName);

    List<Author> findByBirthDate_Year(int localDate);
}