package com.mballem.curso.boot.service;

import java.util.List;

import com.mballem.curso.boot.domain.TipoFinanceiro;

public interface TipoFinanceiroService {

	void salvar(TipoFinanceiro tipoFinanceiro);
	
	void editar(TipoFinanceiro tipoFinanceiro);
	
	void excluir(Long id);
	
	TipoFinanceiro buscarPorId(Long id);
	
	List<TipoFinanceiro> buscarTodos();	
}
