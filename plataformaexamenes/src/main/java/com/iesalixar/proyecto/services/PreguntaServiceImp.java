package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Pregunta;
import com.iesalixar.proyecto.repository.PreguntaRepository;

@Service
public class PreguntaServiceImp implements PreguntaService{
	
	@Autowired
	PreguntaRepository preguntaRepo;
	
	@Override
	public List<Pregunta> getAllPreguntas() {
		return preguntaRepo.findAll();
	}

	@Override
	public Pregunta insertarPregunta(Pregunta pregunta) {
		if(pregunta!=null && pregunta.getId()==null) {
			return preguntaRepo.save(pregunta);			
		}else {
			return null;

		}
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		if(pregunta!=null && pregunta.getId()!=null) {
			return preguntaRepo.save(pregunta);
		}else {
			return null;
		}
	}

	@Override
	public Optional<Pregunta> findPreguntaById(Long id) {
		if(id!=null) {
			return preguntaRepo.findById(id);			
		}else {
			return null;
		}
	}

//	@Override
//	public Pregunta getPreguntaByPreg(String preguntas) {
//		if (preguntas!=null) {
//			return  preguntaRepo.findByPregunta(preguntas);	
//		}
//		
//		return null;
//	}

}
