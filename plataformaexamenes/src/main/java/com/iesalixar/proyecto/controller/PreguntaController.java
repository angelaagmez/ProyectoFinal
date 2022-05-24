package com.iesalixar.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iesalixar.proyecto.dto.PreguntaDTO;
import com.iesalixar.proyecto.model.Examen;
import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.model.Pregunta;
import com.iesalixar.proyecto.services.ExamenServiceImp;
import com.iesalixar.proyecto.services.PreguntaServiceImp;

@Controller
@RequestMapping("/preguntas")
public class PreguntaController {
	@Autowired
	PreguntaServiceImp preguntaService;

	@Autowired
	ExamenServiceImp examenService;
	
	
	@RequestMapping("/")
	public String preguntas(Model model) {

		List<Pregunta> preguntas = preguntaService.getAllPreguntas();
		model.addAttribute("preguntas", preguntas);
		return "preguntas";
	}

	@GetMapping("/addPregunta")
	public String addPreguntaGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "pregunta") String pregunta, Model model) {

		PreguntaDTO preguntaM = new PreguntaDTO();
		List<Examen> examenes = examenService.getAllExamenes();

		model.addAttribute("pregunta", preguntaM);
		model.addAttribute("error", error);
		model.addAttribute("examenes", examenes);
		return "addPregunta";
	}

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
	
	@GetMapping("/edit")
	public String editPregunta(@RequestParam(name="pregunta") String pregunta,Model model) {
		List<Examen> examenes = examenService.getAllExamenes();
		Optional<Pregunta> preguntas = preguntaService.findPreguntaById(Long.parseLong(pregunta));
		model.addAttribute("examenes",examenes);	
		model.addAttribute("preguntas",preguntas.get());
		return "editPregunta";
	}
	
	
	@PostMapping("/edit")
	public String updateGrado(@ModelAttribute Pregunta pregunta) {
		
		if (preguntaService.actualizarPregunta(pregunta)==null) {
			return "redirect:/preguntas/edit?error=error&pregunta"+pregunta.getId();
		}
		return "redirect:/preguntas/";
	}

}
