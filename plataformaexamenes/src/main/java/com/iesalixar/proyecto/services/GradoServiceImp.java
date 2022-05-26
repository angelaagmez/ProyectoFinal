package com.iesalixar.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.repository.GradoRepository;


/**
 * The Class GradoServiceImp.
 */
@Service
public class GradoServiceImp implements GradoService{
	
	/** The grado repo. */
	@Autowired
	GradoRepository gradoRepo;

	/**
	 * Gets the all grados.
	 *
	 * @return the all grados
	 */
	@Override
	public List<Grado> getAllGrados() {
		return gradoRepo.findAll();
	}

	/**
	 * Insertar grado.
	 *
	 * @param grado the grado
	 * @return the grado
	 */
	@Override
	public Grado insertarGrado(Grado grado) {
		if(grado!=null && grado.getId()==null) {
			return gradoRepo.save(grado);			
		}else {
			return null;

		}
	}

	/**
	 * Actualizar grado.
	 *
	 * @param grado the grado
	 * @return the grado
	 */
	@Override
	public Grado actualizarGrado(Grado grado) {
		if(grado!=null && grado.getId()!=null) {
			return gradoRepo.save(grado);
		}else {
			return null;
		}
	}

	/**
	 * Find grado by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Grado> findGradoById(Long id) {
		if(id!=null) {
			return gradoRepo.findById(id);			
		}else {
			return null;
		}
	}
	
	/**
	 * Gets the grado by name.
	 *
	 * @param nombre the nombre
	 * @return the grado by name
	 */
	@Override
	public Grado getGradoByName(String nombre) {
		if (nombre!=null) {
			return  gradoRepo.findByNombre(nombre);	
		}
		
		return null;
	}

}
