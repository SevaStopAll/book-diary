package ru.sevastopall.readersDairy.dto;

import lombok.Data;

@Data
public class FileDto {
    private String name;

    private byte[] content;
}
