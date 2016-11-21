package mvc_model.estruturais.Adapter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.IptcReader;

public class ImagemJPEG{
	
	public Metadata carregarMetadataJPEG(File imagem) {
		Iterable<JpegSegmentMetadataReader> readers = Arrays.asList(new ExifReader(), new IptcReader());
        try {
			return JpegMetadataReader.readMetadata(imagem, readers);
		} catch (JpegProcessingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
