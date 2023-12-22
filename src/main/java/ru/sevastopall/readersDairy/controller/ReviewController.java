package ru.sevastopall.readersDairy.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.model.Comment;
import ru.sevastopall.readersDairy.model.Review;
import ru.sevastopall.readersDairy.model.User;
import ru.sevastopall.readersDairy.service.BookService;
import ru.sevastopall.readersDairy.service.CommentService;
import ru.sevastopall.readersDairy.service.ReviewService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final BookService bookService;

    private final ReviewService reviewService;

    private final CommentService commentService;

    @GetMapping("/create")
    public String getReviewCreationPage() {
        return "reviews/create";
    }

    @PostMapping("/create")
    public String saveReview(@ModelAttribute Review review, String bookName, HttpSession session) {
        Optional<Book> mayBeBook = bookService.findByTitle(bookName);
        if (mayBeBook.isPresent()) {
            review.setBook(mayBeBook.get());
        } else {
            Book newBook = new Book();
            newBook.setTitle(bookName);
            Book savedBook = bookService.save(newBook);
            review.setBook(savedBook);
        }
        review.setPublicationTime(LocalDateTime.now());
        review.setUser((User) session.getAttribute("user"));
        reviewService.save(review);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getReviewList(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "reviews/all";
    }

    @GetMapping("/{id}")
    public String getOneReview(Model model, @PathVariable long id) {
        Review review = reviewService.findById(id);
        model.addAttribute("review", review);
        model.addAttribute("comments", commentService.findByReview(review));
        return "reviews/one";
    }

    @PostMapping("/update")
    public String updateReview(@ModelAttribute Review review) {
        reviewService.save(review);
        return "redirect:/index";
    }

    @PostMapping("/createMessage")
    public String saveComment(@ModelAttribute Comment message, HttpSession httpSession, String reviewId) {
        User userSender = (User) httpSession.getAttribute("user");
        message.setUser(userSender);
        message.setReview(reviewService.findById(Long.parseLong(reviewId)));
        message.setPublicationTime(LocalDate.now());
        commentService.save(message);
        return "redirect:/reviews/" + reviewId;
    }

}
