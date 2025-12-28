package com.isitcom.videogamelibrary.service;

import com.isitcom.videogamelibrary.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<Game> findAll();
    Optional<Game> findById(Long id);
    Game save(Game game);
    void deleteById(Long id);
}