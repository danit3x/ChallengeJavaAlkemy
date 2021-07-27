/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and o
pen the template in the editor.
 */
package com.danito.repository;

import com.danito.domain.PersonajeModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danito
 */
@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeModel, Long>{
    
        
    @Query(value= "SELECT imagen FROM personaje_model UNION SELECT nombre  FROM personaje_model" , nativeQuery = true)
    public List<String> buscarImagenNombre();
    
    
    
}
