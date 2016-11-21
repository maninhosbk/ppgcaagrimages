/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mvc_util.HibernateUtil;
import mvc_view.PanelCorrecao;
import mvc_view.PanelRecorte;

/**
 *
 * @author Antonio David Viniski
 */
public class Main extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private int widthComp = 100;

	private static final long serialVersionUID = 1L;

	public enum Screen {
		MENU, AREA, AERONAVE, OPERADOR, EXPERIMENTO, CAMERA, FABRICANTE, VOO, CORRECAO, MINERACAO, RECORTE, INTERPOLACAO
	}

	public Screen tela;

	/**
	 * Creates new form Main
	 */
	public Main() {
		HibernateUtil.getSession();
		initComponents();
		tela = Screen.MENU;
		this.setLocationRelativeTo(null);
	}

	public void trocaTela(Screen e) {
		if (this.tela.equals(e)) {
			return;
		}
		jScrollPaneMenu.setVisible(false);
		PanelMenu.setVisible(false);
		PanelArea.setVisible(false);
		PanelOperador.setVisible(false);
		PanelAeronave.setVisible(false);
		PanelCamera.setVisible(false);
		PanelExperimento.setVisible(false);
		PanelVoo.setVisible(false);
		PanelCorrecao.setVisible(false);
		PanelMineracao.setVisible(false);
		PanelRecorte.setVisible(false);
		PanelFabricante.setVisible(false);

		switch (this.tela = e) {
		case MENU:
			jScrollPaneMenu.setVisible(true);
			PanelMenu.setVisible(true);
			break;
		case AREA:
			PanelArea.setVisible(true);
			break;
		case AERONAVE:
			PanelAeronave.setVisible(true);
			break;
		case OPERADOR:
			PanelOperador.setVisible(true);
			break;
		case EXPERIMENTO:
			PanelExperimento.setVisible(true);
			break;
		case CAMERA:
			PanelCamera.setVisible(true);
			break;
		case FABRICANTE:
			PanelFabricante.setVisible(true);
			break;
		case VOO:
			PanelVoo.setVisible(true);
			break;
		case CORRECAO:
			PanelCorrecao.setVisible(true);
			break;
		case MINERACAO:
			PanelMineracao.setVisible(true);
			break;
		case RECORTE:
			PanelRecorte.setVisible(true);
			break;
		case INTERPOLACAO:
			break;
		default:
			jScrollPaneMenu.setVisible(true);
			PanelMenu.setVisible(true);
			break;

		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		PanelMenuTop.setBounds(0, 0, getWidth(), 70);
		PanelCentral.setBounds(0, 70, getWidth(), getHeight() - 110);

		int w = PanelCentral.getWidth();
		int h = PanelCentral.getHeight();

		int aux = PanelMenuTop.getComponentCount();

		for (Component c : PanelMenuTop.getComponents()) {
			c.setLocation(PanelMenuTop.getWidth() - (55 * aux) - 20, 10);
			aux--;
		}

		for (Component c : PanelCentral.getComponents()) {
			if (!(c instanceof JLabel)) {
				c.setSize(w - (w / 10), h - (h / 10));
				c.setLocation((w / 10) / 2, (h / 10) / 2);
				PanelCentral.setLayout(null);
			}
		}
		int i = 0, j = 0;
		int posX = PanelMenu.getWidth() / (widthComp + (widthComp / 2));
		int espaco = ((PanelMenu.getWidth() - (posX * widthComp)) / (posX + 1));
		int maxH = (h / 10) / 2;
		for (Component c : PanelMenu.getComponents()) {
			if (i == posX) {
				i = 0;
				j++;
			}
			int width = espaco * (i + 1) + c.getWidth() * i;
			int heigth = 30 * (j + 1) + c.getHeight() * j;
			c.setLocation(width, heigth);
			i++;
			PanelMenu.setLayout(null);
			if (c.getLocation().getY() + c.getHeight() > maxH) {
				maxH = (int) (c.getLocation().getY() + c.getHeight() + 30);
			}
		}
		if (maxH != getHeight()) {
			PanelMenu.setPreferredSize(new Dimension(w - (w / 10), maxH));
			PanelMenu.setLayout(null);
		}
		revalidate();
		repaint();
		g.dispose();
	}

	private void initComponents() {

		PanelFundo = new javax.swing.JPanel();
		PanelMenuTop = new javax.swing.JPanel();
		PanelMenuTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelMenuTop.setBounds(0, 0, 784, 70);

		PanelFundo.add(PanelMenuTop);

		btnAreaMini = new javax.swing.JButton();
		btnAreaMini.setBounds(50, 10, 50, 50);
		btnOperadorMini = new javax.swing.JButton();
		btnOperadorMini.setBounds(100, 10, 50, 50);
		btnAeronaveMini = new javax.swing.JButton();
		btnAeronaveMini.setBounds(150, 10, 50, 50);
		btnCameraMini = new javax.swing.JButton();
		btnCameraMini.setBounds(200, 10, 50, 50);
		btnExperimentoMini = new javax.swing.JButton();
		btnExperimentoMini.setBounds(250, 10, 50, 50);
		btnVooMini = new javax.swing.JButton();
		btnVooMini.setBounds(300, 10, 50, 50);
		btnCorrecoesMini = new javax.swing.JButton();
		btnCorrecoesMini.setBounds(350, 10, 50, 50);
		btnMineracaoDadosMini = new javax.swing.JButton();
		btnMineracaoDadosMini.setBounds(400, 10, 50, 50);
		btnRecorteImagemMini = new javax.swing.JButton();
		btnRecorteImagemMini.setBounds(450, 10, 50, 50);
		btnFabricanteMini = new javax.swing.JButton();
		btnFabricanteMini.setBounds(500, 10, 50, 50);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("AGRImage Software");
		setMinimumSize(new java.awt.Dimension(200, 300));
		setPreferredSize(new java.awt.Dimension(800, 500));
		setSize(new java.awt.Dimension(800, 500));

		// layout bot�es mini
		btnAeronaveMini
				.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"/Imagens/MenuMini/Sem Borda/btnAeronaveMini.png")));
		btnAeronaveMini.setBorder(null);
		btnAeronaveMini.setContentAreaFilled(false);
		btnAeronaveMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnAeronaveMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnAeronaveMini.png")));
		btnAeronaveMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnAeronaveMini.png")));

		btnCameraMini.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/MenuMini/Sem Borda/btnCameraMini.png")));
		btnCameraMini.setBorder(null);
		btnCameraMini.setContentAreaFilled(false);
		btnCameraMini
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCameraMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnCameraMini.png")));
		btnCameraMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnCameraMini.png")));

		btnOperadorMini
				.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"/Imagens/MenuMini/Sem Borda/btnOperadorMini.png")));
		btnOperadorMini.setBorder(null);
		btnOperadorMini.setContentAreaFilled(false);
		btnOperadorMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnOperadorMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnOperadorMini.png")));
		btnOperadorMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnOperadorMini.png")));

		btnVooMini.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/MenuMini/Sem Borda/btnVooMini.png")));
		btnVooMini.setBorder(null);
		btnVooMini.setContentAreaFilled(false);
		btnVooMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnVooMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnVooMini.png")));
		btnVooMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnVooMini.png")));

		btnCorrecoesMini
				.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"/Imagens/MenuMini/Sem Borda/btnCorrecaoMini.png")));
		btnCorrecoesMini.setBorder(null);
		btnCorrecoesMini.setContentAreaFilled(false);
		btnCorrecoesMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnCorrecoesMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnCorrecaoMini.png")));
		btnCorrecoesMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnCorrecaoMini.png")));

		btnMineracaoDadosMini.setIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/Imagens/MenuMini/Sem Borda/btnMineracaoMini.png")));
		btnMineracaoDadosMini.setBorder(null);
		btnMineracaoDadosMini.setContentAreaFilled(false);
		btnMineracaoDadosMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnMineracaoDadosMini.setRolloverIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/Imagens/MenuMini/Borda/btnMineracaoMini.png")));
		btnMineracaoDadosMini.setSelectedIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/Imagens/MenuMini/Borda/btnMineracaoMini.png")));

		btnRecorteImagemMini
				.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"/Imagens/MenuMini/Sem Borda/btnRecorteMini.png")));
		btnRecorteImagemMini.setBorder(null);
		btnRecorteImagemMini.setContentAreaFilled(false);
		btnRecorteImagemMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnRecorteImagemMini.setRolloverIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/Imagens/MenuMini/Borda/btnRecorteMini.png")));
		btnRecorteImagemMini.setSelectedIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/Imagens/MenuMini/Borda/btnRecorteMini.png")));

		btnExperimentoMini.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource(
						"/Imagens/MenuMini/Sem Borda/btnExperimentoMini.png")));
		btnExperimentoMini.setBorder(null);
		btnExperimentoMini.setContentAreaFilled(false);
		btnExperimentoMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnExperimentoMini
				.setRolloverIcon(new javax.swing.ImageIcon(
						getClass()
								.getResource(
										"/Imagens/MenuMini/Borda/btnExperimentoMini.png")));
		btnExperimentoMini
				.setSelectedIcon(new javax.swing.ImageIcon(
						getClass()
								.getResource(
										"/Imagens/MenuMini/Borda/btnExperimentoMini.png")));

		btnFabricanteMini.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource(
						"/Imagens/MenuMini/Sem Borda/btnFabricanteMini.png")));
		btnFabricanteMini.setBorder(null);
		btnFabricanteMini.setContentAreaFilled(false);
		btnFabricanteMini.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnFabricanteMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnFabricanteMini.png")));
		btnFabricanteMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnFabricanteMini.png")));

		btnAreaMini.setIcon(new ImageIcon(Main.class
				.getResource("/Imagens/MenuMini/Sem Borda/btnAreaMini.png")));
		btnAreaMini.setBorder(null);
		btnAreaMini.setContentAreaFilled(false);
		btnAreaMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAreaMini.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Borda/btnAreaMini.png")));
		btnAreaMini.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/MenuMini/Sem Borda/btnAreaMini.png")));

		PanelMenuTop.setLayout(null);
		PanelMenuTop.add(btnAreaMini);
		PanelMenuTop.add(btnOperadorMini);
		PanelMenuTop.add(btnFabricanteMini);
		PanelMenuTop.add(btnAeronaveMini);
		PanelMenuTop.add(btnCameraMini);
		PanelMenuTop.add(btnExperimentoMini);
		PanelMenuTop.add(btnVooMini);
		PanelMenuTop.add(btnCorrecoesMini);
		PanelMenuTop.add(btnMineracaoDadosMini);
		PanelMenuTop.add(btnRecorteImagemMini);
		PanelMenuTop.setBackground(Color.WHITE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				PanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				PanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		PanelFundo.setLayout(null);
		PanelFundo.setBounds(0, 70, 80, 80);

		PanelCentral = new JPanel();
		PanelCentral.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelCentral.setBounds(0, 70, 784, 391);
		PanelFundo.add(PanelCentral);
		PanelCentral.setLayout(null);
		jScrollPaneMenu = new javax.swing.JScrollPane();
		jScrollPaneMenu.setBounds(161, 5, 202, 202);
		PanelCentral.add(jScrollPaneMenu);
		jScrollPaneMenu.setOpaque(false);

		PanelMenu = new javax.swing.JPanel();
		PanelMenu.setBackground(Color.WHITE);

		PanelMenu.setAutoscrolls(true);

		btnArea = new javax.swing.JButton();
		btnArea.setBounds(40, 30, 100, 80);
		btnOperador = new javax.swing.JButton();
		btnOperador.setBounds(180, 30, 100, 80);
		btnAeronave = new javax.swing.JButton();
		btnAeronave.setBounds(320, 30, 100, 80);
		btnCamera = new javax.swing.JButton();
		btnCamera.setBounds(460, 30, 100, 80);
		btnExperimento = new javax.swing.JButton();
		btnExperimento.setBounds(600, 30, 100, 80);
		btnVoo = new javax.swing.JButton();
		btnVoo.setBounds(40, 140, 100, 80);
		btnCorrecoes = new javax.swing.JButton();
		btnCorrecoes.setBounds(180, 140, 100, 80);
		btnMineracaoDados = new javax.swing.JButton();
		btnMineracaoDados.setBounds(320, 140, 100, 80);
		btnRecorteImagem = new javax.swing.JButton();
		btnRecorteImagem.setBounds(460, 140, 100, 80);
		btnFabricante = new javax.swing.JButton();
		btnFabricante.setBounds(600, 140, 100, 80);
		jScrollPaneMenu
				.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

		PanelMenu.setPreferredSize(new java.awt.Dimension(200, 200));
		PanelMenu.setMinimumSize(new java.awt.Dimension(0, 0));
		PanelMenu.setLayout(null);

		// layout bot�es
		btnAeronave.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnAeronave.png")));
		btnAeronave.setBorder(null);
		btnAeronave.setContentAreaFilled(false);
		btnAeronave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAeronave.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnAeronave.png")));
		btnAeronave.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnAeronave.png")));

		btnCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnCamera.png")));
		btnCamera.setBorder(null);
		btnCamera.setContentAreaFilled(false);
		btnCamera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCamera.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnCamera.png")));
		btnCamera.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnCamera.png")));

		btnOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnOperador.png")));
		btnOperador.setBorder(null);
		btnOperador.setContentAreaFilled(false);
		btnOperador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnOperador.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnOperador.png")));
		btnOperador.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnOperador.png")));

		btnVoo.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnVoo.png")));
		btnVoo.setBorder(null);
		btnVoo.setContentAreaFilled(false);
		btnVoo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnVoo.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnVoo.png")));
		btnVoo.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnVoo.png")));

		btnCorrecoes.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnCorrecao.png")));
		btnCorrecoes.setBorder(null);
		btnCorrecoes.setContentAreaFilled(false);
		btnCorrecoes
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCorrecoes.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnCorrecao.png")));
		btnCorrecoes.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnCorrecao.png")));

		btnMineracaoDados.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Sem Borda/btnDataMining.png")));
		btnMineracaoDados.setBorder(null);
		btnMineracaoDados.setContentAreaFilled(false);
		btnMineracaoDados.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnMineracaoDados.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnDataMining.png")));
		btnMineracaoDados.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnDataMining.png")));

		btnRecorteImagem.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Sem Borda/btnRecorte.png")));
		btnRecorteImagem.setBorder(null);
		btnRecorteImagem.setContentAreaFilled(false);
		btnRecorteImagem.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnRecorteImagem.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnRecorte.png")));
		btnRecorteImagem.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnRecorte.png")));

		btnExperimento.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Sem Borda/btnExperimento.png")));
		btnExperimento.setBorder(null);
		btnExperimento.setContentAreaFilled(false);
		btnExperimento.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		btnExperimento.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnExperimento.png")));
		btnExperimento.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnExperimento.png")));

		btnFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnFabricante.png")));
		btnFabricante.setBorder(null);
		btnFabricante.setContentAreaFilled(false);
		btnFabricante
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnFabricante.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnFabricante.png")));
		btnFabricante.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnFabricante.png")));

		btnArea.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Imagens/Sem Borda/btnArea.png")));
		btnArea.setBorder(null);
		btnArea.setContentAreaFilled(false);
		btnArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnArea.setSize(100, 80);
		btnArea.setRolloverIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnArea.png")));
		btnArea.setSelectedIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/Imagens/Borda/btnArea.png")));
		// fim layout

		jScrollPaneMenu.setViewportView(PanelMenu);

		PanelMenu.setLayout(null);
		PanelMenu.add(btnArea);
		PanelMenu.add(btnOperador);
		PanelMenu.add(btnFabricante);
		PanelMenu.add(btnAeronave);
		PanelMenu.add(btnCamera);
		PanelMenu.add(btnExperimento);
		PanelMenu.add(btnVoo);
		PanelMenu.add(btnCorrecoes);
		PanelMenu.add(btnMineracaoDados);
		PanelMenu.add(btnRecorteImagem);

		PanelArea = new javax.swing.JPanel();
		PanelArea.setBackground(Color.WHITE);
		PanelArea.setBounds(473, 86, 10, 10);
		PanelCentral.add(PanelArea);
		PanelOperador = new javax.swing.JPanel();
		PanelOperador.setBackground(Color.WHITE);
		PanelOperador.setBounds(383, 101, 10, 10);
		PanelCentral.add(PanelOperador);
		PanelAeronave = new javax.swing.JPanel();
		PanelAeronave.setBackground(Color.WHITE);
		PanelAeronave.setBounds(398, 101, 10, 10);
		PanelCentral.add(PanelAeronave);
		PanelCamera = new javax.swing.JPanel();
		PanelCamera.setBackground(Color.WHITE);
		PanelCamera.setBounds(413, 101, 10, 10);
		PanelCentral.add(PanelCamera);
		PanelExperimento = new javax.swing.JPanel();
		PanelExperimento.setBackground(Color.WHITE);
		PanelExperimento.setBounds(428, 101, 10, 10);
		PanelCentral.add(PanelExperimento);
		PanelVoo = new javax.swing.JPanel();
		PanelVoo.setBackground(Color.WHITE);
		PanelVoo.setBounds(443, 101, 10, 10);
		PanelCentral.add(PanelVoo);

		PanelCorrecao = new PanelCorrecao();
		PanelCorrecao.setBackground(Color.WHITE);
		// PanelCorrecao.setBounds(458, 101, 10, 10);

		PanelCentral.add(PanelCorrecao);
		PanelMineracao = new javax.swing.JPanel();
		PanelMineracao.setBackground(Color.WHITE);
		PanelMineracao.setBounds(473, 101, 10, 10);
		PanelCentral.add(PanelMineracao);
		PanelRecorte = new PanelRecorte();
		PanelRecorte.setBackground(Color.WHITE);
		PanelRecorte.setBounds(488, 101, 10, 10);
		PanelCentral.add(PanelRecorte);
		PanelFabricante = new JPanel();
		PanelFabricante.setBackground(Color.WHITE);
		PanelFabricante.setBounds(503, 101, 10, 10);
		PanelCentral.add(PanelFabricante);

		PanelCentral.setBackground(new Color(255, 255, 255, 170));
		PanelMenuTop.setBackground(new Color(255, 255, 255, 200));

		btnArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.AREA);
			}
		});
		btnOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.OPERADOR);
			}
		});
		btnFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.FABRICANTE);
			}
		});
		btnAeronave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.AERONAVE);
			}
		});
		btnCamera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.CAMERA);
			}
		});
		btnExperimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.EXPERIMENTO);
			}
		});
		btnVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.VOO);
			}
		});
		btnCorrecoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.CORRECAO);
			}
		});
		btnMineracaoDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.MINERACAO);
				// new PDI().setVisible(true);
			}
		});
		btnRecorteImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.RECORTE);
			}
		});

		// inicio listener menu
		btnAreaMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.MENU);
			}
		});
		btnOperadorMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.OPERADOR);
			}
		});
		btnFabricanteMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.FABRICANTE);
			}
		});
		btnAeronaveMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.AERONAVE);
			}
		});
		btnCameraMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.CAMERA);
			}
		});
		btnExperimentoMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.EXPERIMENTO);
			}
		});
		btnVooMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.VOO);
			}
		});
		btnCorrecoesMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.CORRECAO);
				// new PDI().setVisible(true);
			}
		});
		btnMineracaoDadosMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.MINERACAO);
			}
		});
		btnRecorteImagemMini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela(Screen.RECORTE);
			}
		});

		PanelFundo.setAutoscrolls(true);

		lblFundo = new javax.swing.JLabel("");
		lblFundo.setOpaque(true);
		lblFundo.setBounds(0, 0, 797, 461);
		PanelFundo.add(lblFundo);

		lblFundo.setIcon(new ImageIcon(
				"C:\\Users\\david\\Documents\\workspace\\AGRImages\\src\\Imagens\\Fundo2.jpg"));
		PanelFundo.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(java.awt.event.ComponentEvent evt) {
				PanelFundoComponentResized(evt);
			}
		});
		pack();
	}

	private void PanelFundoComponentResized(java.awt.event.ComponentEvent evt) {
		lblFundo.setSize(PanelFundo.getSize());
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	private javax.swing.JPanel PanelArea;
	private javax.swing.JPanel PanelOperador;
	private javax.swing.JPanel PanelAeronave;
	private javax.swing.JPanel PanelCamera;
	private javax.swing.JPanel PanelExperimento;
	private javax.swing.JPanel PanelVoo;
	private javax.swing.JPanel PanelCorrecao;
	private javax.swing.JPanel PanelMineracao;
	private javax.swing.JPanel PanelRecorte;
	private javax.swing.JPanel PanelFabricante;
	private javax.swing.JLabel lblFundo;
	private javax.swing.JPanel PanelFundo;
	private javax.swing.JPanel PanelMenu;

	private javax.swing.JButton btnAeronave;
	private javax.swing.JButton btnArea;
	private javax.swing.JButton btnCamera;
	private javax.swing.JButton btnCorrecoes;
	private javax.swing.JButton btnExperimento;
	private javax.swing.JButton btnFabricante;
	private javax.swing.JButton btnMineracaoDados;
	private javax.swing.JButton btnOperador;
	private javax.swing.JButton btnRecorteImagem;
	private javax.swing.JButton btnVoo;

	private javax.swing.JButton btnAeronaveMini;
	private javax.swing.JButton btnAreaMini;
	private javax.swing.JButton btnCameraMini;
	private javax.swing.JButton btnCorrecoesMini;
	private javax.swing.JButton btnExperimentoMini;
	private javax.swing.JButton btnFabricanteMini;
	private javax.swing.JButton btnMineracaoDadosMini;
	private javax.swing.JButton btnOperadorMini;
	private javax.swing.JButton btnRecorteImagemMini;
	private javax.swing.JButton btnVooMini;

	private javax.swing.JScrollPane jScrollPaneMenu;
	private javax.swing.JPanel PanelMenuTop;
	private javax.swing.JPanel PanelCentral;

	@Override
	public void actionPerformed(ActionEvent e) {
		super.repaint();
	}
}