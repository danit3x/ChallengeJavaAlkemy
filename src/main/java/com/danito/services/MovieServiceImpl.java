
package com.danito.services;

import com.danito.DTO.MovieDTO;
import com.danito.DTO.MovieRequest;
import com.danito.domain.MovieModel;
import com.danito.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.MHelpers;


@Service
public class MovieServiceImpl implements MovieService{
    
    @Autowired
    private MovieRepository movieRepository;
    
    // Listar movies o series
    @Override
    @Transactional(readOnly = true)
    public List<MovieModel> obtenerMovies(){
        return (List<MovieModel>) movieRepository.findAll();
    }
    
    //Listar vista previa
    @Override
    public List<MovieDTO> presentarMovies() {
        
        List<MovieDTO> dto = new ArrayList<>();
        
        Iterable<MovieModel> movie = this.movieRepository.findAll();
        
        for(MovieModel movies : movie){
            MovieDTO moviesDTO = MHelpers.modelMapper().map(movies, MovieDTO.class);
            dto.add(moviesDTO);
            
        }
        
        return dto;
        
    
    }

    
    // Persistencia de Movie o Series
    @Override
    @Transactional
    public void guardarMovie(MovieRequest movie) {
        
        MovieModel movies = MHelpers.modelMapper().map(movie, MovieModel.class);
        
        this.movieRepository.save(movies);
    }

    //Actualizar peli
    @Override
    public void updateMovie(MovieRequest request, Long  idMovie){
        Optional<MovieModel> movies= this.movieRepository.findById(idMovie);
        
        MovieModel movie = movies.get();

        movie.setCalificacion(request.getCalificacion());
        movie.setCreatedAt(request.getCreatedAt());
        movie.setImagen(request.getImagen());
        movie.setTitle(request.getTitle());
        movie.setPersonajeId(request.getPersonajeId());
        
        this.movieRepository.save(movie);
    }
    
    // Eliminar Pelicula 
    @Override
    @Transactional    
    public void eliminarMoviePorId(Long idmovie) {
        this.movieRepository.deleteById(idmovie);
    }
    
    
    //Busqueda de Pelicula
    @Override
    @Transactional(readOnly = true)
    public MovieModel encontrarMovie(MovieModel movieModel) {
        return movieRepository.findById(movieModel.getId()).orElse(null);
    }
    //Busqueda pelicula por titulo
    @Override
    public MovieDTO findByTitle(String title) {
        Optional<MovieModel> movie = this.movieRepository.findByTitle(title);
        
        if(!movie.isPresent()){
            return null;
        }
        
        return MHelpers.modelMapper().map(movie.get(), MovieDTO.class);
    }
    
    private MovieDTO convertiraDTO(final MovieModel movieModel){
        return MHelpers.modelMapper().map(movieModel, MovieDTO.class);
    }


}