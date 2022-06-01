package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Pregunta;
import com.iesalixar.proyecto.repository.PreguntaRepository;


/**
 * The Class PreguntaServiceImp.
 */
@Service
public class PreguntaServiceImp implements PreguntaService{
	
	/** The pregunta repo. */
	@Autowired
	PreguntaRepository preguntaRepo;
	
	/**
	 * Gets the all preguntas.
	 *
	 * @return the all preguntas
	 */
	@Override
	public List<Pregunta> getAllPreguntas() {
		return preguntaRepo.findAll();
	}

	/**
	 * Insertar pregunta.
	 *
	 * @param pregunta the pregunta
	 * @return the pregunta
	 */
	@Override
	public Pregunta insertarPregunta(Pregunta pregunta) {
		if(pregunta!=null && pregunta.getId()==null) {
			return preguntaRepo.save(pregunta);			
		}else {
			return null;

		}
	}

	/**
	 * Actualizar pregunta.
	 *
	 * @param pregunta the pregunta
	 * @return the pregunta
	 */
	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		if(pregunta!=null && pregunta.getId()!=null) {
			return preguntaRepo.save(pregunta);
		}else {
			return null;
		}
	}

	/**
	 * Find pregunta by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
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
