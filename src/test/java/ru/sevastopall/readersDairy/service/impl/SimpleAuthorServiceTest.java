package ru.sevastopall.readersDairy.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.readersDairy.IntegrationTestBase;
import ru.sevastopall.readersDairy.model.Author;

import java.util.List;

public class SimpleAuthorServiceTest extends IntegrationTestBase {

    @Autowired private SimpleAuthorService service;

    @Test
    void save() {
        //Arrange
        Author author = new Author();

        //Act
        Author result = service.save(author);

        //Assert
        Assertions.assertThat(result).isEqualTo(author);
    }

    @Test
    void findById() {
        //Arrange
        Author author = new Author();
        Author authorWithId = service.save(author);

        //Act
        Author result = service.findById(authorWithId.getId());

        //Assert
        Assertions.assertThat(result).isEqualTo(authorWithId);
    }

    @Test
    void findByFirstName() {
        //Arrange
        Author author = new Author();
        author.setFirstName("Test");
        Author authorWithId = service.save(author);

        //Act
        List<Author> result = service.findByFirstName("Test");

        //Assert
        Assertions.assertThat(result.get(0)).isEqualTo(authorWithId);
    }

    @Test
    void findByLastName() {
        //Arrange
        Author author = new Author();
        author.setLastName("Test");
        Author authorWithId = service.save(author);

        //Act
        Author result = service.findByLastName("Test");

        //Assert
        Assertions.assertThat(result).isEqualTo(authorWithId);
    }

}