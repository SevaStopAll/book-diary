package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.model.Review;
import ru.sevastopall.readersDairy.service.ReviewModerationService;

@RequiredArgsConstructor
@Service
public class SimpleReviewModerationService implements ReviewModerationService {
    //TODO дописать модерацию через регулярные выражения!
    @Override
    public boolean moderate(Review review) {
        return false;
    }
}
