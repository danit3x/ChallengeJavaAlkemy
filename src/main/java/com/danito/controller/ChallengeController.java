package com.danito.controller;

import com.danito.domain.PersonajeModel;
import com.danito.services.PersonajeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ChallengeController {

    @Autowired
    private PersonajeService personajeService;
    
    //Listar personajes
    @GetMapping("/characters")
    public List inicio(){
        return personajeService.obtenerPersonaje();
    }
    //Guardar Personaje
    @PostMapping("/charactersave")
    public PersonajeModel guardar(@RequestBody PersonajeModel personajeModel){
        return this.personajeService.guardarPersonaje(personajeModel);
    }
    //Borrar Personaje
    @GetMapping("/eliminarcharacter")
    public String eliminar(PersonajeModel personajemodel){
        personajeService.eliminarPersonaje(personajemodel);
        return "Borrado";
    }
}
