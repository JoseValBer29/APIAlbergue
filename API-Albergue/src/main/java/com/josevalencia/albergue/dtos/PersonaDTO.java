package com.josevalencia.albergue.dtos;

import java.util.List;

import com.josevalencia.albergue.entities.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
	
	private Long id;
	private String nombre;
	private String numeroDocumento;
	private String apellido;
	private String correo;
	private String telefono;
	private String direccion;
	private List<Rol> roles;

}
