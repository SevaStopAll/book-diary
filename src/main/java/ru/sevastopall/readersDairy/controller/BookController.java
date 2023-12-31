package ru.sevastopall.readersDairy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.readersDairy.dto.FileDto;
import ru.sevastopall.readersDairy.model.Author;
import ru.sevastopall.readersDairy.model.Book;
import ru.sevastopall.readersDairy.service.AuthorService;
import ru.sevastopall.readersDairy.service.BookService;
import ru.sevastopall.readersDairy.service.GenreService;
import ru.sevastopall.readersDairy.service.ReviewService;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;
    private final ReviewService reviewService;

    @GetMapping("/create")
    public String getAuthorCreationPage(Model model) {
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "books/create";
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute Book book, String authorFirstName, String authorLastName, String genreId, @RequestParam MultipartFile file) throws IOException {
        Optional<Author> mayBeAuthor = authorService.findByFirstNameAndLastName(authorFirstName, authorLastName);
        if (mayBeAuthor.isPresent()) {
            book.setAuthor(mayBeAuthor.get());
        } else {
            Author newAuthor = new Author();
            newAuthor.setFirstName(authorFirstName);
            newAuthor.setLastName(authorLastName);
            FileDto fileDtoAuthor = new FileDto();
            fileDtoAuthor.setName("empty");
            Author savedAuthor = authorService.save(newAuthor, new FileDto());
            book.setAuthor(savedAuthor);
        }
        book.setGenre(genreService.findById(Integer.parseInt(genreId)));
        FileDto fileDto = new FileDto();
        fileDto.setName(file.getName());
        fileDto.setContent(file.getBytes());
        bookService.save(book, fileDto);
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
        model.addAttribute("reviews", reviewService.findByBook(book));
        return "books/one";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book, @RequestParam MultipartFile file) throws IOException {
        FileDto fileDto = new FileDto();
        fileDto.setName(file.getName());
        fileDto.setContent(file.getBytes());
        bookService.save(book, fileDto);
        return "redirect:/";
    }
}
