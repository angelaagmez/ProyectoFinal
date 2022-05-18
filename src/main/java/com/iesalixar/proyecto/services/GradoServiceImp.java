package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.repository.GradoRepository;

@Service
public class GradoServiceImp implements GradoService{
	
	@Autowired
	GradoRepository gradoRepo;

	@Override
	public List<Grado> getAllGrados() {
		return gradoRepo.findAll();
	}

	@Override
	public Grado insertarGrado(Grado grado) {
		if(grado!=null && grado.getId()==null) {
			return gradoRepo.save(grado);			
		}else {
			return null;

		}
	}

	@Override
	public Grado actualizarGrado(Grado grado) {
		if(grado!=null && grado.getId()!=null) {
			return gradoRepo.save(grado);
		}else {
			return null;
		}
	}

	@Override
	public Optional<Grado> findGradoById(Long id) {
		if(id!=null) {
			return gradoRepo.findById(id);			
		}else {
			return null;
		}
	}
	
	@Override
	public Grado getGradoByName(String nombre) {
		if (nombre!=null) {
			return  gradoRepo.findByNombre(nombre);	
		}
		
		return null;
	}

}
