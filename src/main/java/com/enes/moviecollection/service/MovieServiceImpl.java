package com.enes.moviecollection.service;

import java.util.List;
import java.util.Optional;

import com.enes.moviecollection.model.Movie;
import com.enes.moviecollection.repository.ActorRepository;
import com.enes.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public void addActorById(Movie movie, long id) {
        movie.getActors().add(actorRepository.getOne(id));
    }

    @Override
    public List<Movie> getAllMovies(String keyword) {
        return movieRepository.findAll();
    }

    @Override
    public void saveMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = null;
        if (optional.isPresent()) {
            movie = optional.get();
        } else {
            throw new RuntimeException(" Movie not found for id :: " + id);
        }
        return movie;
    }

    @Override
    public void deleteMovieById(long id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public Page<Movie> findPaginated(String keyword, int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        if (keyword != null) {
            return this.movieRepository.search(keyword, pageable);
        }
        return this.movieRepository.findAll(pageable);
    }
}
