package com.josevalencia.albergue.mappers;

import com.josevalencia.albergue.dtos.AnimalDTO;
import com.josevalencia.albergue.entities.Animal;

public class AnimalMapper {
	
	public static AnimalDTO map(Animal animal) {
		AnimalDTO animalDto = new AnimalDTO();
		
		animalDto.setId(animal.getId());
		animalDto.setCodigo(animal.getCodigo());
		animalDto.setNombre(animal.getNombre());
		animalDto.setEspecie(animal.getEspecie().getNombre());
		animalDto.setRaza(animal.getRaza());
		animalDto.setEdad(animal.getEdad());
		animalDto.setSexo(animal.getSexo().getNombre());
		animalDto.setPeso(animal.getPeso());
		animalDto.setTamano(animal.getTamano());
		animalDto.setFechaIngreso(animal.getFechaIngreso());
		animalDto.setEstado(animal.getEstado().getNombre());
		animalDto.setDescripcion(animal.getDescripcion());
		
		return animalDto;
	}
	
	public static Animal map(AnimalDTO animalDto) {
		Animal animal = new Animal();
		
		animal.setId(animalDto.getId());
		animal.setCodigo(animalDto.getCodigo());
		animal.setRaza(animalDto.getRaza());
		animal.setNombre(animalDto.getNombre());
		animal.setEdad(animalDto.getEdad());
		animal.setPeso(animalDto.getPeso());
		animal.setTamano(animalDto.getTamano());
		animal.setFechaIngreso(animalDto.getFechaIngreso());
		animal.setDescripcion(animalDto.getDescripcion());
		
		
		return animal;
	}

}
