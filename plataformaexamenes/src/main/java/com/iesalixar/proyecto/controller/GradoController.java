package com.iesalixar.proyecto.controller;

import java.util.ArrayList;
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

import com.iesalixar.proyecto.dto.AsignaturaIdsDTO;
import com.iesalixar.proyecto.dto.GradoDTO;
import com.iesalixar.proyecto.model.Asignatura;
import com.iesalixar.proyecto.model.Grado;
import com.iesalixar.proyecto.services.AsignaturaServiceImp;
import com.iesalixar.proyecto.services.GradoServiceImp;

@Controller
@RequestMapping("/grados")
public class GradoController {

	@Autowired
	GradoServiceImp gradoService;

	@Autowired
	AsignaturaServiceImp asignaturaService;

	@RequestMapping("/")
	public String grados(Model model) {

		List<Grado> grados = gradoService.getAllGrados();
		model.addAttribute("grados", grados);
		return "grados";
	}

	@GetMapping("/addGrado")
	public String addGradoGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "grado") String grado, Model model) {

		GradoDTO gradoM = new GradoDTO();

		model.addAttribute("grado", gradoM);
		model.addAttribute("error", error);
		model.addAttribute("previo", grado);
		return "addGrado";
	}

	@PostMapping("/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO grado, Model model) {

		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());

		if (gradoService.insertarGrado(gradoBD) == null) {
			return "redirect:/grados/addGrado?error=Existe&grado=" + grado.getNombre();
		}

		return "redirect:/grados/";
	}

	@GetMapping("/asignaturas")
	public String asignaturasGrado(@RequestParam(required = false, name = "codigo") String codigo,
			@RequestParam(required = false, name = "exito") String exito, Model model) {
		
		
		if (codigo == null) {
			return "redirect:/grados/";
		} else {
			if(exito!=null) {
				model.addAttribute("exito",exito);
			}
			Optional<Grado> grado = gradoService.findGradoById(Long.parseLong(codigo));
			model.addAttribute("asignaturas", grado.get().getAsignaturas());
			return "AsignaturasGrado";
		}
	}

	@GetMapping("/addasignatura")
	public String addAsignaturaGet(@RequestParam(required = false, name = "error") String error, 
			@RequestParam(required=false,name="id_grado") String id_grado, Model model) {

		AsignaturaIdsDTO asig = new AsignaturaIdsDTO();
		List<Grado> grados = gradoService.getAllGrados();

		List<Asignatura> asignaturasPrev = asignaturaService.getAllAsignaturas();
		List<Asignatura> asignaturas = new ArrayList<>();
		for (int i = 0; i < asignaturasPrev.size(); i++) {
			Asignatura asignatura = asignaturasPrev.get(i);
			if (asignatura.getGrado() == null) {
				asignaturas.add(asignatura);
			}
		}
		model.addAttribute("asig", asig);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("grados", grados);
		model.addAttribute("error", error);
		if(id_grado != null) {
			model.addAttribute("id_grado", id_grado);
		}
		return "addAsignaturaGrado";
	}

	@PostMapping("/addasignatura")
	public String addAsignaturaPost(@ModelAttribute AsignaturaIdsDTO asig, Model model) {

		Asignatura asigBD = asignaturaService.findAsignaturaById(asig.getId_asignatura()).get();
		Grado gradoDB = gradoService.findGradoById(asig.getId_grado()).get();
		asigBD.setGrado(gradoDB);

		if (asignaturaService.actualizarAsignatura(asigBD) == null) {
			return "redirect:/grados/addasignaturas?error=error&asig=" + asigBD.getId() + "&grad=" + gradoDB.getId();
		}

		return "redirect:/grados/asignaturas?codigo=" + gradoDB.getId();
	}
	
	@GetMapping("/edit")
	public String editGrado(@RequestParam(name="grado") String grado,Model model) {
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		Optional<Grado> grados = gradoService.findGradoById(Long.parseLong(grado));
		model.addAttribute("asignatura",asignaturas);	
		model.addAttribute("grados",grados.get());
		return "editGrado";
	}
	
	
	@PostMapping("/edit")
	public String updateGrado(@ModelAttribute Grado grado) {
		
		if (gradoService.actualizarGrado(grado)==null) {
			return "redirect:/grados/edit?error=error&grado"+grado.getId();
		}
		return "redirect:/grados/";
	}
	
	@GetMapping("/asignaturas/delete")
	public String borrarAsignaturaGrado(			
			@RequestParam(required=false,name="asig") String asig,
			Model model) {
		
		Asignatura asigEntity = asignaturaService.findAsignaturaById(Long.parseLong(asig)).get();
		Long gradoId = asigEntity.getGrado().getId();
		
		asigEntity.setGrado(null);
		
		asignaturaService.actualizarAsignatura(asigEntity);
		
		return "redirect:/grados/asignaturas?codigo="+gradoId+"&exito=Asignatura '"+asigEntity.getNombre().toUpperCase()+"' borrada correctamente";
	}
	
}
