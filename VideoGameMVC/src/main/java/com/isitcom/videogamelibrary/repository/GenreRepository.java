package com.isitcom.videogamelibrary.repository;

import com.isitcom.videogamelibrary.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}