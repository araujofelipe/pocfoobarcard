package br.com.moip.foobarcard.poc.controller.exceptions;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.DefaultResourceNotFoundHandler;
/**
 * 
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 12/10/2011
 */
@Component
@RequestScoped
public class Erro404 extends DefaultResourceNotFoundHandler {
	private final Result result;

	public Erro404(Result result) {
		this.result = result;
	}
	
	@Override
	public void couldntFind(RequestInfo arg0) {
		result.redirectTo("/pagenotfound");
	}
}
