package com.josevalencia.albergue.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.josevalencia.albergue.dtos.VoluntariadoDTO;
import com.josevalencia.albergue.entities.Persona;
import com.josevalencia.albergue.entities.Tarea;
import com.josevalencia.albergue.entities.Voluntariado;
import com.josevalencia.albergue.exceptions.AlreadyExistsException;
import com.josevalencia.albergue.exceptions.NotFoundException;
import com.josevalencia.albergue.mappers.VoluntariadoMapper;
import com.josevalencia.albergue.repositories.PersonaRepository;
import com.josevalencia.albergue.repositories.TareaRepository;
import com.josevalencia.albergue.repositories.VoluntariadoRepository;
import com.josevalencia.albergue.services.IVoluntarioService;

public class VoluntariadoServiceImpl implements IVoluntarioService{
	
	private PersonaRepository personaRepo;
	private VoluntariadoRepository voluntariadoRepo;
	private TareaRepository tareaRepo;
	
	
	public VoluntariadoDTO registrarVoluntario(VoluntariadoDTO voluntariadoDto) 
						throws NotFoundException, AlreadyExistsException{
		
		Persona voluntario = new Persona();
		Voluntariado voluntariado = new Voluntariado();
		List<Tarea> tareasVoluntariado = new ArrayList<>();
		
		
		
		List<Persona> persona = personaRepo.findAllByNumeroDocumento(
				voluntariadoDto.getDocumentoVoluntario());
		
		
		if(!persona.isEmpty()){
			
			
			voluntariado = VoluntariadoMapper.map(voluntariadoDto);
			
			voluntario = personaRepo.findByNumeroDocumento(
					voluntariadoDto.getDocumentoVoluntario());
			tareasVoluntariado = tareaRepo.findAllByNombre(voluntariadoDto.getTareas());
			
			
			
			voluntariado.setPersona(voluntario);
			voluntariado.setTareas(tareasVoluntariado);
			
			return VoluntariadoMapper.map(voluntariadoRepo.save(voluntariado));
		}else{
			throw new NotFoundException("La persona a la que se le desea asignar" +
						" el voluntariado no existe");
		}
		
	}
	
	public void eliminarVoluntariado(Long id) {
		voluntariadoRepo.deleteById(id);
	}
	
	
	public VoluntariadoDTO actualizarVoluntariado(VoluntariadoDTO voluntariadoDto) 
															throws NotFoundException{
		
		Voluntariado voluntariado = new Voluntariado();
		Persona voluntario = new Persona();
		List<Tarea> tareasVoluntariado = new ArrayList<>();
		
		List<Voluntariado> voluntariados = voluntariadoRepo.findAllById(voluntariadoDto.getId());
		
		if(!voluntariados.isEmpty()) {
		
			voluntariado = VoluntariadoMapper.map(voluntariadoDto);
			
			voluntario = personaRepo.findByNumeroDocumento(
					voluntariadoDto.getDocumentoVoluntario());
			tareasVoluntariado = tareaRepo.findAllByNombre(voluntariadoDto.getTareas());
			
			voluntariado.setPersona(voluntario);
			voluntariado.setTareas(tareasVoluntariado);
			
			return VoluntariadoMapper.map(voluntariadoRepo.save(voluntariado));
		}else {
			throw new NotFoundException("No existe el voluntariado con id: " 
										+ voluntariadoDto.getId());
		}
		
	}
	
	public VoluntariadoDTO obtenerVoluntariado(Long id) {
		Voluntariado voluntariado = voluntariadoRepo.findById(id).
				orElseThrow(()-> new NotFoundException("Voluntariado no encontrado"));
		
		return VoluntariadoMapper.map(voluntariado);
		
		
	}
	
	

}
