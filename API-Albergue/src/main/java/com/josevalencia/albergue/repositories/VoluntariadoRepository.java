package com.josevalencia.albergue.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Voluntariado;

public interface VoluntariadoRepository extends JpaRepository<Voluntariado,
													Serializable>{
	
	List<Voluntariado> findAllById(Long id);
	

}
