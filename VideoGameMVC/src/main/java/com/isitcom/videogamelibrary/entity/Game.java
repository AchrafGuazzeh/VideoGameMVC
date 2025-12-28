package com.isitcom.videogamelibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"genres", "studio"})
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String title;

    private String platform; // ex: PC, PS5, Xbox, Switch (optionel champ texte)

    private LocalDate releaseDate;

    private BigDecimal price;

    @Column(length = 2000)
    private String description;

    // Many games -> one studio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id")
    private Studio studio;

    // Many-to-Many with genres
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @Builder.Default
    private Set<Genre> genres = new HashSet<>();
}