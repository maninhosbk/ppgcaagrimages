package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.CameraDAO;
import mvc_model.model.Camera;

public class CameraRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Camera> dao = CameraDAO.getInstancia();
	private static Logger log = Logger.getLogger(CameraRN.class);

	public void salvar(Camera camera) {
		try {
			dao.salvar(camera);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Camera camera) {
		try {
			dao.excluir(camera);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
