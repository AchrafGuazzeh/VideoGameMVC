package com.isitcom.videogamelibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"games"})
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private Integer foundedYear;

    private String country;

    // One studio -> many games
    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Game> games = new ArrayList<>();
}