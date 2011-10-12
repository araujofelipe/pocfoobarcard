package br.com.moip.foobarcard.poc.model.dao;
/**
 * Interface de DAO
 * @author Felipe S. Araujo  jfelipe.dev@gmail.com @feli_pao
 * http://github.com/araujofelipe
 * 08/10/2011
 * @param <T>
 */
public interface IDao<T> {
	
	public T buscar(String chave);
	public void atualizar(T t);
	public void remover(T t);
	public boolean validar(T t);
}
