package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.TipoExperimentoDAO;
import mvc_model.model.TipoExperimento;

public class TipoExperimentoRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<TipoExperimento> dao = TipoExperimentoDAO
			.getInstancia();
	private static Logger log = Logger.getLogger(TipoExperimentoRN.class);

	public void salvar(TipoExperimento tipoExperimento) {
		try {
			dao.salvar(tipoExperimento);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(TipoExperimento tipoExperimento) {
		try {
			dao.excluir(tipoExperimento);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
