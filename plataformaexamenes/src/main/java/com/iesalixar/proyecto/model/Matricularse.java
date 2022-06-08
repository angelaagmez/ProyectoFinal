package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The Class Matricularse.
 */
@Entity
@Table(name="matricularse")
@IdClass(MatricularseIDs.class)
public class Matricularse implements Serializable{
	
	/** The usuario. */
	@Id
	@ManyToOne
	@JoinColumn(name="id_usuario", updatable=false, insertable=false)
	private Usuario usuario;
	
	/** The asignatura. */
	@Id
	@ManyToOne
	@JoinColumn(name="id_asignatura", updatable=false, insertable=false)
	private Asignatura asignatura;
	
	 
	/** The num alumnos. */
	@Column(nullable=false)
	private int num_alumnos;

	/**
	 * Instantiates a new matricularse.
	 */
	public Matricularse() {
	}
	
	/**
	 * Instantiates a new matricularse.
	 *
	 * @param usuario the usuario
	 * @param asignatura the asignatura
	 * @param num_alumnos the num alumnos
	 */
	public Matricularse(Usuario usuario, Asignatura asignatura, int num_alumnos) {
		this.usuario = usuario;
		this.asignatura = asignatura;
		this.num_alumnos = num_alumnos;
	}


	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the asignatura.
	 *
	 * @return the asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}

	/**
	 * Sets the asignatura.
	 *
	 * @param asignatura the new asignatura
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(asignatura, usuario);
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
		Matricularse other = (Matricularse) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(usuario, other.usuario);
	}

	
	

	

	
}
