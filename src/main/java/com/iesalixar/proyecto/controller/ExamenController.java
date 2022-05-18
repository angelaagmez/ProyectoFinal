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

import com.iesalixar.proyecto.dto.ExamenDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Examen;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.ExamenServiceImp;
import com.iesalixar.proyecto.services.UsuarioServiceImp;

@Controller
@RequestMapping("/examenes")
public class ExamenController {
	
	@Autowired
	ExamenServiceImp examenService;
	
	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	@Autowired
	UsuarioServiceImp userService;
	
	@GetMapping("/")
	public String examenes(Model model) {
		model.addAttribute("examenes", examenService.getAllExamenes());
		
		return "examenes";
	}
	
	@GetMapping("/add")
	public String addExamenGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="examen") String examen,
			Model model) {
		
		ExamenDTO examenM = new ExamenDTO();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Usuario> usuarios = userService.getAllUsuarios();
		
		model.addAttribute("examen", examenM);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("usuarios", usuarios);
		return "addExamen";
	}
	
	
	@PostMapping("/add")
	public String addExamenPost(@ModelAttribute ExamenDTO examen,Model model) {
		
		Examen examenBD = new Examen();
		examenBD.setNum_preguntas(examen.getNum_preguntas());
		examenBD.setFecha_creacion(examen.getFecha_creacion());
		examenBD.setAsignatura(asignaturaService.findAsignaturaById(examen.getId_asignatura()).get());
		examenBD.setUsuario(userService.findUsuarioById(examen.getId_usuario()).get());
		
		if (examenService.insertarExamen(examenBD)==null) {
			return "redirect:/examenes/add?error=Existe&examen="+examen.getFecha_creacion();
		}
		
		return "redirect:/examenes/";
	}
	
	
	@GetMapping("/edit")
	public String editExam(@RequestParam(name="examen") String examen,Model model) {
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Usuario> usuarios = userService.getAllUsuarios();
		Optional<Examen> examenes = examenService.findExamenById(Long.parseLong(examen));
		model.addAttribute("asignaturas",asignaturas);	
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("examenes",examenes.get());
		return "editExamen";
	}
	
	
	@PostMapping("/edit")
	public String updateExam(@ModelAttribute Examen examen) {
		
		if (examenService.actualizarExamen(examen)==null) {
			return "redirect:/examenes/edit?error=error&examen"+examen.getId();
		}
		return "redirect:/examenes/";
	}
}
