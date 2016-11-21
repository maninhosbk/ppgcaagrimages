package dao;

import mvc_model.model.Operador;

public class OperadorDAO extends BaseDAO<Operador> {

	private static final long serialVersionUID = 1L;
	private static OperadorDAO dao = null;

	public static OperadorDAO getInstancia() {
		if (dao == null)
			dao = new OperadorDAO();
		return dao;
	}

	private OperadorDAO() {
		super(Operador.class);
	}

}
