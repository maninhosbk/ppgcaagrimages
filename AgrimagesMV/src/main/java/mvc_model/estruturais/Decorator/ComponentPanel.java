package mvc_model.estruturais.Decorator;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public abstract class ComponentPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel header;
	private JPanel centro;
	private CardLayout cardLayout;
	JLabel lblFundo;
	
	
	public ComponentPanel(){
		
		setHeader(new JPanel());
		setCentro(new JPanel());
		lblFundo = new JLabel();
		cardLayout = new CardLayout();
		
		getHeader().setBorder(new LineBorder(Color.black));
		add(getHeader());
		add(getCentro());
		add(lblFundo);
		
		getHeader().setBounds(0, 0, this.getWidth(), 70);
		getHeader().setBackground(new Color(255,255,255,200));
		
		getCentro().setBounds(0, 70, this.getWidth(), this.getHeight()-70);
		//getCentro().setBackground(new Color(255,255,255,170));
		getCentro().setLayout(cardLayout);
		
		lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundoAjustavel.JPG")));
		lblFundo.setBounds(0, 0, 640, 481);
		lblFundo.setOpaque(true);
		lblFundo.setVisible(true);
		
		addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
            	lblFundo.setSize(getSize());
            }
        });
		
		this.setLayout(null);
		
		
	}

	public void setCompVisible(String component){
		this.cardLayout.show(getCentro(), component);
	}

	public JPanel getCentro() {
		return centro;
	}

	public void setCentro(JPanel centro) {
		this.centro = centro;
	}

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}
	
}
