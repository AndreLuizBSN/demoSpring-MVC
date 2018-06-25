package com.mballem.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.mballem.curso.boot.domain.EntradaSaida;
import com.mballem.curso.boot.domain.Financeiro;

@Repository
public class FinanceiroDaoImpl extends AbstractDao<Financeiro, Long> implements FinanceiroDao {

	@Override
	public Object findAllByForma(String forma) {
		EntradaSaida es;
		if("entrada".equals(forma)) {
			es = EntradaSaida.ENTRADA;
		}else {
			es = EntradaSaida.SAIDA;
		}
		return createQuery("select f from Financeiro f where f.entradaSaida = ?1 ", es);
	}

}
