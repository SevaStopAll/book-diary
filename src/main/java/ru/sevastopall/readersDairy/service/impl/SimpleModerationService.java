package ru.sevastopall.readersDairy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.readersDairy.service.ModerationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class SimpleModerationService implements ModerationService {
    //TODO дописать модерацию через регулярные выражения!
    @Override
    public boolean moderate(String text) {
        Pattern patternToCancel = Pattern.compile("testCase", Pattern.CASE_INSENSITIVE);
        Matcher matcher = patternToCancel.matcher(text);
        return !matcher.find();
    }
}
