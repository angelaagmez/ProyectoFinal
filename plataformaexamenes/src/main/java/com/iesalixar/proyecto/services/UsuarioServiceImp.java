package com.iesalixar.proyecto.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.repository.UsuarioRepository;



/**
 * The Class UsuarioServiceImp.
 */
@Service
public class UsuarioServiceImp implements UsuarioService{

	/** The usuario repo. */
	@Autowired
	UsuarioRepository usuarioRepo;

	/**
	 * Insert usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 */
	@Override
	public Usuario insertUsuario(Usuario usuario) {
		if(usuario!=null) {
			return usuarioRepo.save(usuario);
		}else {
			return null;
		}
	}

	/**
	 * Find user by username.
	 *
	 * @param userName the user name
	 * @return the usuario
	 */
	@Override
	public Usuario findUserByUsername(String userName) {
		if(!userName.equals("") && userName!=null) {
			return usuarioRepo.findByUserName(userName);
		}
		return null;
	}

	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = usuarioRepo.findAll();
		if(usuarios != null && usuarios.size()>0) {
			
			return usuarios;
		}else {
			return new ArrayList<Usuario>();
		}
	}

	/**
	 * Find usuario by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		return usuarioRepo.findById(id);	
	}
	
	
}
