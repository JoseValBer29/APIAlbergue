package com.josevalencia.albergue.services.impl;

import java.util.List;

import com.josevalencia.albergue.dtos.ApadrinamientoDTO;
import com.josevalencia.albergue.entities.Animal;
import com.josevalencia.albergue.entities.Apadrinamiento;
import com.josevalencia.albergue.entities.Persona;
import com.josevalencia.albergue.entities.TipoApadrinamiento;
import com.josevalencia.albergue.exceptions.NotFoundException;
import com.josevalencia.albergue.mappers.ApadrinamientoMapper;
import com.josevalencia.albergue.repositories.AnimalRepository;
import com.josevalencia.albergue.repositories.ApadrinamientoRepository;
import com.josevalencia.albergue.repositories.PersonaRepository;
import com.josevalencia.albergue.repositories.TipoRepository;

public class ApadrinamientoServiceImpl {
	
	private PersonaRepository personaRepo;
	private ApadrinamientoRepository apadrinamientoRepo;
	private TipoRepository tipoRepo;
	private AnimalRepository animalRepo;
	
	
	public ApadrinamientoDTO registrarApadrinamiento(ApadrinamientoDTO apadrinamDto) {
		
		Persona padrino = new Persona();
		Apadrinamiento apadrinamiento = new Apadrinamiento();
		Animal animal = new Animal();
		TipoApadrinamiento tipo = new TipoApadrinamiento();
		
		
		
		List<Persona> persona = personaRepo.findAllByNumeroDocumento(
				apadrinamDto.getDocumentoPadrino());
		
		
		if(!persona.isEmpty()){
			
			
			apadrinamiento = ApadrinamientoMapper.map(apadrinamDto);
			
			padrino = personaRepo.findByNumeroDocumento(
					apadrinamDto.getDocumentoPadrino());
			
			animal = animalRepo.findByCodigo(
					apadrinamDto.getCodigoMascota());
			
			tipo = tipoRepo.findByNombre(
					apadrinamDto.getTipo());			
			
			apadrinamiento.setPersona(padrino);
			apadrinamiento.setAnimal(animal);
			apadrinamiento.setTipoApadrinamiento(tipo);
			
			return ApadrinamientoMapper.map(apadrinamientoRepo.save(apadrinamiento));
		}else{
			throw new NotFoundException("La persona a la que se le desea hacer" +
						" padrino/madrina no existe");
		}
		
	}
	
	public void eliminarApadrinamiento(Long id) {
		apadrinamientoRepo.deleteById(id);
	}
	public ApadrinamientoDTO actualizarApadrinamiento(ApadrinamientoDTO apadrinamDto) {
		
		Persona padrino = new Persona();
		Apadrinamiento apadrinamiento = new Apadrinamiento();
		Animal animal = new Animal();
		TipoApadrinamiento tipo = new TipoApadrinamiento();
		
		
		List<Apadrinamiento> apadrinamientos = apadrinamientoRepo.findAllById(
				apadrinamDto.getId());
		
		if(!apadrinamientos.isEmpty()) {
			apadrinamiento = ApadrinamientoMapper.map(apadrinamDto);
			
			padrino = personaRepo.findByNumeroDocumento(apadrinamDto.getDocumentoPadrino());
			animal = animalRepo.findByCodigo(apadrinamDto.getCodigoMascota());
			tipo = tipoRepo.findByNombre(apadrinamDto.getTipo());
			
			
			apadrinamiento.setPersona(padrino);
			apadrinamiento.setAnimal(animal);
			apadrinamiento.setTipoApadrinamiento(tipo);
			
			return ApadrinamientoMapper.map(apadrinamientoRepo.save(apadrinamiento));
		}else{
			throw new NotFoundException("No existe el apadrinamiento con id: " 
					+ apadrinamDto.getId());
		}
		
		
		
	}
	public ApadrinamientoDTO obtenerApadrinamiento(Long id) {
		
		Apadrinamiento apadrinamiento = apadrinamientoRepo.findById(id).
				orElseThrow(()-> new NotFoundException("Apadrinamiento no encontrado"));
		
		return ApadrinamientoMapper.map(apadrinamiento);
	}

}
