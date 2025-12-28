package com.isitcom.videogamelibrary.config;

import com.isitcom.videogamelibrary.entity.Game;
import com.isitcom.videogamelibrary.entity.Genre;
import com.isitcom.videogamelibrary.entity.Studio;
import com.isitcom.videogamelibrary.repository.GameRepository;
import com.isitcom.videogamelibrary.repository.GenreRepository;
import com.isitcom.videogamelibrary.repository.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudioRepository studioRepo;
    private final GenreRepository genreRepo;
    private final GameRepository gameRepo;

    public DataInitializer(StudioRepository studioRepo, GenreRepository genreRepo, GameRepository gameRepo) {
        this.studioRepo = studioRepo;
        this.genreRepo = genreRepo;
        this.gameRepo = gameRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (studioRepo.count() == 0 && genreRepo.count() == 0 && gameRepo.count() == 0) {
            Studio nintendo = Studio.builder().name("Nintendo").foundedYear(1889).country("Japan").build();
            Studio valve = Studio.builder().name("Valve").foundedYear(1996).country("USA").build();
            studioRepo.save(nintendo);
            studioRepo.save(valve);

            Genre action = Genre.builder().name("Action").build();
            Genre adventure = Genre.builder().name("Adventure").build();
            Genre fps = Genre.builder().name("FPS").build();
            Genre rpg = Genre.builder().name("RPG").build();
            genreRepo.saveAll(java.util.List.of(action, adventure, fps, rpg));

            Game g1 = Game.builder()
                    .title("The Legend of Zelda: Breath of the Wild")
                    .platform("Switch")
                    .releaseDate(LocalDate.of(2017,3,3))
                    .price(new BigDecimal("59.99"))
                    .description("Open world action-adventure game")
                    .studio(nintendo)
                    .genres(Set.of(action, adventure))
                    .build();

            Game g2 = Game.builder()
                    .title("Half-Life 2")
                    .platform("PC")
                    .releaseDate(LocalDate.of(2004,11,16))
                    .price(new BigDecimal("9.99"))
                    .description("Classic first-person shooter")
                    .studio(valve)
                    .genres(Set.of(fps, adventure))
                    .build();

            gameRepo.saveAll(java.util.List.of(g1, g2));
        }
    }
}