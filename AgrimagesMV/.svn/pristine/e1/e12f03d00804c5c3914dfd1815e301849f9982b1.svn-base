package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.Mat;

public class ConcreteFactory1Canal implements AbstractFactoryFiltro{
	

	@Override
	public AbstractProductRuido AplicarFiltroRuido(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		ProductRuido1Canal fr = new ProductRuido1Canal();
		fr.corrigirRuido(imagem, filtro,option);
		return fr;
	}

	@Override
	public AbstractProductCor AplicarFiltroCor(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		ProductCor1Canal g = new ProductCor1Canal();
		g.filtrarCor(imagem,filtro, option);
		return g;
	}
}
