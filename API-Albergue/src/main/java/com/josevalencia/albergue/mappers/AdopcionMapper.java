package com.josevalencia.albergue.mappers;

import com.josevalencia.albergue.dtos.AdopcionDTO;
import com.josevalencia.albergue.entities.Adopcion;

public class AdopcionMapper {
	
	public static AdopcionDTO map(Adopcion adopcion) {
		
		
		AdopcionDTO adopcionDto = new AdopcionDTO();
		
		adopcionDto.setId(adopcion.getId());
		adopcionDto.setFechaAdopcion(adopcion.getFechaAdopcion());
		adopcionDto.setDescripcion(adopcion.getDescripcion());
		adopcionDto.setDocAdoptante(adopcion.getPersona().getNumeroDocumento());
		adopcionDto.setCorreoAdoptante(adopcion.getPersona().getCorreo());
		adopcionDto.setNombreAdoptante(adopcion.getPersona().getNombre());
		adopcionDto.setNombreMascota(adopcion.getAnimal().getNombre());
		adopcionDto.setImagenMascota(adopcion.getAnimal().getImagen());
		
		return adopcionDto;
		
	}

}
