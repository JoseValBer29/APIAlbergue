package com.josevalencia.albergue.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josevalencia.albergue.entities.Adopcion;

public interface AdopcionRepository extends JpaRepository<Adopcion,Serializable>{

}
