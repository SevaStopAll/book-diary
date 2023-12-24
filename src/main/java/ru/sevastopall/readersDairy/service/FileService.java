package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.File;

import java.util.Optional;

public interface FileService {

    File save(FileDto fileDto);

    Optional<FileDto> getFileById(int id);

    void deleteById(int id);
}

