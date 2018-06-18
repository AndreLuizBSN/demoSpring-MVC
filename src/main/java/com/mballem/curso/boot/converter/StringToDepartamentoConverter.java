package com.mballem.curso.boot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mballem.curso.boot.domain.Departamento;
import com.mballem.curso.boot.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String text) {
		// TODO Auto-generated method stub]
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
	
}
