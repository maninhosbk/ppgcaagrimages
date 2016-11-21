package dao;

import mvc_model.model.Fazenda;

public class FazendaDAO extends BaseDAO<Fazenda> {

	private static final long serialVersionUID = 1L;
	private static FazendaDAO dao = null;

	public static FazendaDAO getInstancia() {
		if (dao == null)
			dao = new FazendaDAO();
		return dao;
	}

	private FazendaDAO() {
		super(Fazenda.class);
	}
}
