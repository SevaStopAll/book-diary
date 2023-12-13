package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.User;
import ru.sevastopall.readersDairy.repository.RoleRepository;
import ru.sevastopall.readersDairy.repository.UserRepository;
import ru.sevastopall.readersDairy.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
