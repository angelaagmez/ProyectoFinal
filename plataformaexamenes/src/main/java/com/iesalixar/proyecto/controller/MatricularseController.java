package com.iesalixar.proyecto.controller;

import java.util.List;

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

@Controller
@RequestMapping("/matricularse")
public class MatricularseController {
	
	@Autowired
	UsuarioServiceImp userService;
	
	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	@GetMapping("/")
	public String matriculas(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="matri") String matri, Model model, Authentication a) {
		List<Usuario> usuarios = userService.getAllUsuarios();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		
		MatricularseDTO matricula = new MatricularseDTO();
		
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("matricula", matricula);
		
		return "matricularse";
	}
	
	
	@PostMapping("/")
	public String matriculaPost(@RequestParam(required=false,name="error") String error,
			@ModelAttribute MatricularseDTO matri,Model model) {
		
		Matricularse matriBD = new Matricularse();
		matriBD.setAsignatura(asignaturaService.findAsignaturaById(matri.getId_asignatura()).get());
		matriBD.setUsuario(userService.findUsuarioById(matri.getId_usuario()).get());
		matriBD.setNum_alumnos(matri.getNum_alumnos());
		
		if (asignaturaService.insertarAsignatura(matriBD.getAsignatura())==null) {
			return "redirect:/matricularse?error=Existe&matri="+matri.getId_asignatura();
		}
		
		return "redirect:/matricularse";
	}
}
