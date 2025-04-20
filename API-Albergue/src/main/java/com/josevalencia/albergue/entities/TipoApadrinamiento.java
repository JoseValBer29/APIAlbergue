package com.josevalencia.albergue.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIPO_APADRINAMIENTO")
public class TipoApadrinamiento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String descripcion;
	
	@OneToMany(mappedBy = "tipoApadrinamiento", cascade = CascadeType.ALL)
	List<Apadrinamiento> apadrinamientos;

}
