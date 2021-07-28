/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.services;

import com.danito.DTO.PersonajeDTO;
import com.danito.DTO.PersonajeRequest;
import com.danito.domain.PersonajeModel;
import com.danito.repository.PersonajeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.MHelpers;

/**
 *
 * @author danito
 */
@Service
public class PersonajeServiceImpl implements PersonajeService{
    
    @Autowired
    private PersonajeRepository personajeRepository;
    
   // Lista detalles personajes
    @Override
    @Transactional(readOnly = true)
    public List<PersonajeModel> obtenerPersonaje(){
        return (List<PersonajeModel>) personajeRepository.findAll();
    }
    
    //Listar vista previa
    @Override
    public List<PersonajeDTO> presentarPersonaje() {
        
        List<PersonajeDTO> dto = new ArrayList<>();
        
        Iterable<PersonajeModel> personajes = this.personajeRepository.findAll();
        
        for(PersonajeModel personaje : personajes){
            PersonajeDTO personajeDTO = MHelpers.modelMapper().map(personaje, PersonajeDTO.class);
            dto.add(personajeDTO);
            
        }
        
        return dto;
        
    
    }

    
    // guardar Personaje
    @Override
    @Transactional
    public void guardarPersonaje(PersonajeRequest personaje) {
        
        PersonajeModel personajes = MHelpers.modelMapper().map(personaje, PersonajeModel.class);
        
        this.personajeRepository.save(personajes);
    }

    //Actualizar personaje
    @Override
    public void updatePersonaje(PersonajeRequest request, Long  idPersonaje){
        Optional<PersonajeModel> personajes= this.personajeRepository.findById(idPersonaje);
        
        PersonajeModel personaje = personajes.get();

        personaje.setImagen(request.getImagen());
        personaje.setEdad(request.getEdad());
        personaje.setHistoria(request.getHistoria());
        personaje.setNombre(request.getNombre());
        personaje.setPeso(request.getPeso());   
        
        this.personajeRepository.save(personaje);
    }
    
    // Eliminar personaje 
    @Override
    @Transactional    
    public void eliminarPersonajePorId(Long idPersonaje) {
        this.personajeRepository.deleteById(idPersonaje);
    }
    
    
    //Busqueda de personaje
    @Override
    @Transactional(readOnly = true)
    public PersonajeModel encontrarPersonaje(PersonajeModel personajeModel) {
        return personajeRepository.findById(personajeModel.getId()).orElse(null);
    }
    //Busqueda personaje por nombre
    @Override
    public List<PersonajeDTO> findByNombre(String nombre) {
        
        List<PersonajeDTO> dto = new ArrayList<>();
        
        Iterable<PersonajeModel> personajes = this.personajeRepository.findByNombre(nombre);
        
        for(PersonajeModel personaje : personajes){
            PersonajeDTO personajeDTO = MHelpers.modelMapper().map(personaje, PersonajeDTO.class);
            dto.add(personajeDTO);
            
        }

        return dto;
        
    
    }
    @Override
    public PersonajeDTO findByEdad(Integer edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonajeDTO findByPeliculaId(Long idPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    



}
