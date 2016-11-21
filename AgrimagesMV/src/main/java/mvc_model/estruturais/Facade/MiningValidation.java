package mvc_model.estruturais.Facade;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Debug;
import weka.core.Instances;

public class MiningValidation {
	private int validacao;
	Evaluation eval;
	
	public void configuraTipoValidacao(int validacao){
		this.validacao = validacao;
		
	}

	public String executaValidacao(Classifier classifier, Instances data) throws Exception{
		eval = new Evaluation(data);
		if(validacao > 0){
			eval.crossValidateModel(classifier, data, 10, new Debug.Random(1));
	        eval.evaluateModel(classifier, data);
        }else{
        	eval.evaluateModel(classifier, data);
        }
		
		return "\n\n" +eval.toSummaryString();
	}
	
}
