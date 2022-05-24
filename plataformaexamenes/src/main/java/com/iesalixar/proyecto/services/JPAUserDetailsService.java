package com.iesalixar.proyecto.services;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.JPAUserDetails;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.repository.UsuarioRepository;


@Service
public class JPAUserDetailsService implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Obtengo el usuario
		Usuario user = usuarioRepository.findByUserName(username);
		
		
		//Si el usuario no existe debo devolver una excepción
		if (user == null) {
			throw new UsernameNotFoundException("Not found:"+ username);
		}
		
		//Adapto la información del usuario al UserDetails que es lo que debe devolver el método
		JPAUserDetails userDetails = new JPAUserDetails(user);
		return userDetails;
		
	}
	
	

}
