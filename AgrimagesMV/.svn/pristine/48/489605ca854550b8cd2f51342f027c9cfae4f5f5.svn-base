package mvc_model.comportamentais.Command;

import java.io.File;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Imagem img = new Imagem(new File("teste.jpeg"), "teste parametros");
		
		CorrecaoRadiometrica radio = new CorrecaoRadiometrica(img);
		
		CorrecaoGeometrica geo = new CorrecaoGeometrica(img);
		
		CorrecaoAtmosferica atmos = new CorrecaoAtmosferica(img);
		
		
		InvokerCorrecao invoker = new InvokerCorrecao();
		
		invoker.correcao(geo);
		invoker.correcao(radio);
		invoker.correcao(atmos);
	}

}
