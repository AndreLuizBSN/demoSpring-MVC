package com.mballem.curso.boot.web.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.boot.domain.Departamento;
import com.mballem.curso.boot.domain.Usuario;
import com.mballem.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	//@Autowired
	//private HttpSession session;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		//session.invalidate();
		
		//Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		//System.out.println("Sessao aa: "+usuario.getSenha());
		model.addAttribute("departamentos", service.buscarTodos());
		return "departamento/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		departamento.setAtivo(true);
		return "departamento/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		service.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento salvo com sucesso!");
		return "redirect:/departamentos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		service.editar(departamento);
		attr.addFlashAttribute("success", "Departamento alterado com sucesso!");
		return "redirect:/departamentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.departamentoTemCargo(id)) {
			model.addAttribute("fail", "Departamento não removido, pois possui cargos vinculados!");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Departamento removido com sucesso!");
		}
		return listar(model);
	}
}
