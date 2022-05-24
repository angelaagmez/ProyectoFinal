package com.iesalixar.proyecto.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LoginController {
//	@Autowired
//	private UsuarioService usuarioService;
//
//	@GetMapping("login")
//	public String loginForm(@RequestParam(required = false, name = "error") String error, Model model) {
//		
//		UsuarioLoginDTO usuarioDTO = new UsuarioLoginDTO();
//		model.addAttribute("usuario", usuarioDTO);
//		model.addAttribute("error", error);
//		
//		return "login";
//	}
//
//	@PostMapping("login")
//	public String loginSubmit(@ModelAttribute UsuarioLoginDTO usuarioDTO, Model model) {
//
//		if (usuarioService.findUserByUsername(usuarioDTO.getUserName()) != null) {
//			Usuario usuario = new Usuario();
//
//			usuario.setUserName(usuarioDTO.getUserName());
//			usuario.setPassword(usuarioDTO.getPassword());
//			
//			return "redirect:/index";
//
//		} else {
//			return "redirect:/login?error=Existe&usuario=" + usuarioDTO.getUserName();
//		}
//	}

}
