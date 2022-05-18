package com.iesalixar.proyecto.dto;

import java.io.Serializable;

public class MatricularseDTO implements Serializable{
	private Long id_usuario;
	private Long id_asignatura;
	private int num_alumnos;
	
	
	public MatricularseDTO() {
		// TODO Auto-generated constructor stub
	}


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public Long getId_asignatura() {
		return id_asignatura;
	}


	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}


	public int getNum_alumnos() {
		return num_alumnos;
	}


	public void setNum_alumnos(int num_alumnos) {
		this.num_alumnos = num_alumnos;
	}
	
}
