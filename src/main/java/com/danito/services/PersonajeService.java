
package com.danito.services;

import com.danito.domain.PersonajeModel;
import java.util.List;


public interface PersonajeService {
    
    public List<PersonajeModel> obtenerPersonaje();
    
    public void guardarPersonaje(PersonajeModel personajeModel);
    
    public void eliminarMovie(PersonajeModel personajeModel);
    
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel);
    
}
