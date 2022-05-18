package com.iesalixar.proyecto.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = usuarioRepo.findAll();
		if(usuarios != null && usuarios.size()>0) {
			
			return usuarios;
		}else {
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		return usuarioRepo.findById(id);	
	}
	
	
}
