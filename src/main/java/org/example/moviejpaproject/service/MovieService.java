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
        return movieRepository.save(movie); // Q7. save()를 호출하면 새로운 데이터 등록과 기존 데이터 수정이 어떻게 처리되는가? 등록은 id를 null로 만들어서 jpa가 새로운 entity로 id를 판단해서 저장해서 db에서 id를 자동으로 생성해주는거고 수정은 기존 영화를 id로 조회하고 필드 값을 바꾼 다음에 save를 호출해서 기존 엔티티의 변경 내용을 반영해서 호출한다
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
    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> getMoviesByDG(String director, String genre){
        return movieRepository.findByDirectorAndGenre(director, genre);
    }
    public List<Movie> getMoviesByMinRating(Double rating){
        return movieRepository.findByRatingGreaterThanEqualOrderByRatingDesc(rating);
    }
}