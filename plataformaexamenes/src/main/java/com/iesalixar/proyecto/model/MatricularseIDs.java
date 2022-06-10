package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class MatricularseIDs.
 */
public class MatricularseIDs implements Serializable {
	
	/** The id usuario. */
	private Long usuario;
	
	/** The id asignatura. */
	private Long asignatura;

	/**
	 * Instantiates a new matricularse Ids.
	 */
	public MatricularseIDs() {

	}

	/**
	 * Gets the id usuario.
	 *
	 * @return the id usuario
	 */
	public Long getUsuario() {
		return usuario;
	}

	/**
	 * Sets the id usuario.
	 *
	 * @param id_usuario the new id usuario
	 */
	public void setUsuario(Long id_usuario) {
		this.usuario = id_usuario;
	}

	/**
	 * Gets the id asignatura.
	 *
	 * @return the id asignatura
	 */
	public Long getAsignatura() {
		return asignatura;
	}

	/**
	 * Sets the id asignatura.
	 *
	 * @param id_asignatura the new id asignatura
	 */
	public void setAsignatura(Long id_asignatura) {
		this.asignatura = id_asignatura;
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
		MatricularseIDs other = (MatricularseIDs) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(usuario, other.usuario);
	}
	
	

}
