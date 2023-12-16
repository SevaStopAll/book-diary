package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User findById(long id);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
