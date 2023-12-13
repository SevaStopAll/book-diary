package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.readersDairy.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
