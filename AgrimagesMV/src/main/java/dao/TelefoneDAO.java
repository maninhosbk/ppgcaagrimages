package dao;

import mvc_model.model.Telefone;

public class TelefoneDAO extends BaseDAO<Telefone> {

	private static final long serialVersionUID = 1L;
	private static TelefoneDAO dao = null;

	public static TelefoneDAO getInstancia() {
		if (dao == null)
			dao = new TelefoneDAO();
		return dao;
	}

	private TelefoneDAO() {
		super(Telefone.class);
	}

}
