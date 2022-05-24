package com.iesalixar.proyecto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matricularse")
public class Matricularse implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name="id_usuario", insertable=false,updatable=false)
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_asignatura", insertable=false,updatable=false)
	private Asignatura asignatura;
	
	
	@Column(nullable=false)
	private int num_alumnos;

	public Matricularse() {
	}
	
	public Matricularse(Usuario usuario, Asignatura asignatura, int num_alumnos) {
		this.usuario = usuario;
		this.asignatura = asignatura;
		this.num_alumnos = num_alumnos;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public int getNum_alumnos() {
		return num_alumnos;
	}

	public void setNum_alumnos(int num_alumnos) {
		this.num_alumnos = num_alumnos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, usuario);
	}

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

	@Override
	public String toString() {
		return "Matricularse [usuario=" + usuario + ", asignatura=" + asignatura + ", num_alumnos=" + num_alumnos + "]";
	}
	

	

	
}
