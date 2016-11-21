package dao;

import mvc_model.model.TipoExperimento;

public class TipoExperimentoDAO extends BaseDAO<TipoExperimento> {

	private static final long serialVersionUID = 1L;
	private static TipoExperimentoDAO dao = null;

	public static TipoExperimentoDAO getInstancia() {
		if (dao == null)
			dao = new TipoExperimentoDAO();
		return dao;
	}

	private TipoExperimentoDAO() {
		super(TipoExperimento.class);
	}

}
