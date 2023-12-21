package ru.sevastopall.readersDairy.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.readersDairy.IntegrationTestBase;
import ru.sevastopall.readersDairy.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBookServiceTest extends IntegrationTestBase {
    @Autowired private SimpleBookService simpleBookService;

    @Test
    void save() {
        //Arrange
        Book book = new Book();

        //Act
        Book result = simpleBookService.save(book);

        //Assert
        Assertions.assertThat(result).isEqualTo(book);
    }

    @Test
    void findById() {
        //Arrange
        Book book = new Book();
        Book savedBook = simpleBookService.save(book);

        //Act
        Book result = simpleBookService.findById(savedBook.getId());

        //Assert
        Assertions.assertThat(result).isEqualTo(savedBook);
    }

    @Test
    void findAll() {
        //Arrange
        Book book = new Book();
        Book savedBook = simpleBookService.save(book);
        Book book2 = new Book();
        Book savedBook2 = simpleBookService.save(book);

        //Act
        List<Book> result = simpleBookService.findAll();

        //Assert
        Assertions.assertThat(result.contains(savedBook) && result.contains(savedBook2));
    }
}