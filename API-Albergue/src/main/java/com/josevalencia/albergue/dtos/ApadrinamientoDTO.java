package com.josevalencia.albergue.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApadrinamientoDTO {
	
	private Long id;
	private String nombrePadrino;
	private String documentoPadrino;
	private String correoPadrino;
	private String nombreMascota;
	private String codigoMascota;
	private String imagenMascota;
	private LocalDateTime fechaInicio;
	private String tipo;
	private BigDecimal monto;
	private String observaciones;

}
