package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nombre;
	
	@OneToMany(mappedBy="estado", cascade = CascadeType.ALL)
	private List<Animal> animales;

}
