package com.josevalencia.albergue.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Animal;


public interface AnimalRepository extends JpaRepository<Animal,Long> {
	
	Animal findByCodigo(String codigo);
	List<Animal> findAllByCodigo(String codigo);

}
