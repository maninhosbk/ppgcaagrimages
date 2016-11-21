package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.Mat;

public class FactoryMaker {
	private AbstractFactoryFiltro filtro = null;
	
	public Mat getFactory(String produto, int option, Mat imagem, int tipo, int depend){
		
		if(option == 1){
			filtro = new ConcreteFactory1Canal();
			
		}else if(option == 3){
			filtro = new ConcreteFactory3Canais();
			
		}
		
		if(produto.equals("cor")){
			return filtro.AplicarFiltroCor(imagem, tipo, depend).getResult();
			
		}else if(produto.equals("ruido")){
			return filtro.AplicarFiltroRuido(imagem, tipo, depend).getResult();
			
		}
		
		return null;
	}
}
