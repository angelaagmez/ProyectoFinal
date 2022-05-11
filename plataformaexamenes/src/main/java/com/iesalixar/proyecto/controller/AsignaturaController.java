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

import com.iesalixar.proyecto.dto.AsignaturaDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.GradoServiceImp;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	@Autowired
	GradoServiceImp gradoService;
	
	@GetMapping("/")
	public String asignaturas(Model model) {
		model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas());
		
		return "asignaturas";
	}

	// MATRICULARSE
//	@GetMapping("/alumnos")
//	public String asignaturasAlumnos(@RequestParam(required=false, name="codigo") String codigo, Model model) {
//		if(codigo==null) {
//			return "redirect:/asignaturas/";
//		}
//		
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
//		
//		model.addAttribute("asignatura", asignatura.get());
//		
//		return "asignaturasAlumnos";
//	}
	
	@GetMapping("/add")
	public String addAsignaturaGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asig") String nombre,
			Model model) {
		
		AsignaturaDTO asig = new AsignaturaDTO();
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("asig", asig);
		model.addAttribute("grados", grados);
		model.addAttribute("error", error);
		return "addAsignatura";
	}
	
	
	@PostMapping("/add")
	public String addAsignaturaPost(@ModelAttribute AsignaturaDTO asig,Model model) {
		
		Asignatura asigBD = new Asignatura();
		asigBD.setNombre(asig.getNombre());
		asigBD.setCurso(asig.getCurso());
		asigBD.setGrado(gradoService.findGradoById(asig.getId_grado()).get());
		
		if (asignaturaService.insertarAsignatura(asigBD)==null) {
			return "redirect:/asignaturas/add?error=Existe&asig="+asig.getNombre();
		}
		
		return "redirect:/asignaturas/";
	}
	
	
	@GetMapping("/edit")
	public String editAsig(@RequestParam(name="asig") String asig,Model model) {
		List<Grado> grados = gradoService.getAllGrados();
		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig));
		model.addAttribute("asignatura",asignatura.get());	
		model.addAttribute("grados",grados);
		return "editAsignatura";
	}
	
	
	@PostMapping("/edit")
	public String updateAsig(@ModelAttribute Asignatura asig) {
		
		if (asignaturaService.actualizarAsignatura(asig)==null) {
			return "redirect:/asignaturas/edit?error=error&asig"+asig.getId();
		}
		return "redirect:/asignaturas/";
	}
	
//	@GetMapping("/alumnos/delete")
//	public String asignaturaAlumnoDelete(@RequestParam(required=true, name="asig") String asig,
//			@RequestParam(required=true, name="alumn") String alumn){
//		
//		Asignatura asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig)).get();
//		if(asignatura !=null) {
//			Alumno alumno = alumnoService.findAlumnoById(Long.parseLong(alumn)).get();				
//			asignatura.removeNota(alumno);
//			asignaturaService.actualizarAsignatura(asignatura);
//			return "redirect:/asignaturas/alumnos?codigo="+asig;
//		}else {
//			return "redirect:/asignaturas/";
//		}			
//	}
}
