/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.services;

import com.danito.domain.PersonajeModel;
import com.danito.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danito
 */
@Service
public class PersonajeServiceImpl implements PersonajeService{
    
    @Autowired
    private PersonajeRepository personajeRepository;
    
    @Override
    public List<PersonajeModel> obtenerPersonaje() {
        return (List<PersonajeModel>) personajeRepository.findAll();
    }
    @Override
    public List<String> mostrarImagenNombre(){
        return  personajeRepository.buscarImagenNombre();
    }
    
    
    @Override
    public PersonajeModel guardarPersonaje(PersonajeModel personajeModel) {
        return personajeRepository.save(personajeModel);
        
    }

    @Override
    public void eliminarPersonaje(PersonajeModel personajeModel) {
        personajeRepository.delete(personajeModel);
    }

    @Override
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel) {
        return personajeRepository.findById(personajeModel.getId()).orElse(null);
    }
    

}
