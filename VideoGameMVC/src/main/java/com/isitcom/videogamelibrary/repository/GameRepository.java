package com.isitcom.videogamelibrary.repository;

import com.isitcom.videogamelibrary.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}