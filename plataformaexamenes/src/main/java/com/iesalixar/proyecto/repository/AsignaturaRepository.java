package com.iesalixar.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Asignatura;


/**
 * The Interface AsignaturaRepository.
 */
@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	
	/**
	 * Find by nombre.
	 *
	 * @param nombre the nombre
	 * @return the asignatura
	 */
	public Asignatura findByNombre(String nombre);

}
