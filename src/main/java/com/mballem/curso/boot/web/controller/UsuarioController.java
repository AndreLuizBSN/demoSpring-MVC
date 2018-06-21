package com.mballem.curso.boot.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mballem.curso.boot.domain.Usuario;
import com.mballem.curso.boot.service.UsuarioService;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String telaLogin(Usuario usuario) {
		return "usuario/login";
	}
	
	@PostMapping("/logar")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		
		usuario = usuarioService.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());
		session.removeAttribute("usuarioLogado");
		
		if(!usuario.getNome().isEmpty()) {
			System.out.println("Usuário: "+usuario.getNome());
			session.setAttribute("usuarioLogado", usuario);
			System.out.println(session.getAttribute("usuarioLogado"));
			//return "redirect:/";
		}
		return "redirect:/usuarios/login";
	}
	
}
