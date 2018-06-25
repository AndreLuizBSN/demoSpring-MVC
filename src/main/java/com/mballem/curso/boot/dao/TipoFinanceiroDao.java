package com.mballem.curso.boot.dao;

import java.util.List;

import com.mballem.curso.boot.domain.TipoFinanceiro;

public interface TipoFinanceiroDao {

    void save(TipoFinanceiro tipoFinanceiro);

    void update(TipoFinanceiro tipoFinanceiro);

    void delete(Long id);

    TipoFinanceiro findById(Long id);

    List<TipoFinanceiro> findAll();
}
