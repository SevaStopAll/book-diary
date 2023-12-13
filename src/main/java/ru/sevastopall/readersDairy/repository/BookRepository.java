package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.readersDairy.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
