package mvc_view;

import javax.swing.JPanel;


public class PanelCamera extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/**
	 * Create the panel.
	 */

	
	public PanelCamera(){
		String [] colunas = new String []{"Nome", "Fabricante", "Resolução", "Distancia Focal", "Sensor"};
		Panel panel = new Panel(colunas) {};
		
		
		}
}
