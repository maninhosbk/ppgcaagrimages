package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import mvc_util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class BaseDAO<T> implements BaseDAOinterface<T>, Serializable {

	private static final long serialVersionUID = 1L;
	protected Session sessao;
	protected Class<T> classe;
	protected Logger log = Logger.getLogger(getClass());

	public BaseDAO(Class<T> classe) {
		this.classe = classe;
		this.sessao = HibernateUtil.getSession();
	}

	@Override
	public T salvar(T entidade) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.save(entidade);
			getSession().getTransaction().commit();
			return entidade;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public T salvar(T entidade, Serializable codigo) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.save(entidade);
			flushSession();
			getSession().getTransaction().commit();
			return carregar(codigo);
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public T atualizar(T entidade) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.update(entidade);
			getSession().getTransaction().commit();
			return entidade;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public T atualizar(T entidade, Integer codigo) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.update(entidade);
			// flushSession();
			getSession().getTransaction().commit();
			return carregar(codigo);
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public void excluir(T entidade) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.delete(entidade);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error("Falha excluir " + e.getMessage());
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public T salvarAtualizar(T entidade) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.saveOrUpdate(entidade);
			getSession().getTransaction().commit();
			return entidade;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error("Falha ao salvar/atualizar " + e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public void mesclar(T entidade) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.merge(entidade);
			// this.sessao.flush();
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error("Falha ao mesclar " + e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public T mesclar(T entidade, Serializable codigo) throws Exception {
		try {
			getSession().getTransaction().begin();
			this.sessao.merge(entidade);
			this.sessao.flush();
			this.sessao.clear();
			getSession().getTransaction().commit();
			return carregar(codigo);
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			log.error("Falha ao mesclar " + e.getMessage());
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public List<T> listaTodos() {
		getSession().getTransaction().begin();
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(classe);
		criteria.from(classe);
		List<T> all = getSession().createQuery(criteria).getResultList();
		getSession().getTransaction().commit();
		return all;
	}

	@Override
	public List<T> listaTodos(String order) {
		getSession().getTransaction().begin();
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(classe);
		Root<T> root = criteria.from(classe);
		criteria.orderBy(builder.asc(root.get(order)));
		List<T> all = getSession().createQuery(criteria).getResultList();
		getSession().getTransaction().commit();
		return all;
	}

	@Override
	public List<T> listaTodos(String[] order) {
		getSession().getTransaction().begin();
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(classe);
		Root<T> root = criteria.from(classe);
		List<Order> orderns = new ArrayList<Order>();
		for (int i = 0; i < order.length; i++) {
			orderns.add(builder.asc(root.get(order[i])));
		}
		criteria.orderBy(orderns);
		List<T> all = getSession().createQuery(criteria).getResultList();
		getSession().getTransaction().commit();
		return all;
	}

	@Override
	public T carregar(Serializable codigo) {
		getSession().getTransaction().begin();
		T entidade = (T) this.sessao.get(classe, codigo);
		getSession().getTransaction().commit();
		return entidade;
	}

	protected Session getSession() {
		return sessao;
	}

	public void flushSession() {
		this.sessao.flush();
		this.sessao.clear();
	}

	private void close() {
		if (getSession() != null && getSession().isOpen()) {
			getSession().close();
		}
	}
}