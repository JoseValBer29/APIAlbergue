package com.josevalencia.albergue.services;

import com.josevalencia.albergue.dtos.ApadrinamientoDTO;

public interface IApadrinameintoService {
	
	public ApadrinamientoDTO registrarApadrinamiento(ApadrinamientoDTO apadrinameinto);
	public void eliminarApadrinamiento(Long id);
	public ApadrinamientoDTO actualizarApadrinamiento(ApadrinamientoDTO apadrinamiento);
	public ApadrinamientoDTO obtenerApadrinamiento(Long id);

}
