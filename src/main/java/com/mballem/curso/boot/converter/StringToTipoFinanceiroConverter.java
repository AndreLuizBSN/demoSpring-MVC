package com.mballem.curso.boot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mballem.curso.boot.domain.TipoFinanceiro;
import com.mballem.curso.boot.service.TipoFinanceiroService;

@Component
public class StringToTipoFinanceiroConverter implements Converter<String, TipoFinanceiro> {

	@Autowired
	private TipoFinanceiroService service;
	
	@Override
	public TipoFinanceiro convert(String text) {
		// TODO Auto-generated method stub]
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
	
}
