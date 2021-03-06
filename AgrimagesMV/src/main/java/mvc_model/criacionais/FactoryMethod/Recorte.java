package mvc_model.criacionais.FactoryMethod;

import java.io.FileWriter;
import java.io.IOException;

import org.opencv.core.Mat;

public abstract class Recorte {
	public Mat src;
	public Mat dst;
	public RecorteDadosImagem dados;
	
	public abstract void recortar();
	
	public abstract void salvarDadosRecorte(String classe);
	
	public abstract void salvarImagem(String caminho);
	
	public void salvarDados(FileWriter outFile){
		// TODO Auto-generated method stub
				String classes = "";
		        for(String dado : dados.getClasses()){
		            if("".equals(classes)){
		                classes = classes + dado;
		            }else{
		                classes = classes + ","+dado;
		            }
		        }
		        try {
		        	outFile.write("@relation RGB\n"
					                + "\n"
					                + "@attribute R numeric\n"
					                + "@attribute G numeric\n"
					                + "@attribute B numeric\n"
					                + "@attribute H numeric\n"
					                + "@attribute S numeric\n"
					                + "@attribute I numeric\n"
					                + "@attribute classe {"+classes+"}\n"
					                + "\n"
					                + "@data\n");
					for (int i = 0; i < dados.getSize(); i++) {
						outFile.write(dados.getR().get(i) + ","
		                        + dados.getG().get(i) + ","
		                        + dados.getB().get(i) + ","
		                        + dados.getH().get(i) + ","
		                        + dados.getS().get(i) + ","
		                        + dados.getI().get(i) + ","
		                        + dados.getClasse().get(i) + "\n");

		            }
					outFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        dados.removeAllLists();
	}
	public  Mat getResult(){
		return dst;
	}

}
