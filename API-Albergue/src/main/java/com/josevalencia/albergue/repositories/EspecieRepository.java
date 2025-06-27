package com.josevalencia.albergue.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Especie;

public interface EspecieRepository extends JpaRepository<Especie,Serializable>{
	
	public Especie findByNombre(String nombre);

}
