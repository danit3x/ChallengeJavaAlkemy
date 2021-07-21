/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.services;

import com.danito.domain.GeneroModel;
import com.danito.repository.GeneroRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;
    
    public ArrayList<GeneroModel> obtenerGeneros(){
        return (ArrayList<GeneroModel>) generoRepository.findAll();
    }
}
