package com.danito.controller;

import com.danito.DTO.PersonajeRequest;
import com.danito.services.PersonajeService;
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


@RestController
@Slf4j
@RequestMapping("/")
public class PersonajeController {

   @Autowired
    private PersonajeService personajeService;
    
    //Listado todas las propiedades de personajes
    @GetMapping(value="/showcharacter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listadoDePersonajes(){
        return ResponseEntity.ok(personajeService.obtenerPersonaje());
    }
    
    //Vista previa de personajes
    @GetMapping(value="/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List presentarPersonajes(){
        return personajeService.presentarPersonaje();
    }
    
    //Busqueda de personaje por Nombre
    @GetMapping(value = "/personajesearch{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> encontrarPorNombre(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(this.personajeService.findByNombre(nombre));
    }
    
    //Eliminar Personaje por id
    @DeleteMapping(value= "/characterdelete{idPersonaje}")
    public ResponseEntity<Object> eliminarPersonaje(@RequestParam Long idPersonaje){
        this.personajeService.eliminarPersonajePorId(idPersonaje);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    //Guardar personaje 
    @PostMapping(value="/savecharacter", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarPersonaje(@RequestBody PersonajeRequest request){
        
     //   this.personajeValidator.validator(request);
        this.personajeService.guardarPersonaje(request);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    //Actualizar personaje
    @PutMapping(value="/updateCharacter{idPersonaje}")
    public ResponseEntity<Object> updatePersonaje(@RequestBody PersonajeRequest request, @RequestParam Long idPersonaje){
        
        this.personajeService.updatePersonaje(request, idPersonaje);
        
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
}
