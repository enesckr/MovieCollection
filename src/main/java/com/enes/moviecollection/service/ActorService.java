package com.enes.moviecollection.service;

import com.enes.moviecollection.model.Actor;
import com.enes.moviecollection.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {
    //void addMovieToActor(Movie movie, long id);
    List<Actor> getAllActors();
    void saveActor(Actor actor,Long movieId);
    Actor getActorById(long id);
    void deleteActorById(long id);
    Page<Actor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
