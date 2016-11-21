package mvc_controller.rn;

import java.io.Serializable;

import mvc_model.model.AreaExperimental;

import org.apache.log4j.Logger;

import dao.AreaExperimentalDAO;
import dao.BaseDAOinterface;

public class AreaExperimentalRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<AreaExperimental> dao = AreaExperimentalDAO.getInstancia();
	private static Logger log = Logger.getLogger(AreaExperimentalRN.class);

	public void salvar(AreaExperimental areaExperimental) {
		try {
			dao.salvar(areaExperimental);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void excluir(AreaExperimental areaExperimental) {
		try {
			dao.excluir(areaExperimental);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
