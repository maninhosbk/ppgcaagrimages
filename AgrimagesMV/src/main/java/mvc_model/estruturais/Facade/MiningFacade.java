package mvc_model.estruturais.Facade;

import javax.swing.JTextArea;

import weka.classifiers.Classifier;
import weka.core.Instances;

public class MiningFacade {
	MiningInput input;
	MiningValidation validation;
	MiningAlgorithm algorithm;
	
	
	
	public void MiningOptions(Instances instances, int classe, int validacao, Classifier classificador){ 
		input = new MiningInput();
		input.setInstances(instances);
		input.setClasse(classe);
		
		validation = new MiningValidation();
		validation.configuraTipoValidacao(validacao);
		
		algorithm = new MiningAlgorithm();
		algorithm.configuraClassificador(classificador);
	}
	
	public void runDataMining(JTextArea saida){
		input.configInstances();
		
		String output = algorithm.executaAlgoritmo(input.getDados());
		saida.setText(output);
        
		try {
			output += validation.executaValidacao(algorithm.getClassificador(), input.getDados());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output += "\n\nERRO NA VALIDAÇÃO";  
		}
		saida.setText(output);
		//return output;
	}
}
