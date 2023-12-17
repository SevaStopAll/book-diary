package ru.sevastopall.readersDairy.service;

import ru.sevastopall.readersDairy.model.Review;

public interface ReviewModerationService {
    boolean moderate(Review review);
}
