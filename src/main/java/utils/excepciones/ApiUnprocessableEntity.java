/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** excepcion personalizada status422
 *
 * @author danito
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{
    
    public ApiUnprocessableEntity(String message) {
        super(message);
    }
}
