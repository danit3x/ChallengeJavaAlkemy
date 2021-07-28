/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and o
pen the template in the editor.
 */
package com.danito.repository;

import com.danito.domain.PersonajeModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danito
 */
@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Long>{
    
    @Transactional(readOnly=true)
    Iterable<PersonajeModel>findByNombre(String nombre);
    
   // Optional<PersonajeModel>findByEdad(Integer edad);
    
    
    
}
