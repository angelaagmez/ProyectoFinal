package com.iesalixar.proyecto.dto;

import java.io.Serializable;

public class GradoDTO implements Serializable {
	
	private String nombre;
	private String departamento;

	public GradoDTO() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
