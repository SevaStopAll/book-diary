package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.readersDairy.model.File;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    File save(File file);

    Optional<File> findById(int id);

    void deleteById(int id);
}
