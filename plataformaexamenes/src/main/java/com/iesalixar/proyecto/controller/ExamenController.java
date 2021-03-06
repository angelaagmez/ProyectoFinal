package com.iesalixar.proyecto.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.iesalixar.proyecto.dto.ExamenDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Examen;
import com.iesalixar.proyecto.model.Matricularse;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.ExamenServiceImp;
import com.iesalixar.proyecto.services.UsuarioServiceImp;


// TODO: Auto-generated Javadoc
/**
 * The Class ExamenController.
 */
@Controller
@RequestMapping("/examenes")
public class ExamenController {
	
	/** The examen service. */
	@Autowired
	ExamenServiceImp examenService;
	
	/** The asignatura service. */
	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	/** The user service. */
	@Autowired
	UsuarioServiceImp userService;
	
	/**
	 * Examenes.
	 *
	 * @param model the model
	 * @param a the a
	 * @return the string
	 */
	@GetMapping("/")
	public String examenes(Model model, Authentication a) {
		Usuario usuario = userService.findUserByUsername(a.getName());
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			List<Examen> examenes = examenService.getAllExamenes();
			model.addAttribute("examenes", examenes);
		}else {
			model.addAttribute("usuario", usuario);
		}
		model.addAttribute("usuario", usuario);
		return "examenes";
	}
	
	/**
	 * Adds the examen get.
	 *
	 * @param error the error
	 * @param examen the examen
	 * @param model the model
	 * @param a the a
	 * @return the string
	 */
	@GetMapping("/add")
	public String addExamenGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="exam") String examen,
			Model model, Authentication a) {
		
		ExamenDTO exam = new ExamenDTO();
		
		ArrayList<Asignatura> asignaturas;
		Usuario usuario = userService.findUserByUsername(a.getName());
			
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			List<Usuario> usuarios = userService.getAllUsuarios();
			model.addAttribute("usuarios", usuarios);
			asignaturas  = new ArrayList<>(asignaturaService.getAllAsignaturas());
		} else {
			model.addAttribute("usuario", usuario);
			
			ArrayList<Matricularse> listMatri = new ArrayList<>(usuario.getMatriculas());
			asignaturas = new ArrayList<>();
			
			for (int i = 0; i < listMatri.size(); i++) {
				asignaturas.add(listMatri.get(i).getAsignatura());
			}
			
		}
		
		model.addAttribute("exam", exam);
		model.addAttribute("asignaturas", asignaturas);
		
		return "addExamen";
	}
	
	
	/**
	 * Adds the examen post.
	 *
	 * @param exam the exam
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/add")
	public String addExamenPost(@ModelAttribute ExamenDTO exam,Model model, Authentication a) {
		
		Examen examenBD = new Examen();
		examenBD.setNum_preguntas(exam.getNum_preguntas());
		examenBD.setFecha_creacion(exam.getFecha_creacion());
		examenBD.setAsignatura(asignaturaService.findAsignaturaById(exam.getId_asignatura()).get());
		
		Usuario usuario = userService.findUserByUsername(a.getName());
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			examenBD.setUsuario(userService.findUsuarioById(exam.getId_usuario()).get());
		} else {
			examenBD.setUsuario(usuario);
		}
		
		
		
		if (examenService.insertarExamen(examenBD)==null) {
			return "redirect:/examenes/add?error=Existe";
		}
		
		return "redirect:/examenes/";
	}
	
	
	/**
	 * Edits the exam.
	 *
	 * @param exam the exam
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/edit")
	public String editExam(@RequestParam(name="exam") String exam,Model model, Authentication a) {
		
		Optional<Examen> examenes = examenService.findExamenById(Long.parseLong(exam));
		
		ArrayList<Asignatura> asignaturas;
		Usuario usuario = userService.findUserByUsername(a.getName());
			
		
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			List<Usuario> usuarios = userService.getAllUsuarios();
			model.addAttribute("usuarios", usuarios);
			asignaturas  = new ArrayList<>(asignaturaService.getAllAsignaturas());
		} else {
			model.addAttribute("usuario", usuario);
			
			ArrayList<Matricularse> listMatri = new ArrayList<>(usuario.getMatriculas());
			asignaturas = new ArrayList<>();
			
			for (int i = 0; i < listMatri.size(); i++) {
				asignaturas.add(listMatri.get(i).getAsignatura());
			}
			
		}
		
		model.addAttribute("asignaturas",asignaturas);	
		model.addAttribute("exam",examenes.get());
		
		return "editExamen";
	}
	
	
	/**
	 * Update exam.
	 *
	 * @param exam the exam
	 * @return the string
	 */
	@PostMapping("/edit")
	public String updateExam(@ModelAttribute Examen exam, Model model) {
		System.out.println(exam);
		System.out.println(exam.getId());
		System.out.println(exam.getUsuario());
		System.out.println(exam.getAsignatura());
		
		if (examenService.actualizarExamen(exam)==null) {
			return "redirect:/examenes/edit?error=error&exam"+exam.getId();
		}
		return "redirect:/examenes/";
	}
}
