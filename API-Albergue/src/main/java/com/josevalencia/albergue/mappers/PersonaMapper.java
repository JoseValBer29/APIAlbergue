package com.josevalencia.albergue.mappers;

import com.josevalencia.albergue.dtos.PersonaDTO;
import com.josevalencia.albergue.entities.Persona;

public class PersonaMapper {
	
	public static PersonaDTO map(Persona persona) {
		
		PersonaDTO personaDto = new PersonaDTO();
		
		personaDto.setId(persona.getId());
		personaDto.setNombre(persona.getNombre());
		personaDto.setApellido(persona.getApellido());
		personaDto.setNumeroDocumento(persona.getNumeroDocumento());
		personaDto.setCorreo(persona.getCorreo());
		personaDto.setTelefono(persona.getTelefono());
		personaDto.setDireccion(persona.getDireccion());
		personaDto.setRoles(persona.getRoles());
		
		return personaDto;
		
	}
	
	public static Persona map(PersonaDTO personaDto) {
		Persona persona = new Persona();
		
		persona.setId(personaDto.getId());
		persona.setNombre(personaDto.getNombre());
		persona.setApellido(personaDto.getNombre());
		persona.setNumeroDocumento(personaDto.getNumeroDocumento());
		persona.setCorreo(personaDto.getCorreo());
		persona.setTelefono(persona.getTelefono());
		persona.setDireccion(personaDto.getDireccion());
		persona.setRoles(personaDto.getRoles());
		
		
		return persona;
	}

}
