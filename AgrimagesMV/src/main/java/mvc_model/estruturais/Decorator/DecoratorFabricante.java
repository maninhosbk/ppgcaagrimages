package mvc_model.estruturais.Decorator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DecoratorFabricante extends Decorator{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public DecoratorFabricante(ComponentPanel main) {
		super(main);
		// TODO Auto-generated constructor stub
		JPanel panel = new mvc_view.PanelFabricante();
		panel.setBorder(new LineBorder(Color.black));
		panel.setBackground(new Color(255, 255, 255));
		panel.setName("fabricante");
		
		JButton botaoMenuMini = new JButton();
		botaoMenuMini.setName("fabricante");
		botaoMenuMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Sem Borda/btnFabricanteMini.png")));
		botaoMenuMini.setBorder(null);
		botaoMenuMini.setContentAreaFilled(false);
		botaoMenuMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botaoMenuMini.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Borda/btnFabricanteMini.png")));
		botaoMenuMini.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Borda/btnFabricanteMini.png")));
		
		main.getHeader().add(botaoMenuMini);
		main.getCentro().add(panel, "fabricante");
		
		JButton botaoMenu = new JButton();
		botaoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sem Borda/btnFabricante.png")));
		botaoMenu.setBorder(null);
		botaoMenu.setContentAreaFilled(false);
		botaoMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botaoMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Borda/btnFabricante.png")));
		botaoMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Borda/btnFabricante.png")));
		botaoMenu.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    		   main.setCompVisible("fabricante");
	    	   }
	       });
		
		JPanel aux = (JPanel) main.getCentro().getComponent(0);
		aux.add(botaoMenu);
		
		botaoMenuMini.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    		   main.setCompVisible("fabricante");
	    	   }
	       });
		botaoMenuMini.setVisible(true);	}
}
