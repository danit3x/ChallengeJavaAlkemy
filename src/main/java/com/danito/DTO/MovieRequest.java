/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author danito
 */
@Data
public class MovieRequest implements Serializable{
        
        @JsonProperty("imagen")
        private String imagen;
	@JsonProperty("title")  
        private String title;
        @JsonProperty("createdAt")        
	private Integer createdAt;
        @JsonProperty("calificacion")    
	private Integer calificacion;
	@JsonProperty("personajeId")        
        private Integer PersonajeId;
}
