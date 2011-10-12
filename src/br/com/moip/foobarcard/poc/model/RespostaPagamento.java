package br.com.moip.foobarcard.poc.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * POJO que define uma Resposta de Pagamento
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 */
@XStreamAlias("resposta")
public class RespostaPagamento {
	String mensagem;
	int codigoRetorno;
	
	public RespostaPagamento() {
	}
	
	public RespostaPagamento(String mensagem, int codigoRetorno){
		this.mensagem = mensagem;
		this.codigoRetorno = codigoRetorno;
		
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getCodigoRetorno() {
		return codigoRetorno;
	}
	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	
	
	
}
