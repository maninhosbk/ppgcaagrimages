package dao;

import mvc_model.model.RPA;

public class RPADAO extends BaseDAO<RPA> {

	private static final long serialVersionUID = 1L;
	private static RPADAO dao = null;

	public static RPADAO getInstancia() {
		if (dao == null)
			dao = new RPADAO();
		return dao;
	}

	private RPADAO() {
		super(RPA.class);
	}

}
