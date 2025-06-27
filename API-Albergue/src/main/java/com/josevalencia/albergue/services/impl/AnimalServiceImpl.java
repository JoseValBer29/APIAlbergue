package com.josevalencia.albergue.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.josevalencia.albergue.dtos.AnimalDTO;
import com.josevalencia.albergue.entities.Animal;
import com.josevalencia.albergue.entities.Especie;
import com.josevalencia.albergue.entities.Estado;
import com.josevalencia.albergue.entities.Sexo;
import com.josevalencia.albergue.exceptions.AlreadyExistsException;
import com.josevalencia.albergue.exceptions.NotFoundException;
import com.josevalencia.albergue.mappers.AnimalMapper;
import com.josevalencia.albergue.repositories.AnimalRepository;
import com.josevalencia.albergue.repositories.EspecieRepository;
import com.josevalencia.albergue.repositories.EstadoRepository;
import com.josevalencia.albergue.repositories.SexoRepository;
import com.josevalencia.albergue.services.IAnimalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements IAnimalService{
	
	private AnimalRepository animalRepo;
	private EstadoRepository estadoRepo;
	private EspecieRepository especieRepo;
	private SexoRepository sexoRepo;
	
	
	public AnimalDTO registrarAnimal(AnimalDTO animalDto) throws AlreadyExistsException {
		
		Animal animal = new Animal();
		
		List<Animal> animales = animalRepo.findAllByCodigo(animalDto.getCodigo());
		
		
		if(animales.isEmpty()){
			
			
			animal = AnimalMapper.map(animalDto);
			
			Estado estado = new Estado();
			Especie especie = new Especie();
			Sexo sexo = new Sexo();
			
			estado = estadoRepo.findByNombre(animalDto.getEstado());
			especie = especieRepo.findByNombre(animalDto.getEspecie());
			sexo = sexoRepo.findByNombre(animalDto.getSexo());
			
			animal.setEspecie(especie);
			animal.setEstado(estado);
			animal.setSexo(sexo);
			
			return AnimalMapper.map(animalRepo.save(animal));
		}else {
			throw new AlreadyExistsException(
					"Ya existe el animal con código " + 
					animalDto.getCodigo() + ": \n" + 
					animalDto.getNombre()
					);
		}
		
	}
	
	public void eliminarAnimal(Long id) {
		animalRepo.deleteById(id);
	}
	
	
	public AnimalDTO actualizarAnimal(AnimalDTO animalDto) {
		
		Animal animal = new Animal();
		
		List<Animal> animales = animalRepo.findAllByCodigo(animalDto.getCodigo());
		
		if(!animales.isEmpty()) {
			
			animal = AnimalMapper.map(animalDto);
			
			Estado estado = new Estado();
			Especie especie = new Especie();
			Sexo sexo = new Sexo();
			
			estado = estadoRepo.findByNombre(animalDto.getEstado());
			especie = especieRepo.findByNombre(animalDto.getEspecie());
			sexo = sexoRepo.findByNombre(animalDto.getSexo());
			
			animal.setEspecie(especie);
			animal.setEstado(estado);
			animal.setSexo(sexo);
			
			return AnimalMapper.map(animalRepo.save(animal));
			
		}else {
			throw new NotFoundException("No existe animal con id: "+animalDto.getId());
		}
		
		
		
	}
	
	public AnimalDTO obtenerAnimal(Long id) throws NotFoundException{
		Animal animal = animalRepo.findById(id)
				.orElseThrow(()-> new NotFoundException("Animal no encontrado"));
		
		return AnimalMapper.map(animal);
		
	}

}
