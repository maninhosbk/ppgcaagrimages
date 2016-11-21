package dao;

import mvc_model.model.Cultivo;

public class CultivoDAO extends BaseDAO<Cultivo>{
	
	private static final long serialVersionUID = 1L;
	private static CultivoDAO dao = null;

	public static CultivoDAO getInstancia() {
		if (dao == null)
			dao = new CultivoDAO();
		return dao;
	}

	private CultivoDAO() {
		super(Cultivo.class);
	}

}
