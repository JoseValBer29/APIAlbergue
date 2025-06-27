package com.josevalencia.albergue.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoluntariadoDTO {
	
	private Long id;
	private String nombreVoluntario;
	private String apellidoVoluntario;
	private String documentoVoluntario;
	private String correoVoluntario;
	private LocalDateTime fechaInicio;
	private String frecuencia;
	private String activo;
	private List<String> tareas;
	

}
