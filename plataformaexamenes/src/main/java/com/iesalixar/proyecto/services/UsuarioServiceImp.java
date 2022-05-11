package com.iesalixar.proyecto.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.repository.UsuarioRepository;



@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepo;

	@Override
	public Usuario insertUsuario(Usuario usuario) {
		if(usuario!=null) {
			return usuarioRepo.save(usuario);
		}else {
			return null;
		}
	}

	@Override
	public Object findUserByUsername(String userName) {
		if(!userName.equals("") && userName!=null) {
			return usuarioRepo.findByUserName(userName);
		}
		return null;
	}
	
	
}
