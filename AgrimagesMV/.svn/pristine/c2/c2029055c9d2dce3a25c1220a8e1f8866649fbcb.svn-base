package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ProductRuido3Canais implements AbstractProductRuido{
	private Mat src;
	private Mat dst;
	
	@Override
	public void corrigirRuido(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		src = imagem;
		dst = new Mat(src.height(),src.width(),src.type());
		switch(filtro){
			case 1:{
				Imgproc.blur(src, dst, new Size(option,option));
			}break;
			
			//Median Blur
			case 2:{
				Imgproc.medianBlur(src, dst, option);
			}break;
			
			//Gaussiano
			case 3:{
				Imgproc.GaussianBlur(src, dst, new Size(option,option), 0.0);
			}break;
			
			default:
				break;
			
		}
		
	}
	@Override
	public Mat getResult() {
		// TODO Auto-generated method stub
		return dst;
	}
}
