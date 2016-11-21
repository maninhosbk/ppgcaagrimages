package mvc_model.criacionais.AbstractFactory;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ProductCor1Canal implements AbstractProductCor{
	private Mat src;
	private Mat dst;
	@Override
	
	public void filtrarCor(Mat imagem, int filtro, int option) {
		// TODO Auto-generated method stub
		this.src = imagem;
        this.dst = new Mat();
        switch (filtro) {
	        case 1:{
	    		Imgproc.cvtColor(this.src, this.dst , Imgproc.COLOR_BGR2GRAY);
	    	}break;
	    	
	    	case 2:{
	    		Imgproc.cvtColor(this.src, this.dst , Imgproc.COLOR_RGB2GRAY);
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
