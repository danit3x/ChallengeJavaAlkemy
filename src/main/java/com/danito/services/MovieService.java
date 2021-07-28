
package com.danito.services;

import com.danito.DTO.MovieDTO;
import com.danito.DTO.MovieRequest;
import com.danito.domain.MovieModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    
    //listado de pelis
    public List<MovieModel> obtenerMovies();
    
    //Vista previa pelis
    List<MovieDTO> presentarMovies();
    
    //Busqueda Pelis
    public MovieModel encontrarMovie(MovieModel movieModel);
    //Busqueda por titulo
    MovieDTO findByTitle(String title);
    
    //Guardar pelis
    void guardarMovie(MovieRequest movieModel);
    
    //Actualizar Pelis
    void updateMovie(MovieRequest movie, Long idMovie);
    
    //eliminar Pelis
    void eliminarMoviePorId(Long idmovie);
    
    
}