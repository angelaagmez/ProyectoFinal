package com.iesalixar.proyecto.dto;

import java.io.Serializable;


/**
 * The Class MatricularseDTO.
 */
public class MatricularseDTO implements Serializable{
	
	/** The id usuario. */
	private Long id_usuario;
	
	/** The id asignatura. */
	private Long id_asignatura;
	
	/** The num alumnos. */
	private int num_alumnos;
	
	
	/**
	 * Instantiates a new matricularse DTO.
	 */
	public MatricularseDTO() {
		
	}


	/**
	 * Gets the id usuario.
	 *
	 * @return the id usuario
	 */
	public Long getId_usuario() {
		return id_usuario;
	}


	/**
	 * Sets the id usuario.
	 *
	 * @param id_usuario the new id usuario
	 */
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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
	 * Gets the num alumnos.
	 *
	 * @return the num alumnos
	 */
	public int getNum_alumnos() {
		return num_alumnos;
	}


	/**
	 * Sets the num alumnos.
	 *
	 * @param num_alumnos the new num alumnos
	 */
	public void setNum_alumnos(int num_alumnos) {
		this.num_alumnos = num_alumnos;
	}
	
}
