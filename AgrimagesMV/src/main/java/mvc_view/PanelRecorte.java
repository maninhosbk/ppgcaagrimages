package mvc_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import mvc_model.criacionais.FactoryMethod.ConcreteCreatorRecorte;
import mvc_model.criacionais.FactoryMethod.RecorteIrregular;
import mvc_model.criacionais.FactoryMethod.RecorteRegular;
import mvc_model.criacionais.FactoryMethod.Recorte;
import mvc_model.estruturais.Adapter.ReadMetadata;
import mvc_util.Util_Recorte;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class PanelRecorte extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File arquivo;
	private List<Mat> imagens;
    
	private int posList;
	//private CreatorRecorte creator;
	private String EXIFF = "";
	
	private Recorte recorte;
	/**
	 * Create the panel.
	 */
    
    
	public PanelRecorte() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		initComponents();
		imagens = new ArrayList<Mat>();
        posList = -1;
        this.setSize(670, 480);
	}
	
	public Mat matify(BufferedImage im) {
	    // Convert INT to BYTE
	    //im = new BufferedImage(im.getWidth(), im.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
	    // Convert bufferedimage to byte array
		Mat image = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write( im, "jpg", baos );
			baos.flush();
			byte[] pixels = baos.toByteArray();
			baos.close();
			// Create a Matrix the same size of image
		    image = new Mat(im.getHeight(), im.getWidth(), CvType.CV_8UC4);
		    // Fill Matrix with image values
		    image.put(0, 0, pixels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return image;

	}
	public void readTif(File file){
	    BufferedImage image;
		try {
			image = ImageIO.read(file);
			File outputFile = new File("1.png");
			ImageIO.write(image, "png", outputFile);
			Mat imagem = Highgui.imread("1.png");
			showResult(imagem);
			//ImageIcon icon = new ImageIcon(image);
            //jLabelImagem.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public File abrirArquivo(){
        JFileChooser fc = new JFileChooser();
        FileFilter ff1 = new FileNameExtensionFilter("Formato JPG (*.jpg)", "jpg");
        FileFilter ff2 = new FileNameExtensionFilter("Formato JPEG (*.jpeg)", "jpeg");
        FileFilter ff3 = new FileNameExtensionFilter("Formato PNG (*.png)", "png");
        FileFilter ff4 = new FileNameExtensionFilter("Formato TIFF (*.Tiff)", "tiff");

        fc.addChoosableFileFilter(ff1);
        fc.addChoosableFileFilter(ff2);
        fc.addChoosableFileFilter(ff3);
        fc.addChoosableFileFilter(ff4);

        //fc.setAcceptAllFileFilterUsed(false);

        File arquivoImagem;
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arquivoImagem = fc.getSelectedFile();
            return arquivoImagem;
        }
        return null;
    }
	public void showResult(Mat img) {
        Mat tmp = new Mat();
        int novoW = 0, novoH = 0;
        if(img.width() > panelFundo.getWidth()){
        	novoW = panelFundo.getWidth();
        	novoH = (novoW*img.height())/img.width();
        	
        	if(novoH > panelFundo.getHeight()){
        		novoH = panelFundo.getHeight();
        		novoW = (novoH*img.width())/img.height();
        	}
        }else{
        	novoW = img.width();
        	if(img.height() > panelFundo.getHeight()){
        		novoH = panelFundo.getHeight();
        		novoW = (novoH*img.width())/img.height();
        	}else{
        		novoH = img.height();
        	}
        }
        
        panelImagem.setSize(novoW,novoH);
        jLabelImagem.setBounds(0, 0, novoW, novoH);
        Imgproc.resize(img, tmp, new Size(novoW, novoH));
        MatOfByte matOfByte = new MatOfByte();
        Highgui.imencode(".png", tmp, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
            ImageIcon icon = new ImageIcon(bufImage);
            jLabelImagem.setIcon(icon);
        } catch (IOException | HeadlessException e) {
            
        }
    }
	
	
	public void convPontos(List<Point> point,int w,int h) {
		for(Point p : point){
			int x = (int) ((p.x * imagens.get(posList).width()) / w);
	        int y = (int) ((p.y * imagens.get(posList).height()) / h);
	        p.x = x;
	        p.y = y;
        }
    }
	public void convRoi(Rect roi,int w,int h) {
		roi.x = (int) ((roi.x * imagens.get(posList).width()) / w);
		roi.y = (int) ((roi.y * imagens.get(posList).height()) / h);
		roi.width = (int) ((roi.width * imagens.get(posList).width()) / w);
		roi.height = ((roi.height * imagens.get(posList).height()) / h);
    }
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Menu.setSize(new Dimension(getWidth(),Menu.getHeight()));
        panelFundo.setSize(new Dimension(this.getWidth(),this.getHeight()-Menu.getHeight()));
        panelImagem.setLocation((panelFundo.getWidth()/2) - (panelImagem.getWidth()/2) , (panelFundo.getHeight()/2) - (panelImagem.getHeight()/2));
        
        if(posList > -1){
			showResult(imagens.get(posList));
		}
        
        revalidate();
        repaint();
        g.dispose();
    }
	private void initComponents() {
		
		setLayout(null);
		JDialog metadados = new JDialog();
		JTextArea textExif = new JTextArea();
		metadados.setTitle("Metadados Imagem");
		metadados.setSize(400, 500);
		JScrollPane scroll = new JScrollPane();
		JPanel panelExiff = new JPanel();
		panelExiff.add(textExif);
		scroll.setViewportView(panelExiff);
		metadados.getContentPane().add(scroll);
		metadados.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		metadados.setLocationRelativeTo(null);
		metadados.setAlwaysOnTop(true);
		
		Menu = new javax.swing.JMenuBar();
		Menu.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		Menu.setForeground(Color.BLACK);
		Menu.setBackground(Color.WHITE);
		Menu.setLocation(0, 0);
		Menu.setSize(655, 32);
		File = new javax.swing.JMenu();
		File.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		File.setForeground(Color.BLACK);
		File.setBackground(Color.WHITE);
        menuAbriImagem = new javax.swing.JMenuItem();
        menuAbriImagem.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        JMenuItem menuSalvarImagem = new JMenuItem();
        menuSalvarImagem.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        Edit = new javax.swing.JMenu();
        Edit.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
        menuDesmarcar = new javax.swing.JMenuItem();
        menuDesmarcar.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        Recorte = new javax.swing.JMenu();
        Recorte.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
        menuRegular = new javax.swing.JMenuItem();
        menuRegular.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        panelFundo = new JPanel();
        panelFundo.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuIrregular = new JMenuItem();
        
		
        panelFundo.setBounds(0, 31, 655, 418);
		add(panelFundo);
		panelFundo.setLayout(null);
		
		panelImagem = new Util_Recorte();
		panelImagem.setBounds(0, 0, 655, 418);
		panelFundo.add(panelImagem);
		panelImagem.setLayout(null);
		jLabelImagem = new JLabel("");
		jLabelImagem.setBounds(5, 5, 0, 0);
		panelImagem.add(jLabelImagem);
		jLabelImagem.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		File.setText("Imagem");

        menuAbriImagem.setText("Abrir");
        menuAbriImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					menuAbriImagemActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        File.add(menuAbriImagem);

        Menu.add(File);
        
        
        menuSalvarImagem.setText("Salvar Imagem");
        menuSalvarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuSalvarImagemActionPerformed(evt);
            }
        });
        
        menuSalvarRecorte = new JMenuItem();
        menuSalvarRecorte.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		menuSalvarRecorteActionPerformed(evt);
        	}
        });
        menuSalvarRecorte.setText("Salvar Recorte");
        menuSalvarRecorte.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        File.add(menuSalvarRecorte);
        
        File.add(menuSalvarImagem);
        
        menuSalvarDados = new JMenuItem();
        
        menuSalvarDados.setText("Salvar Dados");
        menuSalvarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuSalvarDadosImagemActionPerformed(evt);
            }
        });
        menuSalvarDados.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        File.add(menuSalvarDados);

        Edit.setText("Editar");

        menuDesmarcar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuDesmarcar.setText("Desmarcar");
        menuDesmarcar.setEnabled(false);
        menuDesmarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDesfazerActionPerformed(evt);
            }
        });
        Edit.add(menuDesmarcar);

        Menu.add(Edit);
        
        menuRecortar = new JMenuItem();
        menuRecortar.setText("Recortar");
        menuRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuRecortarActionPerformed(evt);
            }
        });
        menuRecortar.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        menuRecortar.setEnabled(false);
        Edit.add(menuRecortar);

        Recorte.setText("Recorte");

        menuRegular.setText("Regular");
        menuRegular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuRegularActionPerformed(evt);
            }
        });
        Recorte.add(menuRegular);
        menuIrregular.setText("Irregular");
        menuIrregular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuIrregularActionPerformed(evt);
            }
        });
        menuIrregular.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        Recorte.add(menuIrregular);
        Menu.add(Recorte);
        add(Menu);
        
        menuMetadados = new JMenu();
        menuMetadados.setText("Metadados");
        menuMetadados.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
        Menu.add(menuMetadados);
        
        menuMostrarMetadados = new JMenuItem();
        menuMostrarMetadados.setEnabled(false);
        menuMostrarMetadados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textExif.setText(EXIFF);
        		metadados.setVisible(true);
        	}
        });
        menuMostrarMetadados.setText("Mostrar metadados");
        menuMostrarMetadados.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
        menuMetadados.add(menuMostrarMetadados);
	}
	private void menuAbriImagemActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_menuAbriImagemActionPerformed
        arquivo = abrirArquivo();
        
        if(arquivo != null){
	        ReadMetadata read = new ReadMetadata(arquivo);
	        EXIFF = read.getEXIFF();
	        menuMostrarMetadados.setEnabled(true);
	        Mat imagem = Highgui.imread(arquivo.getPath());
	        if(posList != imagens.size()-1){
	            imagens.set(posList + 1, imagem);
	        }else{
	            imagens.add(imagem);
	        }
	        posList++;
        }
    }
	private void menuSalvarRecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbriImagemActionPerformed
		String classe = JOptionPane.showInputDialog(this, "Informe o nome da classe que deseja Salvar");
		if(recorte instanceof RecorteIrregular){
			RecorteIrregular ri = (RecorteIrregular) recorte;
			ri.dados.getClasses().add(classe);
			ri.salvarDadosRecorte(classe);
		}else if(recorte instanceof RecorteRegular){
			RecorteRegular rr = (RecorteRegular) recorte;
			rr.dados.getClasses().add(classe);
			rr.salvarDadosRecorte(classe);
		}
		recorte.salvarDadosRecorte(classe);
    }
	
	private void menuSalvarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbriImagemActionPerformed
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Informe o nome do arquivo");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            recorte.salvarImagem(fileToSave.getAbsolutePath());
        }
    }
	
	private void menuSalvarDadosImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbriImagemActionPerformed
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Informe o nome do arquivo");
        FileFilter ff1 = new FileNameExtensionFilter("Arff data files (*.arff)", "arff");
        FileFilter ff2 = new FileNameExtensionFilter("Separado por virgulas (*.csv)", "csv");
        fileChooser.addChoosableFileFilter(ff1);
        fileChooser.addChoosableFileFilter(ff2);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
				recorte.salvarDados(new FileWriter(fileToSave));
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				JOptionPane.showConfirmDialog(this, "Arquivo salvo em: "+fileToSave.getAbsolutePath(),"Arquivo Salvo", JOptionPane.YES_OPTION);
			}   
        }
    }
	
    private void menuRegularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrayActionPerformed
        Util_Recorte ie = (Util_Recorte) panelImagem;
        ie.setRegular(true);
        menuRecortar.setEnabled(true);
    }
     
    private void menuIrregularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrayActionPerformed
        Util_Recorte ie = (Util_Recorte) panelImagem;
        ie.setIrregular(true);
        menuRecortar.setEnabled(true);
    }

    private void menuRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrayActionPerformed
    	//creator = new ConcreteCreatorRecorte();
    	ConcreteCreatorRecorte creator = new ConcreteCreatorRecorte();
        Util_Recorte ie = (Util_Recorte) panelImagem;
        Mat result = new Mat();
        if(ie.isRegular()){
        	convRoi(ie.getRoi(), jLabelImagem.getWidth(), jLabelImagem.getHeight());
        	recorte = creator.getRecorte(imagens.get(posList),ie.getRoi());
        	RecorteRegular rr = (RecorteRegular) recorte;
        	rr.recortar();
        	result = rr.getResult();
        	ie.setRegular(false);
        }else if(ie.isIrregular()){
        	convPontos(ie.getPontos(), jLabelImagem.getWidth(), jLabelImagem.getHeight());
        	recorte = creator.getRecorte(imagens.get(posList),ie.getPontos());
        	RecorteIrregular ri = (RecorteIrregular) recorte;
        	ri.recortar();
        	result = ri.getResult();
        	ie.setIrregular(false);
        }
        if(posList != imagens.size()-1){
            imagens.set(posList + 1, result);
        }else{
            imagens.add(result);
        }
        posList++;
        ie.removerpontos();
        menuRecortar.setEnabled(false);
    }
    
    private void menuDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDesfazerActionPerformed
        
    }
	private JPanel panelFundo;
	private JPanel panelImagem;
	private JMenuBar Menu;
	private JMenu Edit;
    private JMenu File;
    private JMenu Recorte;
	private JMenuItem menuAbriImagem;
    private JMenuItem menuDesmarcar;
    private JMenuItem menuRegular;
    private JLabel jLabelImagem;
    private JMenuItem menuIrregular;
    private JMenuItem menuSalvarDados;
    private JMenuItem menuRecortar;
    private JMenuItem menuSalvarRecorte;
    private JMenu menuMetadados;
    private JMenuItem menuMostrarMetadados;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
}
