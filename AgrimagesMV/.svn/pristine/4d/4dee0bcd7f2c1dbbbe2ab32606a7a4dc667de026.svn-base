package dao;

import mvc_model.model.AreaExperimental;

public class AreaExperimentalDAO extends BaseDAO<AreaExperimental> {

	private static final long serialVersionUID = 1L;
	private static AreaExperimentalDAO dao = null;

	public static AreaExperimentalDAO getInstancia() {
		if (dao == null)
			dao = new AreaExperimentalDAO();
		return dao;
	}

	private AreaExperimentalDAO() {
		super(AreaExperimental.class);
	}

}
