package com.isitcom.videogamelibrary.controller;

import com.isitcom.videogamelibrary.entity.Genre;
import com.isitcom.videogamelibrary.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genres";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre_form";
    }

    @PostMapping("/save")
    public String saveGenre(@ModelAttribute Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Genre g = genreRepository.findById(id).orElse(new Genre());
        model.addAttribute("genre", g);
        return "genre_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable Long id) {
        genreRepository.deleteById(id);
        return "redirect:/genres";
    }
}