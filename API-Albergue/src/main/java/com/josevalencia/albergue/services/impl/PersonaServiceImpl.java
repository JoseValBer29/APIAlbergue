package com.josevalencia.albergue.services.impl;

import java.util.List;

import com.josevalencia.albergue.dtos.PersonaDTO;
import com.josevalencia.albergue.entities.Persona;
import com.josevalencia.albergue.exceptions.AlreadyExistsException;
import com.josevalencia.albergue.exceptions.NotFoundException;
import com.josevalencia.albergue.mappers.PersonaMapper;
import com.josevalencia.albergue.repositories.PersonaRepository;
import com.josevalencia.albergue.services.IPersonaService;

public class PersonaServiceImpl  implements IPersonaService{
	
	private PersonaRepository personaRepo;
	
	public PersonaDTO registrarPersona(PersonaDTO personaDto) throws AlreadyExistsException{
		
		Persona persona = new Persona();
		
		List<Persona> personas = personaRepo.findAllByNumeroDocumento(
				personaDto.getNumeroDocumento());
		
		if (personas.isEmpty()) {
			persona = PersonaMapper.map(personaDto);
			return PersonaMapper.map(personaRepo.save(persona));
		}else {
			throw new AlreadyExistsException("La persona con Documento "
					+ personaDto.getNumeroDocumento()
					+ " ya existe");
		}
		
	}
	
	public void eliminarPersona(Long id) {
		
		personaRepo.deleteById(id);
		
	}
	
	public PersonaDTO actualizarPersona(PersonaDTO personaDto) throws NotFoundException {
		
		Persona persona = new Persona();
		
		List<Persona> personas = personaRepo.findAllByNumeroDocumento(
				personaDto.getNumeroDocumento());
		
		if(!personas.isEmpty()) {
			persona = PersonaMapper.map(personaDto);
			return PersonaMapper.map(personaRepo.save(persona));
		}else {
			throw new NotFoundException(
					"no se encuentra la persona con Documento" 
					+ personaDto.getNumeroDocumento()
					);
		}
		
	}
	public PersonaDTO obtenerPersona(Long id) {
		
		Persona persona = personaRepo.findById(id)
				.orElseThrow(()-> new NotFoundException("Persona no encontrada"));
		
		return PersonaMapper.map(persona);
		
	}
	
	

}
