package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.FabricanteDAO;
import mvc_model.model.Fabricante;

public class FabricanteRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Fabricante> dao = FabricanteDAO.getInstancia();
	private static Logger log = Logger.getLogger(FabricanteRN.class);

	public void salvar(Fabricante fabricante) {
		try {
			dao.salvar(fabricante);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Fabricante fabricante) {
		try {
			dao.excluir(fabricante);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
