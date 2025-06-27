package com.josevalencia.albergue.services;

import com.josevalencia.albergue.dtos.PersonaDTO;


public interface IPersonaService {
	
	public PersonaDTO registrarPersona(PersonaDTO persona);
	public void eliminarPersona(Long id);
	public PersonaDTO actualizarPersona(PersonaDTO persona);
	public PersonaDTO obtenerPersona(Long id);

}
