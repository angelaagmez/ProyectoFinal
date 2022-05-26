package com.iesalixar.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesalixar.proyecto.services.UsuarioServiceImp;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
@Controller
@RequestMapping("/")
public class MainController {

	/** The usuario service. */
	@Autowired
	UsuarioServiceImp usuarioService;
	
	/**
	 * Index page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("index")
	public String indexPage(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
}
