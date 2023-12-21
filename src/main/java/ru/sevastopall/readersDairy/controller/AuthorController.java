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
import ru.sevastopall.readersDairy.service.AuthorService;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/create")
    public String getAuthorCreationPage() {
        return "authors/create";
    }

    @PostMapping("/create")
    public String saveAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAuthorList(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/all";
    }

    @GetMapping("/{id}")
    public String getOneAuthor(Model model, @PathVariable int id) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors/one";
    }
    //TODO забить форму по умолчанию в ДАТУ РОЖДЕНИЯ
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/index";
    }
}