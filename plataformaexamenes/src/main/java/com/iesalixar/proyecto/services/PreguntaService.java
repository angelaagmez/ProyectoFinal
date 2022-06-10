package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Pregunta;


/**
 * The Interface PreguntaService.
 */
public interface PreguntaService {
	
	/**
	 * Gets the all preguntas.
	 *
	 * @return the all preguntas
	 */
	public List<Pregunta> getAllPreguntas();
	
	/**
	 * Insertar pregunta.
	 *
	 * @param pregunta the pregunta
	 * @return the pregunta
	 */
	public Pregunta insertarPregunta(Pregunta pregunta);
	
	/**
	 * Actualizar pregunta.
	 *
	 * @param pregunta the pregunta
	 * @return the pregunta
	 */
	public Pregunta actualizarPregunta(Pregunta pregunta);
	
	/**
	 * Find pregunta by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Pregunta> findPreguntaById(Long id);
//	public Pregunta getPreguntaByPreg(String pregunta);
}
