package com.josevalencia.albergue.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Serializable>{
	
	List<Tarea> findAllByNombre(List<String> tareas);

}
