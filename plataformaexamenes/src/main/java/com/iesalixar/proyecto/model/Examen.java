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

@Entity
@Table(name="examen")
public class Examen implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private boolean respuesta;

	@Column(nullable=false)
	private boolean aciertos;
	
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

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isAciertos() {
		return aciertos;
	}

	public void setAciertos(boolean aciertos) {
		this.aciertos = aciertos;
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

	@Override
	public String toString() {
		return "Examen [id=" + id + ", respuesta=" + respuesta + ", aciertos=" + aciertos + ", fecha_creacion="
				+ fecha_creacion + ", usuario=" + usuario + ", asignatura=" + asignatura + ", preguntas=" + preguntas + "]";
	}

	
	
	
	
	
}
