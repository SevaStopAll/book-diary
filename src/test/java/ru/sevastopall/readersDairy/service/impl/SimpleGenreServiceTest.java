package ru.sevastopall.readersDairy.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.readersDairy.IntegrationTestBase;
import ru.sevastopall.readersDairy.model.Genre;

import java.util.List;

public class SimpleGenreServiceTest extends IntegrationTestBase {
    @Autowired private SimpleGenreService simpleGenreService;


    @Test
    void findById() {
        //Arrange
        Genre genre = new Genre();
        Genre savedGenre = simpleGenreService.save(genre);

        //Act
        Genre result = simpleGenreService.findById(genre.getId());

        //Assert
        Assertions.assertThat(result).isEqualTo(savedGenre);
    }

    @Test
    void findAll() {
        //Arrange
        Genre genre = new Genre();
        Genre savedGenre = simpleGenreService.save(genre);

        //Act
        List<Genre> result = simpleGenreService.findAll();

        //Assert
        Assertions.assertThat(result.contains(savedGenre)).isTrue();
    }
}