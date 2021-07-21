
package com.danito.services;

import com.danito.domain.MovieModel;
import com.danito.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<MovieModel> obtenerMovies(){
        return (List<MovieModel>) movieRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarMovie(MovieModel movieModel) {
        movieRepository.save(movieModel);
    }

    @Override
    @Transactional    
    public void eliminarMovie(MovieModel movieModel) {
        movieRepository.delete(movieModel);
    }

    @Override
    @Transactional(readOnly = true)
    public MovieModel encontrarMovie(MovieModel movieModel) {
        return movieRepository.findById(movieModel.getId()).orElse(null);
    }
    
    
}
