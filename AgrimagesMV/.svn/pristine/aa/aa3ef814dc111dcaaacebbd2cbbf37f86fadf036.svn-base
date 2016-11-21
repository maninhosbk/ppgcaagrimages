package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.Mat;

public class ConcreteFactory3Canais implements AbstractFactoryFiltro{

	@Override
	public AbstractProductRuido AplicarFiltroRuido(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		ProductRuido3Canais b = new ProductRuido3Canais();
		b.corrigirRuido(imagem,filtro, option);
		return b;
	}

	@Override
	public AbstractProductCor AplicarFiltroCor(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		ProductCor3Canais fc = new ProductCor3Canais();
		fc.filtrarCor(imagem, filtro, option);
		return fc;
	}
}
