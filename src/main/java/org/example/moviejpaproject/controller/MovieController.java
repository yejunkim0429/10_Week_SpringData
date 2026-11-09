package org.example.moviejpaproject.controller;

import org.example.moviejpaproject.entity.Movie;
import org.example.moviejpaproject.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie savedMovie = movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        Movie movie = movieService.getMovie(id);

        if(movie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie request){
        Movie movie = movieService.updateMovie(id,request);

        if(movie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        boolean deleted = movieService.deleteMovie(id);

        if(deleted == false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search/genre")
    public List<Movie> searchByGenre(@RequestParam("genre") String genre){
        return movieService.getMoviesByGenre(genre);
    }
    @GetMapping("/search/director-genre")
    public List<Movie> searchByDB(@RequestParam("director") String director, @RequestParam("genre") String genre){
        return movieService.getMoviesByDG(director,genre);
    }
    @GetMapping("/search/rating")
    public List<Movie> searchByRating(@RequestParam("rating") Double rating){
        return movieService.getMoviesByMinRating(rating);
    }
}
