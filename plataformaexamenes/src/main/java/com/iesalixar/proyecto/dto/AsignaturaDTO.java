package com.iesalixar.proyecto.dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable{
	private String nombre;
	private Integer curso;
	private Long id_grado;
	
	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
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

	public Long getId_grado() {
		return id_grado;
	}

	public void setId_grado(Long id_grado) {
		this.id_grado = id_grado;
	}
}
