package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;


/**
 * The Class Examen.
 */
@Entity
@Table(name="examen")
public class Examen implements Serializable{
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The num preguntas. */
	@Value("${num_preguntas:0}")
	@Column(nullable=true)
	private int num_preguntas;

	/** The fecha creacion. */
	@Column(nullable=false)
	private Date fecha_creacion;
	
	/** The usuario. */
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=true)
	private Usuario usuario;
	
	/** The asignatura. */
	@ManyToOne
	@JoinColumn(name="id_asignatura", nullable=true)
	private Asignatura asignatura;
	
	/** The preguntas. */
	@OneToMany(mappedBy="examen", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Pregunta> preguntas = new HashSet<>();

	/**
	 * Instantiates a new examen.
	 */
	public Examen() {
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
	 * Gets the preguntas.
	 *
	 * @return the preguntas
	 */
	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * Sets the preguntas.
	 *
	 * @param preguntas the new preguntas
	 */
	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
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
		Examen other = (Examen) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
