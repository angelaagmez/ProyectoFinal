package com.iesalixar.proyecto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long>{
//	public List<Examen> findByIdUsuario(Long id_usuario);
}
