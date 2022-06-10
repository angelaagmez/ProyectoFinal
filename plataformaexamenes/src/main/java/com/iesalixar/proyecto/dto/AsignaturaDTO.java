package com.iesalixar.proyecto.dto;

import java.io.Serializable;

/**
 * The Class AsignaturaDTO.
 */
public class AsignaturaDTO implements Serializable{
	
	/** The nombre. */
	private String nombre;
	
	/** The curso. */
	private Integer curso;
	
	/** The id grado. */
	private Long id_grado;
	
	/**
	 * Instantiates a new asignatura DTO.
	 */
	public AsignaturaDTO() {
	
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
	 * Gets the curso.
	 *
	 * @return the curso
	 */
	public Integer getCurso() {
		return curso;
	}

	/**
	 * Sets the curso.
	 *
	 * @param curso the new curso
	 */
	public void setCurso(Integer curso) {
		this.curso = curso;
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
