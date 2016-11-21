package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.FazendaDAO;
import mvc_model.model.Fazenda;

public class FazendaRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Fazenda> dao = FazendaDAO.getInstancia();
	private static Logger log = Logger.getLogger(FazendaRN.class);

	public void salvar(Fazenda fazenda) {
		try {
			dao.salvar(fazenda);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Fazenda fazenda) {
		try {
			dao.excluir(fazenda);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
