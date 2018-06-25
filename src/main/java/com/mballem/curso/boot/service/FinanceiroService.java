package com.mballem.curso.boot.service;

import java.util.List;

import com.mballem.curso.boot.domain.Financeiro;

public interface FinanceiroService {

	void salvar(Financeiro financeiro);
	
	void editar(Financeiro financeiro);
	
	void excluir(Long id);
	
	Financeiro buscarPorId(Long id);
	
	List<Financeiro> buscarTodos();

	Object buscarTodosPorForma(String forma);	
}
