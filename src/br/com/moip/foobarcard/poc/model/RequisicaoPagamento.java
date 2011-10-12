package br.com.moip.foobarcard.poc.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * POJO que define uma Requisicao de Pagamento.
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 */
@XStreamAlias("requisicao")
public class RequisicaoPagamento {
	private String numeroCartao;
	private String dataExpiracao;
	private double valor;
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numCartao) {
		this.numeroCartao = numCartao;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}	
	
}
