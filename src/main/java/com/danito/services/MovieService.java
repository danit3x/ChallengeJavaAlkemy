
package com.danito.services;

import com.danito.domain.MovieModel;
import com.danito.repository.MovieRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    
    public ArrayList<MovieModel> obtenerMovies(){
        return (ArrayList<MovieModel>) movieRepository.findAll();
    }
}
