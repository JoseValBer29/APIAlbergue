package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private String direccion;
	
	@ManyToMany
	@JoinTable(name = "PERSONA_ROL",
			joinColumns = @JoinColumn(name = "persona_id"),
			inverseJoinColumns = @JoinColumn(name= "rol_id"))
	private List<Rol> roles;
	
	@OneToMany(mappedBy="persona",cascade = CascadeType.ALL)
	private List<Voluntariado> voluntariados;
	
	@OneToMany(mappedBy="persona",cascade = CascadeType.ALL)
	private List<Apadrinamiento> apadrinamientos;
	
	@OneToMany(mappedBy="persona",cascade = CascadeType.ALL)
	private List<Adopcion> adopciones;
	
	
	
	
}
