package com.isitcom.videogamelibrary.controller;

import com.isitcom.videogamelibrary.entity.Studio;
import com.isitcom.videogamelibrary.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private StudioRepository studioRepository;

    @GetMapping
    public String listStudios(Model model) {
        model.addAttribute("studios", studioRepository.findAll());
        return "studios";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("studio", new Studio());
        return "studio_form";
    }

    @PostMapping("/save")
    public String saveStudio(@ModelAttribute Studio studio) {
        studioRepository.save(studio);
        return "redirect:/studios";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Studio s = studioRepository.findById(id).orElse(new Studio());
        model.addAttribute("studio", s);
        return "studio_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudio(@PathVariable Long id) {
        studioRepository.deleteById(id);
        return "redirect:/studios";
    }
}