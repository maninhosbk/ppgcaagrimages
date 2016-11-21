package mvc_model.estruturais.Facade;

import weka.core.Attribute;
import weka.core.Instances;

public class MiningInput {
	
	private Instances dados;
	private int classInd;
	private Attribute classe;
	
	public void setInstances(Instances instances){
		this.dados = instances;
	}
	
	public void setClasse(int atr){
		this.classInd = atr;
	}
	
	public Instances getDados(){
		return dados;
	}
	
	public void configInstances(){
		this.classe = dados.attribute(classInd);
		dados.setClass(classe);
	}
}
