package ru.sevastopall.readersDairy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.readersDairy.model.Author;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.service.AuthorService;
import ru.sevastopall.readersDairy.service.BookService;
import ru.sevastopall.readersDairy.service.GenreService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;

    @GetMapping("/create")
    public String getAuthorCreationPage(Model model) {
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "books/create";
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute Book book, String authorFirstName, String authorLastName, String genreId) {
        Optional<Author> mayBeAuthor = authorService.findByFirstNameAndLastName(authorFirstName, authorLastName);
        if (mayBeAuthor.isPresent()) {
            book.setAuthor(mayBeAuthor.get());
        } else {
            Author newAuthor = new Author();
            newAuthor.setFirstName(authorFirstName);
            newAuthor.setLastName(authorLastName);
            Author savedAuthor = authorService.save(newAuthor);
            book.setAuthor(savedAuthor);
        }
        book.setGenre(genreService.findById(Integer.parseInt(genreId)));
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/all";
    }

    @GetMapping("/{id}")
    public String getOneBook(Model model, @PathVariable int id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.findAll());
        return "books/one";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/index";
    }
}
