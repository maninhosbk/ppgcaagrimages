package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.VooDAO;
import mvc_model.model.Voo;

public class VooRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Voo> dao = VooDAO.getInstancia();
	private static Logger log = Logger.getLogger(VooRN.class);

	public void salvar(Voo voo) {
		try {
			dao.salvar(voo);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Voo voo) {
		try {
			dao.excluir(voo);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
