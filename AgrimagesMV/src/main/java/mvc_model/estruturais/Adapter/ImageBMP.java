package mvc_model.estruturais.Adapter;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.bmp.BmpMetadataReader;

public class ImageBMP extends ImagemTarget {
    
	public ImageBMP(File imagem) {
		super(imagem);
	}

	@Override
	public void carregarImagemMetadada() {
		// TODO Auto-generated method stub
		try {
			this.metadata = BmpMetadataReader.readMetadata(this.imagem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
