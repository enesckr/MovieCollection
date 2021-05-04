package com.enes.moviecollection.service;

import java.util.List;

import com.enes.moviecollection.model.Movie;
import org.springframework.data.domain.Page;


public interface MovieService {
	void addActorById(Movie movie,long id);
	List<Movie> getAllMovies(String keyword);
	void saveMovie(Movie movie);
	Movie getMovieById(long id);
	void deleteMovieById(long id);
	Page<Movie> findPaginated(String keyword,int pageNo, int pageSize, String sortField, String sortDirection);
}
