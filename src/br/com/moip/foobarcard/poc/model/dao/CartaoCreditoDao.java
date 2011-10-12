package br.com.moip.foobarcard.poc.model.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.moip.foobarcard.poc.model.entity.CartaoCredito;

/**
 * Simula DAO.
 * Para uma implementaçao real de acesso a banco de dados, deve-se configurar o acesso, podendo utilizar o controle transacional do VRaptor.
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 */

@ApplicationScoped
@Component
public class CartaoCreditoDao implements IDao<CartaoCredito> {
	
	private static Map<String,CartaoCredito> listaCartoesValidos;
	
	private static final String [] CREDIT_NUMBERS = {"1234567890987654","6549873216549874"};

	public CartaoCreditoDao() {
		listaCartoesValidos = gerarCartoes();
	}
	
	public boolean debitar(CartaoCredito cartao, double valorDebitado){
		
		CartaoCredito cartaoCredito = buscar(cartao.getNumeroCartao());
		
		boolean operacaoOk = cartaoCredito.debitar(valorDebitado);
		
		atualizar(cartaoCredito);
		
		return operacaoOk;
	}
	
	private static final Map<String, CartaoCredito> gerarCartoes(){
		Map<String, CartaoCredito> cartoes = new HashMap<String, CartaoCredito>();
		CartaoCredito cartao;
		
		for (String numero : CREDIT_NUMBERS) {			
			//Data de expiracao padrao 02/14 e limite padrao R$30.00
			cartao = new CartaoCredito(numero,"05/12", 30);
			cartoes.put(numero, cartao);
		}
		
		return cartoes;
	}

	public CartaoCredito buscar(String chave) {
		return listaCartoesValidos.get(chave);
	}

	public void atualizar(CartaoCredito t) {
		remover(t);
		listaCartoesValidos.put(t.getNumeroCartao(), t);
	}

	public void remover(CartaoCredito t) {
		listaCartoesValidos.remove(t.getNumeroCartao());
	}

	public boolean validar(CartaoCredito t) {
		if(t.getNumeroCartao() == null || t.getNumeroCartao().equals(""))
			return false;
		if(t.getDataExpiracao() == null || t.getDataExpiracao().equals(""))
			return false;
		if(!listaCartoesValidos.containsKey(t.getNumeroCartao()))
			return false;
		
		CartaoCredito card = listaCartoesValidos.get(t.getNumeroCartao());
		
		if(card.getDataExpiracao().equals(t.getDataExpiracao()))
			return true;
		
		return false;
	}
	
	
}
