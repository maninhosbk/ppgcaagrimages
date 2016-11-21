package dao;

import mvc_model.model.Camera;

public class CameraDAO extends BaseDAO<Camera>{
	
	private static final long serialVersionUID = 1L;
	private static CameraDAO dao = null;

	public static CameraDAO getInstancia() {
		if (dao == null)
			dao = new CameraDAO();
		return dao;
	}

	private CameraDAO() {
		super(Camera.class);
	}

}
