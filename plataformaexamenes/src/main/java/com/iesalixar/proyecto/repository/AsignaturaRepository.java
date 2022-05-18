package com.iesalixar.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	public Asignatura findByNombre(String nombre);
//	public List<Asignatura> findByIds(List<Long> idList);
}
