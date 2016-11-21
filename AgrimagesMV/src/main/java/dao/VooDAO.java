package dao;

import mvc_model.model.Voo;

public class VooDAO extends BaseDAO<Voo> {

	private static final long serialVersionUID = 1L;
	private static VooDAO dao = null;

	public static VooDAO getInstancia() {
		if (dao == null)
			dao = new VooDAO();
		return dao;
	}

	private VooDAO() {
		super(Voo.class);
	}

}
