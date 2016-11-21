package dao;

import mvc_model.model.CanalCor;

public class CanalCorDAO extends BaseDAO<CanalCor>{
	
	private static final long serialVersionUID = 1L;
	private static CanalCorDAO dao = null;

	public static CanalCorDAO getInstancia() {
		if (dao == null)
			dao = new CanalCorDAO();
		return dao;
	}

	private CanalCorDAO() {
		super(CanalCor.class);
	}

}
