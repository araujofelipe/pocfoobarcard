package br.com.moip.foobarcard.poc.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
/**
 * 
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 12/10/2011
 */
@Resource
public class IndexController {
	
	@Path("/")
	public void index(){}
	
	@Path("/pagenotfound")
	public void pagenotfound(){}
}
