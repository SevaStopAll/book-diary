package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.readersDairy.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
