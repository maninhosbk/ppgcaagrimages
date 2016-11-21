package mvc_model.estruturais.Adapter;

import java.io.File;

public class ReadMetadata {
	private String EXIFF = "";
	
	public ReadMetadata(File arq){
		String formato[] = arq.getName().split("\\.");
        String extensao = formato[1];
        ImagemTarget imagem;
        switch (extensao) {

			case "jpg":
			case "jpeg":
				 imagem = new ImageAdapterJPEG(arq); 
				imagem.carregarImagemMetadada();
				EXIFF = imagem.getMetadata();
				break;
			case "tiff":
				imagem = new ImageTIFF(arq); 
				imagem.carregarImagemMetadada();
				EXIFF = imagem.getMetadata();
				break;
			case "bmp":
				imagem = new ImageBMP(arq); 
				imagem.carregarImagemMetadada();
				EXIFF = imagem.getMetadata();
				break;
			default:
				imagem = new ImagemOutros(arq); 
				imagem.carregarImagemMetadada();
				EXIFF = imagem.getMetadata();
				break;
		}
	}
	
	
	public String getEXIFF(){
		return this.EXIFF;
	}
}
