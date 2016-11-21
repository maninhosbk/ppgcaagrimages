package dao;

import mvc_model.model.Fabricante;

public class FabricanteDAO extends BaseDAO<Fabricante>{
	
	private static final long serialVersionUID = 1L;
	private static FabricanteDAO dao = null;

	public static FabricanteDAO getInstancia() {
		if (dao == null)
			dao = new FabricanteDAO();
		return dao;
	}

	private FabricanteDAO() {
		super(Fabricante.class);
	}

}
