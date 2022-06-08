package com.iesalixar.proyecto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.repository.AsignaturaRepository;


/**
 * The Class AsignaturaServiceImp.
 */
@Service
public class AsignaturaServiceImp implements AsignaturaService {

	/** The asignatura repo. */
	@Autowired
	AsignaturaRepository asignaturaRepo;

	/**
	 * Gets the all asignaturas.
	 *
	 * @return the all asignaturas
	 */
	@Override
	public List<Asignatura> getAllAsignaturas() {
		List<Asignatura> asignaturas = asignaturaRepo.findAll();
		if(asignaturas != null && asignaturas.size()>0) {
			
			return asignaturas;
		}else {
			return new ArrayList<Asignatura>();
		}
	}

	/**
	 * Find asignatura by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Asignatura> findAsignaturaById(Long id) {
		return asignaturaRepo.findById(id);			
	}
	
	/**
	 * Gets the asignatura by name.
	 *
	 * @param nombre the nombre
	 * @return the asignatura by name
	 */
	@Override
	public Asignatura getAsignaturaByName(String nombre) {
		if (nombre!=null) {
			return asignaturaRepo.findByNombre(nombre); 			
		}
		return null;
	}

	/**
	 * Insertar asignatura.
	 *
	 * @param asignatura the asignatura
	 * @return the asignatura
	 */
	@Override
	public Asignatura insertarAsignatura(Asignatura asignatura) {
		if (asignatura!=null && asignatura.getId()==null) {
			return asignaturaRepo.save(asignatura);
		}
		return null;
	}

	/**
	 * Actualizar asignatura.
	 *
	 * @param asignatura the asignatura
	 * @return the asignatura
	 */
	@Override
	public Asignatura actualizarAsignatura(Asignatura asignatura) {
		if (asignatura!=null && asignatura.getId()!=null && asignatura.getNombre()!=null) {
			return asignaturaRepo.save(asignatura); 
		}
		return null;
	}


	/**
	 * Find by ids.
	 *
	 * @param idList the id list
	 * @return the list
	 */
	@Override
	public List<Asignatura> findByIds(List<Long> idList) {
		if(idList.size()>0 && idList!=null) {
			return asignaturaRepo.findAllById(idList);
		}
		return null;
	}
}
