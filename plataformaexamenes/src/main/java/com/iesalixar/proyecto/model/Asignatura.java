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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class Asignatura.
 */
@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The nombre. */
	@Column(nullable=false)
	private String nombre;

	/** The curso. */
	@Column(nullable=false)
	private Integer curso;
	
	/** The grado. */
	@ManyToOne
	@JoinColumn(name="id_grado", nullable=true)
	private Grado grado;
	
	/** The matriculas. */
	@OneToMany(mappedBy="asignatura", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Matricularse> matriculas = new HashSet<>();
	
	/** The examenes. */
	@OneToMany(mappedBy="asignatura", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Examen> examenes = new HashSet<>();
	
	
	/**
	 * Instantiates a new asignatura.
	 */
	public Asignatura() {
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
	 * Gets the grado.
	 *
	 * @return the grado
	 */
	public Grado getGrado() {
		return grado;
	}

	/**
	 * Sets the grado.
	 *
	 * @param grado the new grado
	 */
	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	/**
	 * Gets the matriculas.
	 *
	 * @return the matriculas
	 */
	public Set<Matricularse> getMatriculas() {
		return matriculas;
	}

	/**
	 * Sets the matriculas.
	 *
	 * @param matriculas the new matriculas
	 */
	public void setMatriculas(Set<Matricularse> matriculas) {
		this.matriculas = matriculas;
	}

	/**
	 * Gets the examenes.
	 *
	 * @return the examenes
	 */
	public Set<Examen> getExamenes() {
		return examenes;
	}

	/**
	 * Sets the examenes.
	 *
	 * @param examenes the new examenes
	 */
	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
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
		Asignatura other = (Asignatura) obj;
		return Objects.equals(id, other.id);
	}

	
	/**
	 * Adds the matricula.
	 *
	 * @param usuario the usuario
	 * @param num_alumnos the num alumnos
	 */
	public void addMatricula(Usuario usuario, int num_alumnos) {
		Matricularse matricula = new Matricularse(usuario, this, num_alumnos);
		this.matriculas.add(matricula);
		usuario.getMatriculas().add(matricula);
	}

	
	
	
}
