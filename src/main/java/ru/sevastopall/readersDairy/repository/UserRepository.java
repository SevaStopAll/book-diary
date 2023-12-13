package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.readersDairy.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
