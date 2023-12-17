package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Genre;
import ru.sevastopall.readersDairy.repository.GenreRepository;
import ru.sevastopall.readersDairy.service.GenreService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleGenreService implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre findById(int id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
