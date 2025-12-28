```markdown
# Video Game Library - Mini-projet Spring Boot (Thymeleaf + JPA)

But:
- Gérer une bibliothèque de jeux vidéo (entités : Game, Studio, Genre).
- Relations : Studio (1..*) Game, Game (*..*) Genre.

Dépendances :
- Lombok, Thymeleaf, Spring Web, Spring Data JPA, MySQL (ou H2 pour tests).

Structure (conforme à l'exemple demandé) :
- src/main/java/com/isitcom/videogamelibrary/
  - controller/  -> contrôleurs MVC (GameController, StudioController, GenreController)
  - entity/      -> entités JPA (Game, Studio, Genre)
  - repository/  -> interfaces JpaRepository
  - service/     -> services (GameService + impl)
  - config/      -> DataInitializer pour données de démo
  - VideoGameLibraryApplication.java
- src/main/resources/
  - templates/   -> vues Thymeleaf (games.html, game_form.html, studios..., genres...)
  - static/css/style.css
  - application.properties

Démarrage :
1. Modifier src/main/resources/application.properties avec ta configuration MySQL (url, username, password).
   - Ou utiliser H2 pour tests rapides (commenter MySQL et décommenter la section H2 fournie).
2. Lancer :
   - mvn spring-boot:run
   - ou exécuter la classe VideoGameLibraryApplication depuis l'IDE.
3. Accéder à :
   - http://localhost:8080/games
   - http://localhost:8080/studios
   - http://localhost:8080/genres

Remarques :
- J'ai ajouté un DataInitializer qui insère des studios, genres et quelques jeux si la base est vide.
- Utilise le plugin Lombok dans ton IDE pour éviter les problèmes (Getters/Setters générés).
- Tu peux enrichir le projet : validation (@Valid), pagination, recherche, upload d'images, sécurité.
```