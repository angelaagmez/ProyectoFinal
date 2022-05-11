package com.iesalixar.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>{
	public Grado findByNombre(String nombre);
}
