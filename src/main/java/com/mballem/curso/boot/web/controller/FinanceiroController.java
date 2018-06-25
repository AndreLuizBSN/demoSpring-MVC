package com.mballem.curso.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

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
import com.mballem.curso.boot.domain.Financeiro;
import com.mballem.curso.boot.domain.TipoFinanceiro;
import com.mballem.curso.boot.service.FinanceiroService;
import com.mballem.curso.boot.service.TipoFinanceiroService;

@Controller
@RequestMapping("financeiro")
public class FinanceiroController {

	@Autowired
	private FinanceiroService service;
	@Autowired
	private TipoFinanceiroService tipoFinanceiroService;
	//@Autowired
	//private HttpSession session;
	
	@GetMapping("/listar/{forma}")
	public String listar(@PathVariable("forma") String forma, ModelMap model) {
		model.addAttribute("financeiros", service.buscarTodosPorForma(forma));
		model.addAttribute("forma", forma);
		return "financeiro/lista";
	}
	
	@GetMapping("/cadastrar/{forma}")
	public String cadastrar(@PathVariable("forma") String forma, Financeiro financeiro, ModelMap model) {
		if("entrada".equals(forma)) {
			financeiro.setEntradaSaida(EntradaSaida.ENTRADA);
		}else {
			financeiro.setEntradaSaida(EntradaSaida.SAIDA);
		}
		financeiro.setDataCadastro(LocalDate.now());
		model.addAttribute("forma", forma);
		return "financeiro/cadastro";
	}
	
	@ModelAttribute("entradaSaida")
	public EntradaSaida[] listaEntradaSaida(){
		return EntradaSaida.values();
	}
	
	@ModelAttribute("tipoFinanceiros")
	public List<TipoFinanceiro> listaDeTipoFinanceiros(){
		return tipoFinanceiroService.buscarTodos();
	}
		
	@PostMapping("/salvar/{forma}")
	public String salvar(
				@PathVariable("forma") String forma
				, @Valid Financeiro financeiro
				, BindingResult result
				, RedirectAttributes attr
				) {
		if(result.hasErrors()) {
			return "financeiro/cadastro";
		}
		
		System.out.println(financeiro.getEntradaSaida().getDescricao());
		
		service.salvar(financeiro);
		attr.addFlashAttribute("success", "Financeiro salvo com sucesso!");
		return "redirect:/financeiro/listar/"+forma;
	}
	
	@GetMapping("/editar/{forma}/{id}")
	public String preEditar(@PathVariable("forma") String forma, @PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("financeiro", service.buscarPorId(id));
		model.addAttribute("forma", forma);
		return "financeiro/cadastro";
	}
	
	@PostMapping("/editar/{forma}")
	public String editar(@PathVariable("forma") String forma, @Valid Financeiro financeiro, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "financeiro/cadastro";
		}
		service.editar(financeiro);
		attr.addFlashAttribute("success", "Financeiro alterado com sucesso!");
		return "redirect:/financeiro/listar/"+forma;
	}
	
	@GetMapping("/excluir/{forma}/{id}")
	public String excluir(@PathVariable("forma") String forma, @PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Financeiro removido com sucesso!");
		return listar(forma, model);
	}
}
