package com.josevalencia.albergue.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Apadrinamiento;

public interface ApadrinamientoRepository extends JpaRepository<Apadrinamiento,
																Serializable>{
	
	List<Apadrinamiento> findAllById(Long id);

}
