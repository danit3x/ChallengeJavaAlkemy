/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.repository;

import com.danito.domain.MovieModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danito
 */
public interface MovieRepository extends CrudRepository<MovieModel, Long> {
    
}
