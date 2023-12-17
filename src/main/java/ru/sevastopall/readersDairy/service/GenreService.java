package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Genre;

import java.util.List;

public interface GenreService {

    Genre findById(int id);

    List<Genre> findAll();
}
