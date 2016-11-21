package mvc_model.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Lob
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="operador")
	private Operador operador;
	
	@ManyToOne
	@JoinColumn(name="tipoExperimento")
	private TipoExperimento tipoExperimento;
	
	@ManyToOne
	@JoinColumn(name="rpa")
	private RPA rpa;
	
	@ManyToOne
	@JoinColumn(name="areaExperimental")
	private AreaExperimental areaExperimental;
	
	private Integer quantidadeImagens;
	private Double resolucaoEspacial;
	private Double altura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public TipoExperimento getTipoExperimento() {
		return tipoExperimento;
	}

	public void setTipoExperimento(TipoExperimento tipoExperimento) {
		this.tipoExperimento = tipoExperimento;
	}

	public RPA getRpa() {
		return rpa;
	}

	public void setRpa(RPA rpa) {
		this.rpa = rpa;
	}

	public AreaExperimental getAreaExperimental() {
		return areaExperimental;
	}

	public void setAreaExperimental(AreaExperimental areaExperimental) {
		this.areaExperimental = areaExperimental;
	}

	public Integer getQuantidadeImagens() {
		return quantidadeImagens;
	}

	public void setQuantidadeImagens(Integer quantidadeImagens) {
		this.quantidadeImagens = quantidadeImagens;
	}

	public Double getResolucaoEspacial() {
		return resolucaoEspacial;
	}

	public void setResolucaoEspacial(Double resolucaoEspacial) {
		this.resolucaoEspacial = resolucaoEspacial;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
