package com.iesalixar.proyecto.dto;

import java.io.Serializable;

/**
 * The Class GradoDTO.
 */
public class GradoDTO implements Serializable {
	
	/** The nombre. */
	private String nombre;
	
	/** The departamento. */
	private String departamento;

	/**
	 * Instantiates a new grado DTO.
	 */
	public GradoDTO() {
	
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the departamento.
	 *
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * Sets the departamento.
	 *
	 * @param departamento the new departamento
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
