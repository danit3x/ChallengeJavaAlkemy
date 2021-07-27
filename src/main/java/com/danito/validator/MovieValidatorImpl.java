/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.validator;

import com.danito.DTO.MovieRequest;
import org.springframework.stereotype.Component;
import utils.excepciones.ApiUnprocessableEntity;

/**
 *
 * @author danito
 */
@Component
public class MovieValidatorImpl implements MovieValidator{

    @Override
    public void validator(MovieRequest request) throws ApiUnprocessableEntity {
        
        if(request.getTitle() == null || request.getTitle().isEmpty()){
            this.message("El titulo es obligatorio");
        }
        if(request.getTitle().length() < 2){
            this.message("El titulo es muy corto");
        }
    }
    
    private void message (String message) throws ApiUnprocessableEntity{
        
        throw new ApiUnprocessableEntity(message);
    }
}
