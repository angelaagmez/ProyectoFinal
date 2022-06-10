package com.iesalixar.proyecto.dto;

import java.io.Serializable;

/**
 * The Class AsignaturaIdsDTO.
 */
public class AsignaturaIdsDTO implements Serializable{
	
	/** The id asignatura. */
	private Long id_asignatura;
	
	/** The id grado. */
	private Long id_grado;
	
	/**
	 * Instantiates a new asignatura ids DTO.
	 */
	public AsignaturaIdsDTO() {
	
	}

	/**
	 * Gets the id asignatura.
	 *
	 * @return the id asignatura
	 */
	public Long getId_asignatura() {
		return id_asignatura;
	}
	
	/**
	 * Sets the id asignatura.
	 *
	 * @param id_asignatura the new id asignatura
	 */
	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	/**
	 * Gets the id grado.
	 *
	 * @return the id grado
	 */
	public Long getId_grado() {
		return id_grado;
	}

	/**
	 * Sets the id grado.
	 *
	 * @param id_grado the new id grado
	 */
	public void setId_grado(Long id_grado) {
		this.id_grado = id_grado;
	}


	
	
}
