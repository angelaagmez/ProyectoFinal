package com.iesalixar.proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iesalixar.proyecto.dto.PreguntaDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Examen;
import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.model.Pregunta;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.ExamenServiceImp;
import com.iesalixar.proyecto.services.PreguntaServiceImp;
import com.iesalixar.proyecto.services.UsuarioServiceImp;


// TODO: Auto-generated Javadoc
/**
 * The Class PreguntaController.
 */
@Controller
@RequestMapping("/preguntas")
public class PreguntaController {
	
	/** The pregunta service. */
	@Autowired
	PreguntaServiceImp preguntaService;

	/** The examen service. */
	@Autowired
	ExamenServiceImp examenService;
	
	@Autowired
	UsuarioServiceImp userService;
	
	
	/**
	 * Preguntas.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/")
	public String preguntas(Model model, Authentication a) {
		Usuario usuario = userService.findUserByUsername(a.getName());
		
		ArrayList<Pregunta> preguntas;
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			preguntas = new ArrayList<>(preguntaService.getAllPreguntas());
		} else {
			preguntas = new ArrayList<>();
			
			for (Examen examen : usuario.getExamenes()) {
				preguntas.addAll(examen.getPreguntas());
			}
			
		}
		
		model.addAttribute("preguntas", preguntas);
		return "preguntas";
	}

	/**
	 * Adds the pregunta get.
	 *
	 * @param error the error
	 * @param pregunta the pregunta
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/addPregunta")
	public String addPreguntaGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "pregunta") String pregunta, Model model, Authentication a) {

		Usuario usuario = userService.findUserByUsername(a.getName());
		
		PreguntaDTO preguntaM = new PreguntaDTO();
		ArrayList<Examen> examenes;
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			examenes = new ArrayList<>(examenService.getAllExamenes());
		} else {
			examenes = new ArrayList<>(usuario.getExamenes());
		}
		
		model.addAttribute("pregunta", preguntaM);
		model.addAttribute("error", error);
		model.addAttribute("examenes", examenes);
		return "addPregunta";
	}

	/**
	 * Adds the pregunta post.
	 *
	 * @param pregunta the pregunta
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addPregunta")
	public String addPreguntaPost(@ModelAttribute PreguntaDTO pregunta, Model model) {

		Pregunta preguntaBD = new Pregunta();
		preguntaBD.setPreguntas(pregunta.getPreguntas());
		preguntaBD.setNum_pregunta(pregunta.getNum_pregunta());
		preguntaBD.setRespuestas(pregunta.getRespuestas());
		preguntaBD.setExamen(examenService.findExamenById(pregunta.getId_examen()).get());
		
		Examen examen = examenService.findExamenById(pregunta.getId_examen()).get();
		
		examen.setNum_preguntas(examen.getNum_preguntas()+1);
		

		if (preguntaService.insertarPregunta(preguntaBD) == null) {
			return "redirect:/preguntas/addPregunta?error=Existe&pregunta=" + pregunta.getPreguntas();
		}

		return "redirect:/preguntas/";
	}
	
	/**
	 * Edits the pregunta.
	 *
	 * @param pregunta the pregunta
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/edit")
	public String editPregunta(@RequestParam(name="pregunta") String pregunta,Model model, Authentication a) {
		Usuario usuario = userService.findUserByUsername(a.getName());
		
		ArrayList<Examen> examenes;
		Optional<Pregunta> preguntas = preguntaService.findPreguntaById(Long.parseLong(pregunta));
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			examenes = new ArrayList<>(examenService.getAllExamenes());
		} else {
			examenes = new ArrayList<>(usuario.getExamenes());
		}
		
		model.addAttribute("examenes",examenes);	
		model.addAttribute("preguntas",preguntas.get());
		return "editPregunta";
	}
	
	
	/**
	 * Update grado.
	 *
	 * @param pregunta the pregunta
	 * @return the string
	 */
	@PostMapping("/edit")
	public String updateGrado(@ModelAttribute Pregunta pregunta) {
		
		if (preguntaService.actualizarPregunta(pregunta)==null) {
			return "redirect:/preguntas/edit?error=error&pregunta"+pregunta.getId();
		}
		return "redirect:/preguntas/";
	}

}
