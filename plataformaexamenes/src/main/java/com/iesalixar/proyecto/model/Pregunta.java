package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Pregunta.
 */
@Entity
@Table(name="pregunta")
public class Pregunta implements Serializable{
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The preguntas. */
	@Column(nullable=false)
	private String preguntas;

	/** The num pregunta. */
	@Column(nullable=false)
	private int num_pregunta;
	
	/** The respuestas. */
	@Column(nullable=false)
	private String respuestas;
	
	/** The examen. */
	@ManyToOne
	@JoinColumn(name="id_examen", nullable=true)
	private Examen examen;

	/**
	 * Instantiates a new pregunta.
	 */
	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the examen.
	 *
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * Sets the examen.
	 *
	 * @param examen the new examen
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregunta other = (Pregunta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return  preguntas ;
	}


	
	
	
	

}
