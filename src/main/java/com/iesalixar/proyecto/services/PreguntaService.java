package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Pregunta;

public interface PreguntaService {
	public List<Pregunta> getAllPreguntas();
	public Pregunta insertarPregunta(Pregunta pregunta);
	public Pregunta actualizarPregunta(Pregunta pregunta);
	public Optional<Pregunta> findPreguntaById(Long id);
//	public Pregunta getPreguntaByPreg(String pregunta);
}
