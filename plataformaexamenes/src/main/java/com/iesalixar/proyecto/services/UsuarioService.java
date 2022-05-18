package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Usuario;

public interface UsuarioService {
	public Usuario insertUsuario(Usuario usuario);
	public List<Usuario> getAllUsuarios();
	public Object findUserByUsername(String userName);
	public Optional<Usuario> findUsuarioById(Long id);
}
