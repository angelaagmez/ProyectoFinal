package com.iesalixar.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Matricularse;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.repository.MatricularseRepository;


public class MatricularseServiceImp implements MatricularseService {
	
//	@Autowired
//	MatricularseRepository matriculaRepo;
//
//	@Override
//	public List<Asignatura> findByIdUsuario(Usuario id_usuario) {
//		List<Matricularse> listaMatricula = matriculaRepo.findByIdUsuario(id_usuario);
//		if(listaMatricula!=null && listaMatricula.size()>0) {
//			List<Asignatura> listaAsignaturas = new ArrayList<>();
//			for (int i = 0; i < listaMatricula.size(); i++) {
//				listaAsignaturas.add(listaMatricula.get(i).getAsignatura());
//			}
//			return listaAsignaturas;
//		}
//		return null;
//	}

}
