package ru.sevastopall.readersDairy.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.File;
import ru.sevastopall.readersDairy.repository.FileRepository;
import ru.sevastopall.readersDairy.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SimpleFileService implements FileService {
    private final FileRepository fileRepository;

    private final String storageDirectory = "src/main/resources/static";

    @PostConstruct
    private void createStorageDirectory() {
        try {
            Files.createDirectories(Path.of("src/main/resources/static"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File save(FileDto fileDto) {
        var path = getNewFilePath(fileDto.getName());
        writeFileBytes(path, fileDto.getContent());
        File file = new File();
        file.setName(fileDto.getName());
        file.setPath(path);
        return fileRepository.save(file);
    }

    private String getNewFilePath(String sourceName) {
        return storageDirectory + java.io.File.separator + UUID.randomUUID() + sourceName;
    }

    private void writeFileBytes(String path, byte[] content) {
        try {
            Files.write(Path.of(path), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FileDto> getFileById(int id) {
        var fileOptional = fileRepository.findById(id);
        if (fileOptional.isEmpty()) {
            return Optional.empty();
        }
        var content = readFileAsBytes(fileOptional.get().getPath());
        FileDto fileDto = new FileDto();
        fileDto.setName(fileOptional.get().getName());
        fileDto.setContent(content);
        return Optional.of(fileDto);
    }

    private byte[] readFileAsBytes(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        var fileOptional = fileRepository.findById(id);
        if (fileOptional.isPresent()) {
            deleteFile(fileOptional.get().getPath());
            fileRepository.deleteById(id);
        }
    }

    private void deleteFile(String path) {
        try {
            Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
