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
@Table(name="movie")
public class MovieModel implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id",unique = true)
        private Long id;
	
        @Column(name="imagen")
        private String imagen;
	
        @Column(name="title", nullable = false)
        private String title;
        
        @Column(name="created_at")
	private Integer createdAt;
        
        @Column(name="calificacion")
	private Integer calificacion;
	
        @Column(name="personaje_id")
        private Integer PersonajeId;
	
	
	
}
