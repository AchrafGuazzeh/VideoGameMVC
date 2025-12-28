package com.isitcom.videogamelibrary.controller;

import com.isitcom.videogamelibrary.entity.Game;
import com.isitcom.videogamelibrary.entity.Genre;
import com.isitcom.videogamelibrary.repository.GameRepository;
import com.isitcom.videogamelibrary.repository.GenreRepository;
import com.isitcom.videogamelibrary.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private GenreRepository genreRepository;


    @GetMapping("/games")
    public String listGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "games";
    }


    @GetMapping("/games/new")
    public String showCreateForm(Model model) {
        Game g = new Game();
        g.setGenres(new HashSet<>());
        model.addAttribute("game", g);
        model.addAttribute("studios", studioRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "game_form";
    }


    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game,
                           @RequestParam(value = "genreIds", required = false) List<Long> genreIds) {

        Set<Genre> genres = new HashSet<>();
        if (genreIds != null) {
            for (Long gid : genreIds) {
                genreRepository.findById(gid).ifPresent(genres::add);
            }
        }
        game.setGenres(genres);

        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/save")
    public String saveGetRedirect() {
        return "redirect:/games/new";
    }


    @GetMapping("/games/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Game g = gameRepository.findById(id).orElse(new Game());
        if (g.getGenres() == null) {
            g.setGenres(new HashSet<>());
        }
        model.addAttribute("game", g);
        model.addAttribute("studios", studioRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "game_form";
    }


    @GetMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
        return "redirect:/games";
    }
}