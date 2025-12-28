package com.isitcom.videogamelibrary.service.impl;

import com.isitcom.videogamelibrary.entity.Game;
import com.isitcom.videogamelibrary.repository.GameRepository;
import com.isitcom.videogamelibrary.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository repo;

    public GameServiceImpl(GameRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Game> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Game> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Game save(Game game) {
        return repo.save(game);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}