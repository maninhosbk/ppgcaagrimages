package mvc_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PanelFabricante extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
		/**
	 * Create the panel.
	 */

	
	public PanelFabricante() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Localização", "Telefone", "E-mail"  
			}
		));
		table.setBounds(0, 0, 144, 200);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		
		JButton button = new JButton("Novo");
		panel.add(button);
		
		JButton button_1 = new JButton("Editar");
		panel.add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		panel.add(button_2);
		
	}
}