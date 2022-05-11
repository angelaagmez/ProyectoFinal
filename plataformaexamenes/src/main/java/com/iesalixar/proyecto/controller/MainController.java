package com.iesalixar.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesalixar.proyecto.services.UsuarioServiceImp;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	UsuarioServiceImp usuarioService;
	
	@RequestMapping("index")
	public String indexPage(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	@RequestMapping("home")
	public String homePage(Model model) {
		model.addAttribute("contenido","HOME");
		return "home";
	}
}
