package ru.sevastopall.readersDairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadersDairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadersDairyApplication.class, args);
		System.out.println("http://localhost:9005/");
	}

}
