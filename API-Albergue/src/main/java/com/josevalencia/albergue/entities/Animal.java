package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="especie_id")
	private Especie especie;
	private String raza;
	private Integer edad;
	@ManyToOne
	@JoinColumn(name = "sexo_id")
	private Sexo sexo;
	private Float peso;
	private Float tamano;
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;
	private LocalDateTime fechaIngreso;
	private String imagen;
	private String descripcion;
	
	@OneToOne(mappedBy = "animal")
	private Adopcion adopcion;
	
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
	private List<Apadrinamiento> apadrinamientos;

}
