package com.iesalixar.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Usuario;


/**
 * The Interface UsuarioRepository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the usuario
	 */
	public Usuario findByUserName(String userName);
}
