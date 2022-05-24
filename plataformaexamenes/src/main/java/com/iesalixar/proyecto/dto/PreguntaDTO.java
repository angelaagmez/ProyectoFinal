package com.iesalixar.proyecto.dto;

import javax.persistence.Column;

public class PreguntaDTO {
	private String preguntas;
	private int num_pregunta;
	private String respuestas;
	private Long id_examen;
	
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}

	public int getNum_pregunta() {
		return num_pregunta;
	}

	public void setNum_pregunta(int num_pregunta) {
		this.num_pregunta = num_pregunta;
	}

	public String getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	public Long getId_examen() {
		return id_examen;
	}

	public void setId_examen(Long id_examen) {
		this.id_examen = id_examen;
	}
	
	
	
}
