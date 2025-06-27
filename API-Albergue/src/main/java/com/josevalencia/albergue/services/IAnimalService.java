package com.josevalencia.albergue.services;

import java.util.List;

import com.josevalencia.albergue.dtos.AnimalDTO;

public interface IAnimalService {
	
	public AnimalDTO registrarAnimal(AnimalDTO animal);
	public void eliminarAnimal(Long id);
	public AnimalDTO actualizarAnimal(AnimalDTO animal);
	public AnimalDTO obtenerAnimal(Long id);

}
