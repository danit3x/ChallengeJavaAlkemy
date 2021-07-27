/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.repository;

import com.danito.domain.MovieModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danito
 */
@Repository
public interface MovieRepository extends CrudRepository<MovieModel, Long> {
    
    
    
    @Transactional(readOnly=true)
    Optional<MovieModel>findByTitle(String titulo);
    
}
