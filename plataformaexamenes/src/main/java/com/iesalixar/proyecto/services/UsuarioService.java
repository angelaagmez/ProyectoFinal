package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Usuario;


/**
 * The Interface UsuarioService.
 */
public interface UsuarioService {
	
	/**
	 * Insert usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 */
	public Usuario insertUsuario(Usuario usuario);
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	public List<Usuario> getAllUsuarios();
	
	/**
	 * Find user by username.
	 *
	 * @param userName the user name
	 * @return the usuario
	 */
	public Usuario findUserByUsername(String userName);
	
	/**
	 * Find usuario by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Usuario> findUsuarioById(Long id);
}
