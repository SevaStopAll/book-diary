package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Review;

public interface ModerationService {
    boolean moderate(String text);
}
