package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voluntariado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	private LocalDateTime fechaInicio;
	private String frecuencia;
	private Boolean activo;
	
	@ManyToMany
	@JoinTable(name = "VOLUNTARIO_TAREA",
		joinColumns = @JoinColumn(name = "voluntariado_id"),
		inverseJoinColumns = @JoinColumn(name = "tarea_id"))
	private List<Tarea> tareas;
	
	

}
