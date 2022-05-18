package com.iesalixar.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.proyecto.model.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{
//	public String findByPregunta(String preguntas);
}
