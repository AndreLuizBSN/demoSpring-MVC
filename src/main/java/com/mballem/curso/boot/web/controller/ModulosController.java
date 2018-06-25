package com.mballem.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modulos")
public class ModulosController {

	@GetMapping("/financeiro")
	public String financeiro() {
		return "modulos/financeiro";
	}
	
}
