package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.readersDairy.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
