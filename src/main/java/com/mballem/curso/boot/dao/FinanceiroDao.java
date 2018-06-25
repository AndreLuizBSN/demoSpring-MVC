package com.mballem.curso.boot.dao;

import java.util.List;

import com.mballem.curso.boot.domain.Financeiro;

public interface FinanceiroDao {

    void save(Financeiro financeiro);

    void update(Financeiro financeiro);

    void delete(Long id);

    Financeiro findById(Long id);

    List<Financeiro> findAll();

	Object findAllByForma(String forma);
}
