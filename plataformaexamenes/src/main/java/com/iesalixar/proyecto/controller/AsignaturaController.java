package com.iesalixar.proyecto.controller;

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
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.GradoServiceImp;
import com.iesalixar.proyecto.services.UsuarioServiceImp;

// TODO: Auto-generated Javadoc
/**
 * The Class AsignaturaController.
 */
@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

	/** The asignatura service. */
	@Autowired
	AsignaturaServiceImp asignaturaService;
	
	/** The grado service. */
	@Autowired
	GradoServiceImp gradoService;
	
	/** The user service. */
	@Autowired
	UsuarioServiceImp userService;
	
	
	/**
	 * Asignaturas.
	 *
	 * @param model the model
	 * @param a the a
	 * @return the string
	 */
	@GetMapping("/")
	public String asignaturas(Model model, Authentication a) {
		Usuario usuario = userService.findUserByUsername(a.getName());
		if(usuario.getRol().equalsIgnoreCase("ROLE_ADMIN")) {
			List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
			model.addAttribute("asignaturas", asignaturas);
		}else {
			model.addAttribute("usuario", usuario);
		}
		
		return "asignaturas";
	}

	
	/**
	 * Adds the asignatura get.
	 *
	 * @param error the error
	 * @param nombre the nombre
	 * @param model the model
	 * @return the string
	 */
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
	
	
	/**
	 * Adds the asignatura post.
	 *
	 * @param asig the asig
	 * @param model the model
	 * @return the string
	 */
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
	
	
	/**
	 * Edits the asig.
	 *
	 * @param asig the asig
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/edit")
	public String editAsig(@RequestParam(name="asig") String asig,Model model) {
		List<Grado> grados = gradoService.getAllGrados();
		Optional<Asignatura> asignaturas = asignaturaService.findAsignaturaById(Long.parseLong(asig));
		
		model.addAttribute("asignatura",asignaturas.get());	
		model.addAttribute("grados",grados);
		return "editAsignatura";
	}
	
	
	/**
	 * Update asig.
	 *
	 * @param asig the asig
	 * @return the string
	 */
	@PostMapping("/edit")
	public String updateAsig(@ModelAttribute Asignatura asig) { 
		
		if (asignaturaService.actualizarAsignatura(asig)==null) {
			return "redirect:/asignaturas/edit?error=error&asig"+asig.getId();
		}
		return "redirect:/asignaturas/";
	}
	// MATRICULARSE
//	@GetMapping("/asignaturas")
//	public String asignaturasGrado(@RequestParam(required = false, name = "codigo") String codigo,@RequestParam(required = false, name = "exito") String exito, Model model) {
//		
//		
//		if (codigo == null) {
//			return "redirect:/alumnos/";
//		} else {
//			if(exito!=null) {
//				model.addAttribute("exito",exito);
//			}
//			Optional<Grado> grado = gradoService.findGradoById(Long.parseLong(codigo));
//			model.addAttribute("asignaturas", grado.get().getAsignaturas());
//			return "AsignaturasGrado";
//		}
//	}
//
//	@GetMapping("/addasignatura")
//	public String addAsignaturaGet(@RequestParam(required = false, name = "error") String error, @RequestParam(required=false,name="id_grado") String id_grado, Model model) {
//
//		AsignaturaIdsDTO asig = new AsignaturaIdsDTO();
//		List<Grado> grados = gradoService.getAllGrados();
//
//		List<Asignatura> asignaturasPrev = asignaturaService.getAllAsignaturas();
//		List<Asignatura> asignaturas = new ArrayList<>();
//		for (int i = 0; i < asignaturasPrev.size(); i++) {
//			Asignatura asignatura = asignaturasPrev.get(i);
//			if (asignatura.getGrado() == null) {
//				asignaturas.add(asignatura);
//			}
//		}
//		model.addAttribute("asig", asig);
//		model.addAttribute("asignaturas", asignaturas);
//		model.addAttribute("grados", grados);
//		model.addAttribute("error", error);
//		if(id_grado != null) {
//			model.addAttribute("id_grad", id_grado);
//		}
//		return "addAsignaturaGrado";
//	}
//
//	@PostMapping("/addasignatura")
//	public String addAsignaturaPost(@ModelAttribute AsignaturaIdsDTO asig, Model model) {
//
//		Asignatura asigBD = asignaturaService.findAsignaturaById(asig.getId_asignatura()).get();
//		Grado gradoDB = gradoService.findGradoById(asig.getId_grado()).get();
//		asigBD.setGrado(gradoDB);
//
//		if (asignaturaService.actualizarAsignatura(asigBD) == null) {
//			return "redirect:/grados/addasignaturas?error=error&asig=" + asigBD.getId() + "&grad=" + gradoDB.getId();
//		}
//
//		return "redirect:/grados/asignaturas?codigo=" + gradoDB.getId();
//	}
	
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
