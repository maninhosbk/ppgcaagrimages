package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.RPADAO;
import mvc_model.model.RPA;

public class RPARN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<RPA> dao = RPADAO.getInstancia();
	private static Logger log = Logger.getLogger(RPARN.class);

	public void salvar(RPA rpa) {
		try {
			dao.salvar(rpa);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(RPA rpa) {
		try {
			dao.excluir(rpa);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
