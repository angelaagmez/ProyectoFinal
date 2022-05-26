package com.iesalixar.proyecto.dto;

import java.sql.Date;

/**
 * The Class ExamenDTO.
 */
public class ExamenDTO {
	
	/** The num preguntas. */
	private int num_preguntas;
	
	/** The fecha creacion. */
	private Date fecha_creacion;
	
	/** The id asignatura. */
	private Long id_asignatura;
	
	/** The id usuario. */
	private Long id_usuario;
	
	/**
	 * Instantiates a new examen DTO.
	 */
	public ExamenDTO() {
		
	}

	

	/**
	 * Gets the num preguntas.
	 *
	 * @return the num preguntas
	 */
	public int getNum_preguntas() {
		return num_preguntas;
	}


	/**
	 * Sets the num preguntas.
	 *
	 * @param num_preguntas the new num preguntas
	 */
	public void setNum_preguntas(int num_preguntas) {
		this.num_preguntas = num_preguntas;
	}



	/**
	 * Gets the fecha creacion.
	 *
	 * @return the fecha creacion
	 */
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * Sets the fecha creacion.
	 *
	 * @param fecha_creacion the new fecha creacion
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
	
	
	
}
