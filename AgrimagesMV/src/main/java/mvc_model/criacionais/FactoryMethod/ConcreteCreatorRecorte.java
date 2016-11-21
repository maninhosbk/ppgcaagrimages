package mvc_model.criacionais.FactoryMethod;

import java.util.ArrayList;

import org.opencv.core.Point;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

public class ConcreteCreatorRecorte implements CreatorRecorte{
	@SuppressWarnings("unchecked")
	public Recorte getRecorte(Mat src, Object pontos){
		if(pontos instanceof Rect){
			return new RecorteRegular(src, (Rect) pontos);
		}else if(pontos instanceof ArrayList){
			return new RecorteIrregular(src,(ArrayList<Point>) pontos);
		}
		return null;
	}
}
