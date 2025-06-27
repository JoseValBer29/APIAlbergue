package com.josevalencia.albergue.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {
	
	private Long id;
	private String codigo;
	private String nombre;
	private String especie;
	private String raza;
	private Integer edad;
	private String sexo;
	private Float peso;
	private Float tamano;
	private String estado;
	private LocalDateTime fechaIngreso;
	private String imagen;
	private String descripcion;

}
