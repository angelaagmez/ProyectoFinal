package com.iesalixar.proyecto.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.iesalixar.proyecto.model.Examen;

public interface ExamenService {
	public List<Examen> getAllExamenes();
	public Optional<Examen> findExamenById(Long id);
	public Examen insertarExamen(Examen examen);
	public Examen actualizarExamen(Examen examen);
//	public List<Examen> findByIdUsuario(Long id_usuario);
}
