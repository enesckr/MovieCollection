package com.enes.moviecollection;

import com.enes.moviecollection.model.Actor;
import com.enes.moviecollection.model.Movie;
import com.enes.moviecollection.model.Role;
import com.enes.moviecollection.model.User;
import com.enes.moviecollection.repository.ActorRepository;
import com.enes.moviecollection.repository.MovieRepository;
import com.enes.moviecollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MovieCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCollectionApplication.class, args);
    }

}
