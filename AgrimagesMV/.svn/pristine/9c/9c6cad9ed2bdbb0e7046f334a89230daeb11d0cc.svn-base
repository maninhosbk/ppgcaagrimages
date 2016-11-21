package mvc_model.estruturais.Adapter;

import java.io.File;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public abstract class ImagemTarget {
	Metadata metadata;
	File imagem;
	
	public  ImagemTarget(File imagem){
		this.imagem = imagem;
	}
	public abstract void carregarImagemMetadada();
	
	public String getMetadata(){
		String EXIF = null;
		for (Directory directory : metadata.getDirectories()) {
            EXIF = EXIF + directory.getName() + "\n";

            for (Tag tag : directory.getTags()) {
                EXIF = EXIF + "      " + tag.getTagName() + " -- " + tag.getDescription() + "\n";
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }
		return EXIF;
	}
}
