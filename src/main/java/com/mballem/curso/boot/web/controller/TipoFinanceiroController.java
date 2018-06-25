package com.mballem.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.boot.domain.EntradaSaida;
import com.mballem.curso.boot.domain.TipoFinanceiro;
import com.mballem.curso.boot.service.TipoFinanceiroService;

@Controller
@RequestMapping("tipofinanceiro")
public class TipoFinanceiroController {

	@Autowired
	private TipoFinanceiroService service;
	//@Autowired
	//private HttpSession session;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("tipoFinanceiros", service.buscarTodos());
		return "tipofinanceiro/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(TipoFinanceiro tipoFinanceiro) {
		tipoFinanceiro.setAtivo(true);
		return "tipofinanceiro/cadastro";
	}
	
	@ModelAttribute("entradaSaida")
	public EntradaSaida[] listaEntradaSaida(){
		return EntradaSaida.values();
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid TipoFinanceiro tipoFinanceiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "tipofinanceiro/cadastro";
		}
		service.salvar(tipoFinanceiro);
		attr.addFlashAttribute("success", "Tipo de financeiro salvo com sucesso!");
		return "redirect:/tipofinanceiro/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tipoFinanceiro", service.buscarPorId(id));
		return "tipofinanceiro/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid TipoFinanceiro tipoFinanceiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "tipofinanceiro/cadastro";
		}
		service.editar(tipoFinanceiro);
		attr.addFlashAttribute("success", "Tipo financeiro alterado com sucesso!");
		return "redirect:/tipofinanceiro/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Tipo financeiro removido com sucesso!");
		return listar(model);
	}
}
