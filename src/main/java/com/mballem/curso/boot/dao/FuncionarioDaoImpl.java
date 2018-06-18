package com.mballem.curso.boot.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mballem.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.cargo.id = ?1 ", id);
	}

	@Override
	public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 and f.dataSaida <= ?2 order by dataEntrada asc ", entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.dataEntrada = ?1 order by dataEntrada asc ", entrada);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.dataSaida = ?1 order by dataEntrada asc ", saida);
	}
	
}
