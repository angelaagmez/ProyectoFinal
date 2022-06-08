package com.iesalixar.proyecto.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Examen;


/**
 * The Interface ExamenService.
 */
public interface ExamenService {
	
	/**
	 * Gets the all examenes.
	 *
	 * @return the all examenes
	 */
	public List<Examen> getAllExamenes();
	
	/**
	 * Find examen by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Examen> findExamenById(Long id);
	
	/**
	 * Insertar examen.
	 *
	 * @param examen the examen
	 * @return the examen
	 */
	public Examen insertarExamen(Examen examen);
	
	/**
	 * Actualizar examen.
	 *
	 * @param examen the examen
	 * @return the examen
	 */
	public Examen actualizarExamen(Examen examen);
//	public List<Examen> findByIdUsuario(Long id_usuario);
}
