package com.enes.moviecollection.repository;

import com.enes.moviecollection.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT distinct (m) FROM Movie m join Actor a on (m.id=a.movieId) WHERE CONCAT(m.name, ' ', m.type, ' ',a.firstName,' ',a.lastName ) LIKE %?1%")
    //@Query("SELECT m FROM Movie m WHERE CONCAT(m.name, ' ', m.type ) LIKE %?1%")
    Page<Movie> search(String keyword, Pageable pageable);
}
