package br.com.moip.foobarcard.poc.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * Simula uma factory para RequisicaoPagamento
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 12/10/2011
 */
public abstract class RequisicaoPagamentoFactory {
	
	
	/**
	 * Recebe um xml com a estrutura de um objeto <class>Requisicao</class> e devolve o objeto instanciado.
	 * @param xml
	 * @return
	 * @throws Exception 
	 */
	public static RequisicaoPagamento criaRequisicaoVia(String xml) throws Exception{
		try {
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("requisicao", RequisicaoPagamento.class);
			RequisicaoPagamento requisicao = (RequisicaoPagamento) xstream.fromXML(xml.trim());
			return requisicao;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
