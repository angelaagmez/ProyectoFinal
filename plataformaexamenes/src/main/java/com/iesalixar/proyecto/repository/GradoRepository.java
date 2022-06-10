package com.iesalixar.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Grado;


/**
 * The Interface GradoRepository.
 */
@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>{
	
	/**
	 * Find by nombre.
	 *
	 * @param nombre the nombre
	 * @return the grado
	 */
	public Grado findByNombre(String nombre);
}
