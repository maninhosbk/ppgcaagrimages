package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mvc_model.model.Pessoa;

public class PessoaDAO extends BaseDAO<Pessoa> {

	private static final long serialVersionUID = 1L;
	private static PessoaDAO dao = null;

	public static PessoaDAO getInstancia() {
		if (dao == null)
			dao = new PessoaDAO();
		return dao;
	}

	private PessoaDAO() {
		super(Pessoa.class);
	}

	@SuppressWarnings("deprecation")
	public Pessoa getByCPF(String cpf) {
		Pessoa pessoa = null;
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(classe);
		Root<Pessoa> root = query.from(classe);
		query.where(builder.equal(root.get("cpf"), cpf));
		pessoa = getSession().createQuery(query).uniqueResult();
		return pessoa;
	}

}
