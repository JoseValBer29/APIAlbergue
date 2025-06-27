package com.josevalencia.albergue.services;

import com.josevalencia.albergue.dtos.VoluntariadoDTO;

public interface IVoluntarioService {
	
	public VoluntariadoDTO registrarVoluntario(VoluntariadoDTO Voluntariado);
	public void eliminarVoluntariado(Long id);
	public VoluntariadoDTO actualizarVoluntariado(VoluntariadoDTO Voluntariado);
	public VoluntariadoDTO obtenerVoluntariado(Long id);

}
