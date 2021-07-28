/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danito.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author danito
 */
@Data
public class PersonajeRequest {
    
    @JsonProperty("imagen")
    private String imagen;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("edad")
    private Integer edad;
    @JsonProperty("peso")
    private Integer peso;
    @JsonProperty("historia")
    private String historia;
    @JsonProperty("peliculaId")
    private Long PeliculaId;
}
