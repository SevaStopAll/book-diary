package ru.sevastopall.readersDairy.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.readersDairy.IntegrationTestBase;
import ru.sevastopall.readersDairy.model.User;

import java.util.Optional;

class SimpleUserServiceTest extends IntegrationTestBase {
    @Autowired private SimpleUserService simpleUserService;

    @Test
    void save() {
        //Arrange
        User user = new User();

        //Act
        User result = simpleUserService.save(user);

        //Assert
        Assertions.assertThat(result).isEqualTo(user);

    }

    @Test
    void findById() {
        //Arrange
        User user = new User();
        User savedUser = simpleUserService.save(user);

        //Act
        User result = simpleUserService.findById(savedUser.getId());

        //Assert
        Assertions.assertThat(result).isEqualTo(user);
    }

    @Test
    void findByUsernameAndPassword() {
        //Arrange
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        User savedUser = simpleUserService.save(user);
        //TODO проверить метод (LazyInitializationException);
        //Act
        Optional<User> mayBeUser = simpleUserService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        //Assert
        Assertions.assertThat(mayBeUser.isPresent()).isTrue();
    }
}