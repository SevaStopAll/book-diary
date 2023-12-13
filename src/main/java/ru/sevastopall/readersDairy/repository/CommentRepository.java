package ru.sevastopall.readersDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.readersDairy.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
