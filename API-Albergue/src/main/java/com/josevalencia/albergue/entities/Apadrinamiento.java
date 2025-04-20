package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apadrinamiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	private LocalDateTime fechaInicio;
	
	@ManyToOne
	@JoinColumn(name = "tipo_apadrinamiento_id")
	private TipoApadrinamiento tipoApadrinamiento;
	
	private BigDecimal montoMensual;
	private String observaciones;
	
}
