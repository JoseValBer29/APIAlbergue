package com.josevalencia.albergue.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Serializable> {
	
	List<Persona> findAllByNumeroDocumento(String numeroDocumento);
	Persona findByNumeroDocumento(String numeroDocumento);

}
