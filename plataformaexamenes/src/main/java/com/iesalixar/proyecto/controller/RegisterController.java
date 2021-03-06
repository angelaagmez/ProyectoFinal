package com.iesalixar.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iesalixar.proyecto.dto.UsuarioDTO;
import com.iesalixar.proyecto.model.Usuario;
import com.iesalixar.proyecto.services.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterController.
 */
@Controller
@RequestMapping("/")
public class RegisterController {
	
    /** The usuario service. */
    @Autowired 
    private UsuarioService usuarioService;
    
    /** The password encoder. */
    @Autowired 
    private PasswordEncoder passwordEncoder;
 
    /**
     * Register form.
     *
     * @param error the error
     * @param model the model
     * @return the string
     */
    @GetMapping("register")
    public String registerForm(@RequestParam(required=false,name="error")String error, 
    		Model model) {
    	
    	UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("error", error);
        return "register";
    }
 
    /**
     * Register submit.
     *
     * @param usuarioDTO the usuario DTO
     * @param model the model
     * @param redirectAttrs the redirect attrs
     * @return the string
     */
    @PostMapping("register")
    public String registerSubmit(@ModelAttribute UsuarioDTO usuarioDTO,
    		Model model, RedirectAttributes redirectAttrs) {
 
    	if(usuarioService.findUserByUsername(usuarioDTO.getUserName())==null) {
    		Usuario usuario = new Usuario();
    		
    		String passwd = usuarioDTO.getPassword();
    		String passwdEncrip = passwordEncoder.encode(passwd);
    		
    		usuario.setUserName(usuarioDTO.getUserName());
    		usuario.setEmail(usuarioDTO.getEmail());
    		usuario.setPassword(passwdEncrip);
    		usuario.setNombre(usuarioDTO.getNombre());
    		usuario.setApellidos(usuarioDTO.getApellidos());
    		
    		if(usuarioService.insertUsuario(usuario)==null){
    			redirectAttrs
	    			.addFlashAttribute("mensaje","Error al registrar")
					.addFlashAttribute("clase","fail");
    			return "redirect:/login?error=Existe&usuario="+usuarioDTO.getUserName();
    		}else {
    			redirectAttrs
	    			.addFlashAttribute("mensaje","Registrado Correctamente")
					.addFlashAttribute("clase","success");	
    			return "redirect:login";
    		}
    	}else {
    		redirectAttrs
    			.addFlashAttribute("mensaje","El usuario ya existe")
    			.addFlashAttribute("clase","fail");
    		return "redirect:login?error=Existe&usuario="+usuarioDTO.getUserName();
    	}
 
    }

}
