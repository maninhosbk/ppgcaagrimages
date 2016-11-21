package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.CultivoDAO;
import mvc_model.model.Cultivo;

public class CultivoRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Cultivo> dao = CultivoDAO.getInstancia();
	private static Logger log = Logger.getLogger(CultivoRN.class);

	public void salvar(Cultivo cultivo) {
		try {
			dao.salvar(cultivo);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Cultivo cultivo) {
		try {
			dao.excluir(cultivo);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
