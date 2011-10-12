package br.com.moip.foobarcard.poc.controller.exceptions;

import java.util.Set;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.HttpMethod;
import br.com.caelum.vraptor.resource.MethodNotAllowedHandler;

/**
 * 
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 12/10/2011
 */

@Component
@RequestScoped
public class Erro405 implements MethodNotAllowedHandler {

	private final Result result;

	public Erro405(Result result) {
		this.result = result;
	}
	
	public void deny(RequestInfo arg0, Set<HttpMethod> arg1) {
		result.redirectTo("/");
	}

	

}
