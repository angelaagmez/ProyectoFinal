package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class Grado.
 */
@Entity
@Table(name="grado")
public class Grado implements Serializable{
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The nombre. */
	@Column(nullable=false)
	private String nombre;
	
	/** The departamento. */
	@Column(nullable=false)
	private String departamento;
	
	/** The asignaturas. */
	@OneToMany(mappedBy="grado", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Asignatura> asignaturas = new HashSet<>();

	/**
	 * Instantiates a new grado.
	 */
	public Grado() {
	
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

	/**
	 * Gets the asignaturas.
	 *
	 * @return the asignaturas
	 */
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * Sets the asignaturas.
	 *
	 * @param asignaturas the new asignaturas
	 */
	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
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
		Grado other = (Grado) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Grado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", asignaturas="
				+ asignaturas + "]";
	}
	
	

}
