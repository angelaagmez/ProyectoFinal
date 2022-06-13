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

import com.iesalixar.proyecto.dto.AsignaturaDTO;
import com.iesalixar.proyecto.dto.MatricularseDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Matricularse;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.UsuarioServiceImp;


// TODO: Auto-generated Javadoc
/**
 * The Class MatricularseController.
 */
@Controller
@RequestMapping("/")
public class MatricularseController {
	
	/** The user service. */
	@Autowired
	UsuarioServiceImp userService;
	
	/** The asignatura service. */
	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	/**
	 * Matriculas.
	 *
	 * @param error the error
	 * @param matri the matri
	 * @param model the model
	 * @param a the a
	 * @return the string
	 */
	@GetMapping("matricularse")
	public String matriculas(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="matri") Long matri, Model model) {
		ArrayList<Usuario> usuarios = new ArrayList<>(userService.getAllUsuarios());
		
		
		MatricularseDTO matricula = new MatricularseDTO();
		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(matri);
		
		ArrayList<Matricularse> noMatric = new ArrayList<>(asignatura.get().getMatriculas());
		
		ArrayList<Usuario> removeUsu = new ArrayList<>();
		
		if(asignatura.isPresent()) {
			for (int i = 0; i < noMatric.size(); i++) {
				removeUsu.add(noMatric.get(i).getUsuario());
			}
			usuarios.removeAll(removeUsu);
		}
		
		matricula.setId_asignatura(asignatura.get().getId());
		
		model.addAttribute("asignatura",asignatura.get());
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("matricula", matricula);
		
		return "matricularse";
	}
	
	
	/**
	 * Matricula post.
	 *
	 * @param error the error
	 * @param matricula the matricula
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("matricularse")
	public String matriculaPost(@RequestParam(required=false,name="error") String error,
			@ModelAttribute MatricularseDTO matricula,Model model) {
		
		Asignatura asign = asignaturaService.findAsignaturaById(matricula.getId_asignatura()).get();
		Usuario usuario = userService.findUsuarioById(matricula.getId_usuario()).get();
	
		asign.addMatricula(usuario, matricula.getNum_alumnos());
	
		if (asignaturaService.actualizarAsignatura(asign)==null) {
			return "redirect:/matricularse?error=Existe";
		}
		
		return "redirect:/index";
	}
}
