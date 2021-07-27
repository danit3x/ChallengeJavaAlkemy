package com.danito.controller;

import com.danito.DTO.MovieRequest;
import com.danito.domain.MovieModel;
import com.danito.domain.PersonajeModel;
import com.danito.services.MovieService;
import com.danito.services.PersonajeService;
import com.danito.validator.MovieValidatorImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.excepciones.ApiUnprocessableEntity;


@RestController
@Slf4j
@RequestMapping("/")
public class ChallengeController {

    @Autowired
    private PersonajeService personajeService;
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private MovieValidatorImpl movieValidator;
    
    //Listar personajes
    @GetMapping("/allcharacters")
    public List inicio(){
        return personajeService.obtenerPersonaje();
    }
    //*****  Falta responder en formato JSON ***********
    @GetMapping("/characters")
    public List presentacionCharacters(){
        return personajeService.mostrarImagenNombre();
    }
    //Guardar Personaje
    @PostMapping("/charactersave")
    public PersonajeModel guardar(@RequestBody PersonajeModel personajeModel){
        return this.personajeService.guardarPersonaje(personajeModel);
    }
    //Borrar Personaje
    @GetMapping("/eliminarcharacter")
    public String eliminar(@RequestParam PersonajeModel personajemodel){
        personajeService.eliminarPersonaje(personajemodel);
        return "Borrado";
    }
    //Update Personaje
//    @GetMapping("/characterupdate")
//    public PersonajeModel modificarPersona
    
    //------------------------------
    //- ---------- Movies ----------
    
    //Listado todas las propiedades de peli
    @GetMapping(value="/showmovies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listadoDeMovies(){
        return ResponseEntity.ok(movieService.obtenerMovies());
    }
    
    @GetMapping(value="/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List presentarLasMovies(){
        return movieService.presentarMovies();
    }
    
    @GetMapping(value = "/moviesearch{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> encontrarPorTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(this.movieService.findByTitle(title));
    }
    
    //Eliminar Peli por id
    @DeleteMapping(value= "/moviedelete{idmovie}")
    public ResponseEntity<Object> eliminarMovie(@RequestParam Long idmovie){
        this.movieService.eliminarMoviePorId(idmovie);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @PostMapping(value="/savemovie", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarPeli(@RequestBody MovieRequest request) throws ApiUnprocessableEntity{
        
        this.movieValidator.validator(request);
        this.movieService.guardarMovie(request);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @PutMapping(value="/updatemovie{idmovie}")
    public ResponseEntity<Object> updateMovie(@RequestBody MovieRequest request, @RequestParam Long idMovie){
        
        this.movieService.updateMovie(request, idMovie);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
}
