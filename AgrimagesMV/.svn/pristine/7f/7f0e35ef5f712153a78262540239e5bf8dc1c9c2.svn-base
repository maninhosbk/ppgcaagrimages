package mvc_model.estruturais.Adapter;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.imaging.tiff.TiffProcessingException;

public class ImageTIFF extends ImagemTarget{
	
	
	public ImageTIFF(File imagem) {
		super(imagem);
	}

	public void carregarImagemMetadada() {
		// TODO Auto-generated method stub
		try {
			this.metadata = TiffMetadataReader.readMetadata(this.imagem);
		} catch (TiffProcessingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
