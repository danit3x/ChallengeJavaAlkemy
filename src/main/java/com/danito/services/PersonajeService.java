
package com.danito.services;

import com.danito.DTO.PersonajeDTO;
import com.danito.DTO.PersonajeRequest;
import com.danito.domain.PersonajeModel;
import java.util.List;


public interface PersonajeService {
    
    //listado de personajes
    public List<PersonajeModel> obtenerPersonaje();
    
    //Vista previa Personajes
    List<PersonajeDTO> presentarPersonaje();
    
    //Busqueda personaje
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel);
    
    //Busqueda personaje por nombre
    public List<PersonajeDTO> findByNombre(String nombre);
    
    //Busqueda personaje por edad
    PersonajeDTO findByEdad(Integer edad);
    
    //busqueda de personajes por pelicula
    PersonajeDTO findByPeliculaId(Long idPelicula);
    
    //Guardar personajes
    void guardarPersonaje(PersonajeRequest personajeModel);
    
    //Actualizar personajes
    void updatePersonaje(PersonajeRequest personaje, Long idPersonaje);
    
    //eliminar personajes
    void eliminarPersonajePorId(Long idPersonaje);
   
    
}
