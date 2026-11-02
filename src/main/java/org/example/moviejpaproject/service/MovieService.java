package org.example.moviejpaproject.service;

import org.example.moviejpaproject.entity.Movie;
import org.example.moviejpaproject.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService{
    private MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie){
        movie.setId(null);
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id){
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Long id, Movie request){
        Movie movie = getMovie(id);

        if(movie == null){
            return null;
        }

        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setRating(request.getRating());
        movie.setReleaseYear(request.getReleaseYear());

        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Long id){
        Movie movie = getMovie(id);

        if(movie == null){
            return false;
        }

        movieRepository.deleteById(id);
        return true;
    }
}