package com.enes.moviecollection.service;

import com.enes.moviecollection.model.Actor;
import com.enes.moviecollection.model.Movie;
import com.enes.moviecollection.repository.ActorRepository;
import com.enes.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

//    @Override
//    public void addMovieToActor(Movie movie, long id) {
//        Actor actor = getActorById(id);
//        movie.getActors().add(actor);
//        movieRepository.saveAndFlush(movie);
//    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public void saveActor(Actor actor, Long movieId) {
        Movie movie = movieRepository.getOne(movieId);
        actor.getMovies().add(movie);
        this.actorRepository.save(actor);
    }

    @Override
    public Actor getActorById(long id) {
        Optional<Actor> optional = actorRepository.findById(id);
        Actor actor = null;
        if (optional.isPresent()) {
            actor = optional.get();
        } else {
            throw new RuntimeException(" Actor not found for id : " + id);
        }
        return actor;
    }

    @Override
    public void deleteActorById(long id) {
        this.actorRepository.deleteById(id);
    }

    @Override
    public Page<Actor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.actorRepository.findAll(pageable);
    }
}
