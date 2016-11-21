package mvc_model.criacionais.FactoryMethod;

import org.opencv.core.Mat;

public interface CreatorRecorte {
	public Recorte getRecorte(Mat src, Object pontos);
}
