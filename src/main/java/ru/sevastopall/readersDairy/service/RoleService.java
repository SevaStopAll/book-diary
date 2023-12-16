package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Role;

public interface RoleService {
    Role findById(long id);

    Role findByName(String name);
}
