package mvc_model.estruturais.Facade;

import weka.classifiers.Classifier;
import weka.core.Instances;

public class MiningAlgorithm {
	Classifier classificador;
	
	public void configuraClassificador(Classifier classificador){
		this.classificador = classificador;
	}
	
	public Classifier getClassificador() {
		return this.classificador;
	}
	
	public String executaAlgoritmo(Instances data){
		String output = "";
		try {
			
			long inicio = System.currentTimeMillis();
			classificador.buildClassifier(data);
			long fim  = System.currentTimeMillis();
	        output = classificador.toString();
	        output += "\nTime taken to build model: "+ ((fim - inicio)/1000) + " seconds";
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = "ERRO NA EXECUÇÃO";
		}
		return output;
	}
}
