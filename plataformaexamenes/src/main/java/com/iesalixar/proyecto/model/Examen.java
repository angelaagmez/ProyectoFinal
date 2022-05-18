package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.sql.Date;
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

@Entity
@Table(name="examen")
public class Examen implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Value("${num_preguntas:0}")
	@Column(nullable=true)
	private int num_preguntas;

	@Column(nullable=false)
	private Date fecha_creacion;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=true)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_asignatura", nullable=true)
	private Asignatura asignatura;
	
	@OneToMany(mappedBy="examen", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Pregunta> preguntas = new HashSet<>();

	public Examen() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getNum_preguntas() {
		return num_preguntas;
	}

	public void setNum_preguntas(int num_preguntas) {
		this.num_preguntas = num_preguntas;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
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
		Examen other = (Examen) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
	
	
	
	
}
