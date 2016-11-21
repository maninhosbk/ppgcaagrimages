package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.CanalCorDAO;
import mvc_model.model.CanalCor;

public class CanalCorRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<CanalCor> dao = CanalCorDAO.getInstancia();
	private static Logger log = Logger.getLogger(CanalCorRN.class);

	public void salvar(CanalCor canalCor) {
		try {
			dao.salvar(canalCor);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(CanalCor canalCor) {
		try {
			dao.excluir(canalCor);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
