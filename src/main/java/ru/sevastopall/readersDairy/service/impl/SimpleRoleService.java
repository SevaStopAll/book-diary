package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Role;
import ru.sevastopall.readersDairy.repository.RoleRepository;
import ru.sevastopall.readersDairy.service.RoleService;

@RequiredArgsConstructor
@Service
public class SimpleRoleService implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

}
