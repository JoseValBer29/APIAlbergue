package com.josevalencia.albergue.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.TipoApadrinamiento;

public interface TipoRepository extends JpaRepository<TipoApadrinamiento,Serializable>{
	
	TipoApadrinamiento findByNombre(String nombre);

}
