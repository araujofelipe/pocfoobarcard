package br.com.moip.foobarcard.poc.controller;

import static br.com.caelum.vraptor.view.Results.xml;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.moip.foobarcard.poc.model.RequisicaoPagamento;
import br.com.moip.foobarcard.poc.model.RequisicaoPagamentoFactory;
import br.com.moip.foobarcard.poc.model.RespostaPagamento;
import br.com.moip.foobarcard.poc.model.dao.CartaoCreditoDao;
import br.com.moip.foobarcard.poc.model.entity.CartaoCredito;

/**
 * 
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 */
@Resource
public class PagamentoController {
	
	private final CartaoCreditoDao cartaoDao;
	private final Result result;
	
	public PagamentoController(Result result, CartaoCreditoDao cartaoDao, RequestInfo info) {
		this.result = result;
		this.cartaoDao = cartaoDao;
	}

	@Post @Path("pagamento/autorizacao")
	public void autorizacao(String xml){
		boolean statusRequisicao = false;
		RespostaPagamento resposta = new RespostaPagamento("Transacao Nao Aprovada", 1);
		try {
			
			RequisicaoPagamento requisicaoPagamento = RequisicaoPagamentoFactory.criaRequisicaoVia(xml);
			CartaoCredito cartao = new CartaoCredito(requisicaoPagamento.getNumeroCartao(), requisicaoPagamento.getDataExpiracao());
			
			//Validar dados Cartao.
			statusRequisicao = cartaoDao.validar(cartao);

			if(statusRequisicao){
				statusRequisicao = cartaoDao.debitar(cartao, requisicaoPagamento.getValor());
				if(statusRequisicao){//TUDO OK
					resposta.setCodigoRetorno(0);
					resposta.setMensagem("Transacao Aprovada");
				}
				result.use(xml()).from(resposta).serialize();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.use(xml()).from(resposta).serialize();
		}
	}


}
