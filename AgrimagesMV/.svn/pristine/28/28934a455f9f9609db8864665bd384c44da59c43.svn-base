package mvc_controller.rn;

import java.io.Serializable;

import org.apache.log4j.Logger;

import dao.BaseDAOinterface;
import dao.PessoaDAO;
import mvc_model.model.Pessoa;

public class PessoaRN implements Serializable {

	private static final long serialVersionUID = 1L;
	private BaseDAOinterface<Pessoa> dao = PessoaDAO.getInstancia();
	private static Logger log = Logger.getLogger(PessoaRN.class);

	public void salvar(Pessoa pessoa) {
		try {
			dao.salvar(pessoa);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void excluir(Pessoa pessoa) {
		try {
			dao.excluir(pessoa);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
