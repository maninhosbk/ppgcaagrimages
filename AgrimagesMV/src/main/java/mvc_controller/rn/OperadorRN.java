package mvc_controller.rn;

import java.io.Serializable;
import java.util.List;

import mvc_model.model.Operador;
import mvc_model.model.Telefone;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.OperadorDAO;
import dao.TelefoneDAO;

public class OperadorRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Operador> dao = OperadorDAO.getInstancia();
	private BaseDAOinterface<Telefone> daoTelefone = TelefoneDAO.getInstancia();
	private static Logger log = Logger.getLogger(OperadorRN.class);

	public void salvar(Operador operador, List<Telefone> telefones) {
		try {
			operador = dao.salvar(operador);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Operador operador) {
		try {
			dao.excluir(operador);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
