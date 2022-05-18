package com.iesalixar.proyecto.dto;

import java.io.Serializable;

public class AsignaturaIdsDTO implements Serializable{
	private Long id_asignatura;
	private Long id_grado;
	
	public AsignaturaIdsDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public Long getId_grado() {
		return id_grado;
	}

	public void setId_grado(Long id_grado) {
		this.id_grado = id_grado;
	}


	
	
}
