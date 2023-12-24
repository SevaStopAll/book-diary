package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.Author;
import ru.sevastopall.readersDairy.model.File;
import ru.sevastopall.readersDairy.repository.AuthorRepository;
import ru.sevastopall.readersDairy.repository.FileRepository;
import ru.sevastopall.readersDairy.service.AuthorService;
import ru.sevastopall.readersDairy.service.FileService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SimpleAuthorService implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileService fileService;

    @Override
    public Author save(Author author, FileDto image) {
        if (image.getContent() .length == 0) {

        }
        File savedImage = fileService.save(image);
        author.setFileId(savedImage.getId());
        return authorRepository.save(author);
    }

    @Override
    public Author findById(long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> findByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    @Override
    public Author findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    @Override
    public Optional<Author> findByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
    }

}
