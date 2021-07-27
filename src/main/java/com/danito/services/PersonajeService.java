
package com.danito.services;

import com.danito.domain.PersonajeModel;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.List;


public interface PersonajeService {
    
        
    public List<PersonajeModel> obtenerPersonaje();
    
    public List<String> mostrarImagenNombre();
    
    public PersonajeModel guardarPersonaje(PersonajeModel personajeModel);
    
    public void eliminarPersonaje(PersonajeModel personajeModel);
    
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel);
    
   
    
}
