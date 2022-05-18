package com.iesalixar.proyecto.dto;

import java.sql.Date;

public class ExamenDTO {
	private int num_preguntas;
	private Date fecha_creacion;
	private Long id_asignatura;
	private Long id_usuario;
	
	public ExamenDTO() {
		// TODO Auto-generated constructor stub
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

	public Long getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
}
