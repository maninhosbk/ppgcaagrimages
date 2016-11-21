package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAOinterface<T> {

	public T salvar(T entidade) throws Exception;
	
	public T salvar(T entidade, Serializable codigo) throws Exception;

	public T atualizar(T entidade) throws Exception;
	
	public T atualizar(T entidade, Integer codigo) throws Exception;

	public void excluir(T entidade) throws Exception;

	public T salvarAtualizar(T entidade) throws Exception;

	public T mesclar(T entidade, Serializable codigo) throws Exception;

	public void mesclar(T entidade) throws Exception;

	public List<T> listaTodos();

	public List<T> listaTodos(String order);

	public List<T> listaTodos(String[] order);

	public T carregar(Serializable codigo);
}
