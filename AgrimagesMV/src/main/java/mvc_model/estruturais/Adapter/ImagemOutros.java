package mvc_model.estruturais.Adapter;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;

public class ImagemOutros extends ImagemTarget{

	
	
	public ImagemOutros(File imagem) {
		super(imagem);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void carregarImagemMetadada() {
		// TODO Auto-generated method stub
		try {
			metadata = ImageMetadataReader.readMetadata(this.imagem);
		} catch (ImageProcessingException|IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
