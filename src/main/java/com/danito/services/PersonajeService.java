
package com.danito.services;

import com.danito.domain.PersonajeModel;
import java.util.List;


public interface PersonajeService {
    
        
    public List<PersonajeModel> obtenerPersonaje();
    
    public PersonajeModel guardarPersonaje(PersonajeModel personajeModel);
    
    public void eliminarPersonaje(PersonajeModel personajeModel);
    
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel);
    
}
