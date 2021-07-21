
package com.danito.services;

import com.danito.domain.MovieModel;
import java.util.List;


public interface MovieService {
    
    public List<MovieModel> obtenerMovies();
    
    public void guardarMovie(MovieModel movieModel);
    
    public void eliminarMovie(MovieModel movieModel);
    
    public MovieModel encontrarMovie(MovieModel movieModel);
}