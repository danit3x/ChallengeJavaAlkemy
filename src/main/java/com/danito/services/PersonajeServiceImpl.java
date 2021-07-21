/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.services;

import com.danito.domain.PersonajeModel;
import com.danito.repository.PersonajeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author danito
 */
@Service
public class PersonajeServiceImpl implements PersonajeService{

    private PersonajeRepository personajeRepository;
    
    @Override
    public List<PersonajeModel> obtenerPersonaje() {
        return (List<PersonajeModel>) personajeRepository.findAll();
    }

    @Override
    public void guardarPersonaje(PersonajeModel personajeModel) {
        personajeRepository.save(personajeModel);
    }

    @Override
    public void eliminarMovie(PersonajeModel personajeModel) {
        personajeRepository.delete(personajeModel);
    }

    @Override
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel) {
        return personajeRepository.findById(personajeModel.getId()).orElse(null);
    }
    
}
