package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Grado;



/**
 * The Interface GradoService.
 */
public interface GradoService {
	
	/**
	 * Gets the all grados.
	 *
	 * @return the all grados
	 */
	public List<Grado> getAllGrados();
	
	/**
	 * Insertar grado.
	 *
	 * @param grado the grado
	 * @return the grado
	 */
	public Grado insertarGrado(Grado grado);
	
	/**
	 * Actualizar grado.
	 *
	 * @param grado the grado
	 * @return the grado
	 */
	public Grado actualizarGrado(Grado grado);
	
	/**
	 * Find grado by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Grado> findGradoById(Long id);
	
	/**
	 * Gets the grado by name.
	 *
	 * @param nombre the nombre
	 * @return the grado by name
	 */
	public Grado getGradoByName(String nombre);
}
