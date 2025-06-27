package com.josevalencia.albergue.mappers;

import com.josevalencia.albergue.dtos.ApadrinamientoDTO;
import com.josevalencia.albergue.entities.Apadrinamiento;

public class ApadrinamientoMapper {
	
	public static ApadrinamientoDTO map(Apadrinamiento padrino){
		
		
		ApadrinamientoDTO padrinoDto = new ApadrinamientoDTO();
		
		padrinoDto.setId(padrino.getId());
		padrinoDto.setNombrePadrino(padrino.getPersona().getNombre());
		padrinoDto.setDocumentoPadrino(padrino.getPersona().getNumeroDocumento());
		padrinoDto.setCorreoPadrino(padrino.getPersona().getCorreo());
		padrinoDto.setNombreMascota(padrino.getAnimal().getNombre());
		padrinoDto.setCodigoMascota(padrino.getAnimal().getCodigo());
		padrinoDto.setImagenMascota(padrino.getAnimal().getImagen());
		padrinoDto.setFechaInicio(padrino.getFechaInicio());
		padrinoDto.setTipo(padrino.getTipoApadrinamiento().getDescripcion());
		padrinoDto.setMonto(padrino.getMontoMensual());
		padrinoDto.setObservaciones(padrino.getObservaciones());
		
		return padrinoDto;
		
		
	}
	
	public static Apadrinamiento map(ApadrinamientoDTO padrinoDto) {
	
		Apadrinamiento padrino = new Apadrinamiento();
		
		padrino.setId(padrinoDto.getId());
		padrino.setFechaInicio(padrinoDto.getFechaInicio());
		padrino.setMontoMensual(padrinoDto.getMonto());
		padrino.setObservaciones(padrinoDto.getObservaciones());
		
		return padrino;
		
	}
	

}
