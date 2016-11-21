package mvc_model.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Camera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String modelo;
	private Integer resolucaoH;
	private Integer resolucaoV;
	private String sensor;
	private Double distanciaFocal;

	@ManyToOne
	@JoinColumn(name = "fabricante")
	private Fabricante fabricante;

	@ManyToOne
	@JoinColumn(name = "canalCor")
	private CanalCor canalCor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getResolucaoH() {
		return resolucaoH;
	}

	public void setResolucaoH(Integer resolucaoH) {
		this.resolucaoH = resolucaoH;
	}

	public Integer getResolucaoV() {
		return resolucaoV;
	}

	public void setResolucaoV(Integer resolucaoV) {
		this.resolucaoV = resolucaoV;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public Double getDistanciaFocal() {
		return distanciaFocal;
	}

	public void setDistanciaFocal(Double distanciaFocal) {
		this.distanciaFocal = distanciaFocal;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public CanalCor getCanalCor() {
		return canalCor;
	}

	public void setCanalCor(CanalCor canalCor) {
		this.canalCor = canalCor;
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
		Camera other = (Camera) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
