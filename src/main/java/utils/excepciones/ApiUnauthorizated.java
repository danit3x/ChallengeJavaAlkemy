/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author danito
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorizated extends Exception{
    public ApiUnauthorizated(String message){
        super(message);
    }
}
