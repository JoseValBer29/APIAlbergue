package com.josevalencia.albergue.mappers;

import java.util.ArrayList;
import java.util.List;

import com.josevalencia.albergue.dtos.VoluntariadoDTO;
import com.josevalencia.albergue.entities.Tarea;
import com.josevalencia.albergue.entities.Voluntariado;

public class VoluntariadoMapper {
	
	public static VoluntariadoDTO map(Voluntariado voluntariado) {
		
		VoluntariadoDTO voluntariadoDto = new VoluntariadoDTO();
		
		List<String> tareas = new ArrayList<>();
		for(Tarea tarea:voluntariado.getTareas()) {
			tareas.add(tarea.getNombre());
		}
		
		voluntariadoDto.setId(voluntariado.getId());
		voluntariadoDto.setNombreVoluntario(voluntariado.getPersona().getNombre());
		voluntariadoDto.setDocumentoVoluntario(voluntariado.getPersona().getNumeroDocumento());
		voluntariadoDto.setCorreoVoluntario(voluntariado.getPersona().getCorreo());
		voluntariadoDto.setFechaInicio(voluntariado.getFechaInicio());
		voluntariadoDto.setFrecuencia(voluntariado.getFrecuencia());
		voluntariadoDto.setActivo(voluntariado.getActivo()?"Activo":"Inactivo");
		voluntariadoDto.setTareas(tareas);
		
		return voluntariadoDto;
		
	}
	
	public static Voluntariado map(VoluntariadoDTO voluntariadoDto) {
		
		Voluntariado voluntariado = new Voluntariado();
		
		voluntariado.setId(voluntariadoDto.getId());
		voluntariado.setFechaInicio(voluntariadoDto.getFechaInicio());
		voluntariado.setFrecuencia(voluntariadoDto.getFrecuencia());
		voluntariado.setActivo(voluntariadoDto.getActivo()=="Activo"?true:false);
		
		return voluntariado;
		
		
	}

}
