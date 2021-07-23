

package com.danito.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="personaje_model")
public class PersonajeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true, nullable = false)
    private Long id;
    @Column(name="imagen")
    private String imagen;
    @Column(name="nombre")
    private String nombre;
    @Column(name="edad")
    private Integer edad;
    @Column(name="peso")
    private Integer peso;
    @Column(name="historia")
    private String historia;
    @Column(name="pelicula_id")
    private Long PeliculaId;
}
