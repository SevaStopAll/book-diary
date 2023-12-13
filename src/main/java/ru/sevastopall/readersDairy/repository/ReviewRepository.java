package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.readersDairy.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
