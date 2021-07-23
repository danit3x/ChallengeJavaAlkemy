/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.services;

import com.danito.domain.GeneroModel;
import com.danito.repository.GeneroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danito
 */
@Service
public class GeneroServiceImpl implements GeneroService{
    
    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional(readOnly = true)
    public GeneroModel encontrarPorGenero(GeneroModel generoModel) {
        return generoRepository.findById(generoModel.getId()).orElse(null);
    }

    @Override
    public List<GeneroModel> obtenerGeneros() {
        return (List<GeneroModel>) generoRepository.findAll();
    }
    
}
