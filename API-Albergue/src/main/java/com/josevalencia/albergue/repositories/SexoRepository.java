package com.josevalencia.albergue.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Sexo;

public interface SexoRepository extends JpaRepository<Sexo,Serializable> {
	
	public Sexo findByNombre(String nombre);
}
