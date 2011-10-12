package br.com.moip.foobarcard.poc.model.entity;


/**
 * POJO que representa um Cartao de Credito.
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 */

public class CartaoCredito {
	private String numeroCartao;
	private String dataExpiracao;
	private double limite;
	private double saldoDisponivel;
	
	
	public CartaoCredito() {
		
	}
	
	public CartaoCredito(String numeroCartao, String dataExpiracao){
		this.numeroCartao = numeroCartao;
		this.dataExpiracao = dataExpiracao;
	}
	
	public CartaoCredito(String numeroCartao, String dataExpiracao, double limite){
		this.numeroCartao = numeroCartao;
		this.dataExpiracao = dataExpiracao;
		this.limite = limite;
		this.saldoDisponivel = limite;
	}
	
	public boolean debitar(double valor){
		if(valor > this.limite)
			return false;
		
		if(valor > this.saldoDisponivel)
			return false;
		
		if(saldoDisponivel <= 0)
			return false;
		
		this.saldoDisponivel -= valor;
		
		return true;		
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setSaldoDisponivel(double saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}
	
	
	
}	
