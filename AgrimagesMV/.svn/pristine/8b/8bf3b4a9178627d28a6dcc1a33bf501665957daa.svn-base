package mvc_model.criacionais.FactoryMethod;

import mvc_model.criacionais.AbstractFactory.FactoryMaker;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;


public class RecorteRegular extends Recorte{

	Rect roi;
	public RecorteRegular(Mat src, Rect roi) {
		// TODO Auto-generated constructor stub
		this.src = src;
		this. roi = roi;
		this.dados = new RecorteDadosImagem();
	}
	@Override
	public void recortar() {
		// TODO Auto-generated method stub
		dst = src.submat(roi);
	}
	@Override
	public void salvarDadosRecorte(String classe){
		// TODO Auto-generated method stub
		
		Size sizeA = dst.size();
		
		FactoryMaker fabrica = new FactoryMaker();
		
		Mat RGB = fabrica.getFactory("cor", 2, dst, 0, 0);
        Mat HSV = fabrica.getFactory("cor", 1, dst, 0, 0);;
		
        for (int i = 0; i < sizeA.height; i++) {
            for (int j = 0; j < sizeA.width; j++) {
	        	double[] dataRGB = RGB.get(i, j);
	            double[] dataHSV = HSV.get(i, j);
	            dados.getR().add(dataRGB[0]);
	            dados.getG().add(dataRGB[1]);
	            dados.getB().add(dataRGB[2]);
	            dados.getH().add(dataHSV[0]);
	            dados.getS().add(dataHSV[1]);
	            dados.getI().add(dataHSV[2]);
	            dados.getClasse().add(classe);
	            dados.setSize(dados.getSize() + 1);
            }
        }
	}
	public void salvarImagem(String caminho){
		// TODO Auto-generated method stub
		Highgui.imwrite(caminho, dst);
	}
}
