package mvc_model.estruturais.Decorator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DecoratorAeronave extends Decorator{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public DecoratorAeronave(ComponentPanel main) {
		super(main);
		// TODO Auto-generated constructor stub
		JPanel panel = new mvc_view.PanelAeronave();
		panel.setBorder(new LineBorder(Color.black));
		panel.setBackground(new Color(255, 255, 255));
		panel.setName("aeronave");
		
		JButton botaoMenuMini = new JButton();
		botaoMenuMini.setName("aeronave");
		botaoMenuMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Sem Borda/btnAeronaveMini.png")));
		botaoMenuMini.setBorder(null);
		botaoMenuMini.setContentAreaFilled(false);
		botaoMenuMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botaoMenuMini.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Borda/btnAeronaveMini.png")));
		botaoMenuMini.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MenuMini/Borda/btnAeronaveMini.png")));
		
		
		
		main.getHeader().add(botaoMenuMini);
		main.getCentro().add(panel, "aeronave");
		
		JButton botaoMenu = new JButton();
		botaoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sem Borda/btnAeronave.png")));
		botaoMenu.setBorder(null);
		botaoMenu.setContentAreaFilled(false);
		botaoMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botaoMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Borda/btnAeronave.png")));
		botaoMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Borda/btnAeronave.png")));
		botaoMenu.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    		   main.setCompVisible("aeronave");
	    	   }
	       });
		
		
		JPanel aux = (JPanel) main.getCentro().getComponent(0);
		aux.add(botaoMenu);
		
		botaoMenuMini.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    		   main.setCompVisible("aeronave");
	    	   }
	       });
		botaoMenuMini.setVisible(true);
		
		
	}
}
