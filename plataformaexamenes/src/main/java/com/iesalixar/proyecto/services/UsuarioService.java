package com.iesalixar.proyecto.services;

import com.iesalixar.proyecto.model.Usuario;

public interface UsuarioService {
	public Usuario insertUsuario(Usuario usuario);

	public Object findUserByUsername(String userName);
}
