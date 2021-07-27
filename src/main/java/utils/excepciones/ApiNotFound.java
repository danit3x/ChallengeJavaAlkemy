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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception {
    public ApiNotFound(String message){
        super(message);
    }
}
