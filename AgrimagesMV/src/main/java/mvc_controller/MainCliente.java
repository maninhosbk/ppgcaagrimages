package mvc_controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import mvc_model.estruturais.Decorator.ComponentPanel;
import mvc_model.estruturais.Decorator.ConcreteComponentHome;
import mvc_model.estruturais.Decorator.DecoratorAeronave;
import mvc_model.estruturais.Decorator.DecoratorAreaEstudo;
import mvc_model.estruturais.Decorator.DecoratorCamera;
import mvc_model.estruturais.Decorator.DecoratorCorrecao;
import mvc_model.estruturais.Decorator.DecoratorExperimento;
import mvc_model.estruturais.Decorator.DecoratorFabricante;
import mvc_model.estruturais.Decorator.DecoratorMineracao;
import mvc_model.estruturais.Decorator.DecoratorOperador;
import mvc_model.estruturais.Decorator.DecoratorRecorte;
import mvc_model.estruturais.Decorator.DecoratorVoo;

import org.opencv.core.Core;

public class MainCliente extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ComponentPanel simples;
	private JButton config;
	private JDialog configuracao;
	
	private JCheckBox aeronave;
	private JCheckBox areaEstudo;
	private JCheckBox camera;
	private JCheckBox correcao;
	private JCheckBox experimento;
	private JCheckBox fabricante;
	private JCheckBox mineracao;
	private JCheckBox operador;
	private JCheckBox recorte;
	private JCheckBox voo;
	
	private final JPanel contentPanel = new JPanel();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    try {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException 
							| InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
            }
         
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCliente frame = new MainCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int w = getWidth();
        int h = getHeight();
        
        simples.setBounds(0, 0, w, h);
        simples.getHeader().setBounds(0, 0, w-16, 70);
        simples.getCentro().setBounds(w/20, 50 + h/20, w - (2*w/20)-16, h - (2*h/20) - 70);
        simples.getHeader().setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        revalidate();
        repaint();
        g.dispose();
    }

	public void setFont(Component c, int tam){
		c.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, tam));
	}
	public boolean verificaExComp(String nome, boolean remove){
		boolean exist = false;
		int i = 0;
		for(Component c : simples.getHeader().getComponents()){
            if(c.getName().equals(nome)){
            		exist = true;
            }
            i++;
        }
		return exist;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	/**
	 * Create the frame.
	 */
	public MainCliente() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		configuracao = new JDialog();
		simples = new ConcreteComponentHome();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(700, 600);
		setMinimumSize(new Dimension(700,600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		configuracao.setBounds(100, 100, 400, 300);
		configuracao.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		configuracao.getContentPane().add(contentPanel, BorderLayout.CENTER);
		configuracao.setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 228);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("Selecione as funcionalidades visíveis do sistema");
		titulo.setBounds(10, 7, 350, 23);
		setFont(titulo,14);
		panel.add(titulo);
		
		aeronave = new JCheckBox("Aeronave");
		aeronave.setBounds(24, 45, 97, 23);
		setFont(aeronave,12);
		panel.add(aeronave);

		areaEstudo = new JCheckBox("Area de Estudo");
		areaEstudo.setBounds(24, 90, 120, 23);
		setFont(areaEstudo,12);
		panel.add(areaEstudo);
		

		camera = new JCheckBox("Câmera");
		camera.setBounds(24, 136, 97, 23);
		setFont(camera,12);
		panel.add(camera);

		correcao = new JCheckBox("Correção");
		correcao.setBounds(150, 45, 97, 23);
		setFont(correcao,12);
		panel.add(correcao);

		experimento = new JCheckBox("Experimento");
		experimento.setBounds(150, 90, 97, 23);
		setFont(experimento,12);
		panel.add(experimento);

		fabricante = new JCheckBox("Fabricante");
		fabricante.setBounds(150, 136, 97, 23);
		setFont(fabricante,12);
		panel.add(fabricante);

		mineracao = new JCheckBox("Mineração");
		mineracao.setBounds(280, 45, 97, 23);
		setFont(mineracao,12);
		panel.add(mineracao);

		operador = new JCheckBox("Operador");
		operador.setBounds(280, 90, 97, 23);
		setFont(operador,12);
		panel.add(operador);

		recorte = new JCheckBox("Recorte");
		recorte.setBounds(280, 136, 97, 23);
		setFont(recorte,12);
		panel.add(recorte);

		voo = new JCheckBox("Voo");
		voo.setBounds(24, 179, 97, 23);
		setFont(voo,12);
		panel.add(voo);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		configuracao.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configActionListener(arg0);
			}
		});
		buttonPane.add(okButton);
		
		configuracao.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configuracao.dispose();
			}
		});
		buttonPane.add(cancelButton);

		
		simples.setBounds(5, 5, 424, 251);
		
		for(Component c : simples.getHeader().getComponents()){
			if(c.getName() != null && c.getName().equals("config")){
				config = (JButton) c;
				break;
			}
		}
		
		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configuracao.setVisible(true);
			}
		});
		
		
		this.contentPane.add(simples);
		
		setLocationRelativeTo(null);
	}
	
	private void configActionListener(java.awt.event.ActionEvent evt) {
		if(aeronave.isSelected() && !verificaExComp("aeronave", false)){
			new DecoratorAeronave(simples);
		}
		if(areaEstudo.isSelected() && !verificaExComp("areaEstudo", false)){
			new DecoratorAreaEstudo(simples);
		}
		if(operador.isSelected() && !verificaExComp("operador", false)){
				new DecoratorOperador(simples);
		}
		if(camera.isSelected() && !verificaExComp("camera", false)){
				new DecoratorCamera(simples);
		}
		if(experimento.isSelected() && !verificaExComp("experimento", false)){
			new DecoratorExperimento(simples);
		}
		if(fabricante.isSelected() && !verificaExComp("fabricante", false)){
			new DecoratorFabricante(simples);
		}
		if(voo.isSelected() && !verificaExComp("voo", false)){
			new DecoratorVoo(simples);
		}
		if(recorte.isSelected() && !verificaExComp("recorte", false)){
			new DecoratorRecorte(simples);
		}
		if(correcao.isSelected() && !verificaExComp("correcao", false)){
			new DecoratorCorrecao(simples);
		}
		if(mineracao.isSelected() && !verificaExComp("mineracao", false)){
			new DecoratorMineracao(simples);
		}
		configuracao.dispose();
	}
	
}
