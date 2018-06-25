package com.mballem.curso.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;


@SuppressWarnings("serial")
@Entity
@Table(name="FINANCEIRO")
public class Financeiro extends AbstractEntity<Long> {

	@NotBlank(message = "Informe uma descrição resumida!")
	@Size(min= 3, max=60, message= "A descrição resumida deve ter entre {min} e {max} caracteres!")
	@Column(name="NOME", nullable=false, unique=true, length=60)
	private String nome;
	
	@NotNull(message = "Informe se é entrada ou saída")
	@Column(name="ENTRADA_SAIDA", nullable=false)
	@Enumerated(EnumType.STRING)
	private EntradaSaida entradaSaida;
		
	@NotNull
	@NumberFormat(style=Style.CURRENCY, pattern="#,##0.00")
	@Column(name="VALOR", nullable=false, columnDefinition="DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valor;
	
	@NotNull
	@PastOrPresent(message = "A data de lançamento deve ser preenchida")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DATA", nullable=false, columnDefinition="DATE")
	private LocalDate data;
	
	@NotNull
	@PastOrPresent(message = "A data de cadastro nao foi preenchida")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DATA_CADASTRO", nullable=false, columnDefinition="DATE")
	private LocalDate dataCadastro;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@NotNull(message="Selecione um tipo de financeiro!")
	@ManyToOne
	@JoinColumn(name = "TIPO_FINANCEIRO_ID")
	private TipoFinanceiro tipoFinanceiro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EntradaSaida getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(EntradaSaida entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFinanceiro getTipoFinanceiro() {
		return tipoFinanceiro;
	}

	public void setTipoFinanceiro(TipoFinanceiro tipoFinanceiro) {
		this.tipoFinanceiro = tipoFinanceiro;
	}
	
}
