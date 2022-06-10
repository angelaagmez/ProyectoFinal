package com.iesalixar.proyecto.dto;

import javax.persistence.Column;


/**
 * The Class PreguntaDTO.
 */
public class PreguntaDTO {
	
	/** The preguntas. */
	private String preguntas;
	
	/** The num pregunta. */
	private int num_pregunta;
	
	/** The respuestas. */
	private String respuestas;
	
	/** The id examen. */
	private Long id_examen;
	
	/**
	 * Instantiates a new pregunta DTO.
	 */
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the preguntas.
	 *
	 * @return the preguntas
	 */
	public String getPreguntas() {
		return preguntas;
	}

	/**
	 * Sets the preguntas.
	 *
	 * @param preguntas the new preguntas
	 */
	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * Gets the num pregunta.
	 *
	 * @return the num pregunta
	 */
	public int getNum_pregunta() {
		return num_pregunta;
	}

	/**
	 * Sets the num pregunta.
	 *
	 * @param num_pregunta the new num pregunta
	 */
	public void setNum_pregunta(int num_pregunta) {
		this.num_pregunta = num_pregunta;
	}

	/**
	 * Gets the respuestas.
	 *
	 * @return the respuestas
	 */
	public String getRespuestas() {
		return respuestas;
	}

	/**
	 * Sets the respuestas.
	 *
	 * @param respuestas the new respuestas
	 */
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * Gets the id examen.
	 *
	 * @return the id examen
	 */
	public Long getId_examen() {
		return id_examen;
	}

	/**
	 * Sets the id examen.
	 *
	 * @param id_examen the new id examen
	 */
	public void setId_examen(Long id_examen) {
		this.id_examen = id_examen;
	}
	
	
	
}
