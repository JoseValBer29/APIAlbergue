package com.josevalencia.albergue.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado,Serializable>{
	
	public Estado findByNombre(String nombre);

}
