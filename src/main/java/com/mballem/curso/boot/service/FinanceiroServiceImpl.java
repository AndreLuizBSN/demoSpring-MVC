package com.mballem.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.boot.dao.FinanceiroDao;
import com.mballem.curso.boot.domain.Financeiro;

@Service @Transactional(readOnly=false)
public class FinanceiroServiceImpl implements FinanceiroService {
	
	@Autowired
	private FinanceiroDao dao;

	@Override
	public void salvar(Financeiro financeiro) {
		dao.save(financeiro);
	}

	@Override
	public void editar(Financeiro financeiro) {
		dao.update(financeiro);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Financeiro buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Financeiro> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public Object buscarTodosPorForma(String forma) {
		return dao.findAllByForma(forma);
	}
	
}
