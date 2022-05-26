package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Asignatura;



/**
 * The Interface AsignaturaService.
 */
public interface AsignaturaService {
	
	/**
	 * Gets the all asignaturas.
	 *
	 * @return the all asignaturas
	 */
	public List<Asignatura> getAllAsignaturas();
	
	/**
	 * Find asignatura by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Asignatura> findAsignaturaById(Long id);
	
	/**
	 * Gets the asignatura by name.
	 *
	 * @param nombre the nombre
	 * @return the asignatura by name
	 */
	public Asignatura getAsignaturaByName(String nombre);
	
	/**
	 * Insertar asignatura.
	 *
	 * @param asignatura the asignatura
	 * @return the asignatura
	 */
	public Asignatura insertarAsignatura(Asignatura asignatura);
	
	/**
	 * Actualizar asignatura.
	 *
	 * @param asignatura the asignatura
	 * @return the asignatura
	 */
	public Asignatura actualizarAsignatura(Asignatura asignatura);
	
	/**
	 * Find by ids.
	 *
	 * @param ids the ids
	 * @return the list
	 */
	public List<Asignatura> findByIds(List<Long> ids);
}
