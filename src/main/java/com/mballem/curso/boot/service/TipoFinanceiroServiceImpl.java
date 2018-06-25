package com.mballem.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.boot.dao.TipoFinanceiroDao;
import com.mballem.curso.boot.domain.TipoFinanceiro;

@Service @Transactional(readOnly=false)
public class TipoFinanceiroServiceImpl implements TipoFinanceiroService {
	
	@Autowired
	private TipoFinanceiroDao dao;

	@Override
	public void salvar(TipoFinanceiro tipoFinanceiro) {
		dao.save(tipoFinanceiro);
	}

	@Override
	public void editar(TipoFinanceiro tipoFinanceiro) {
		dao.update(tipoFinanceiro);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public TipoFinanceiro buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoFinanceiro> buscarTodos() {
		return dao.findAll();
	}
	
}
