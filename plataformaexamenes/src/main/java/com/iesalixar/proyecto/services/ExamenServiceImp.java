package com.iesalixar.proyecto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Examen;
import com.iesalixar.proyecto.repository.ExamenRepository;

@Service
public class ExamenServiceImp implements ExamenService{
	
	@Autowired
	ExamenRepository examenRepo;
	
	@Override
	public List<Examen> getAllExamenes() {
		List<Examen> examenes = examenRepo.findAll();
		if(examenes != null && examenes.size()>0) {
			
			return examenes;
		}else {
			return new ArrayList<Examen>();
		}
	}

	@Override
	public Optional<Examen> findExamenById(Long id) {
		return examenRepo.findById(id);
	}

	

	@Override
	public Examen insertarExamen(Examen examen) {
		if (examen!=null && findExamenById(examen.getId())==null) {
			return examenRepo.save(examen);
		}
		return null;
	}

	@Override
	public Examen actualizarExamen(Examen examen) {
		if (examen!=null && examen.getId() !=null && examen.getPreguntas()!=null) {
			return examenRepo.save(examen); 
		}
		return null;
	}

//	@Override
//	public List<Examen> findByIdUsuario(Long id_usuario) {
//		if(id_usuario != null) {
//			return examenRepo.findByIdUsuario(id_usuario);
//		}
//		return null;
//	}

}
