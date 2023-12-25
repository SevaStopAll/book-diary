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
import ru.sevastopall.readersDairy.service.AuthorService;

import java.io.IOException;

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
    public String saveAuthor(@ModelAttribute Author author, @RequestParam MultipartFile file) throws IOException {
        FileDto fileDto = new FileDto();
        fileDto.setName(file.getName());
        fileDto.setContent(file.getBytes());
        authorService.save(author, fileDto);
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

    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute Author author, @RequestParam MultipartFile file ) throws IOException {
        FileDto fileDto = new FileDto();
        fileDto.setName(file.getName());
        fileDto.setContent(file.getBytes());
        authorService.save(author, fileDto);
        return "redirect:/index";
    }
}
