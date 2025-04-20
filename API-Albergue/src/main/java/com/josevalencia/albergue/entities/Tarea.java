package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nombre;
	
	@ManyToMany(mappedBy = "tareas")
	private List<Voluntariado> voluntariados;

}
