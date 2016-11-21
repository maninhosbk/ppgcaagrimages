package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ProductRuido1Canal implements AbstractProductRuido{
	public Mat src;
	public Mat dst;
	@Override
	public void corrigirRuido(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		src = imagem;
		dst = new Mat(src.height(),src.width(),CvType.CV_8UC1);
		
		switch(filtro){
			//threshold OTSU
			case 1:{
				Imgproc.threshold(src, dst, option, 255, Imgproc.THRESH_OTSU);
			}break;
			
			//Threshold Binario
			case 2:{
				Imgproc.threshold(src, dst, option, 255, Imgproc.THRESH_BINARY);
			}break;
			
			//Gaussiano
			case 3:{
				Imgproc.GaussianBlur(src, dst, new Size(option,option), 0.0);
			}break;
			
			//MedianBlur
			case 4:{
				Imgproc.medianBlur(src, dst, option);
			}break;
			
			//filtro Sobel
			case 5:{
				Imgproc.Sobel(src, dst,CvType.CV_16S, 1, 0, 3, 1, 0);
			}break;
			
			case 6:{
				Imgproc.Sobel(src, dst,CvType.CV_16S, 0, 1, 3, 1, 0);
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
