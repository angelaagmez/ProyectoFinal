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


@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;

	@Column(nullable=false)
	private Integer curso;
	
	@ManyToOne
	@JoinColumn(name="id_grado", nullable=true)
	private Grado grado;
	
	@OneToMany(mappedBy="asignatura", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Matricularse> matriculas = new HashSet<>();
	
	@OneToMany(mappedBy="asignatura", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Examen> examenes = new HashSet<>();
	
	
	public Asignatura() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Set<Matricularse> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricularse> matriculas) {
		this.matriculas = matriculas;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

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

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", grado=" + grado
				+ ", matriculas=" + matriculas + "]";
	}

	
	
	
}
