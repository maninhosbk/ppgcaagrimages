package mvc_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelAreaEstudo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;

	public PanelAreaEstudo() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setAutoscrolls(true);
		add(tabbedPane);
		tabbedPane.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		
		JPanel fazenda = new JPanel();
		fazenda.setBorder(new LineBorder(new Color(0, 0, 0)));
		fazenda.setBackground(Color.WHITE);
		tabbedPane.addTab("FAZENDA", null, fazenda, null);
		fazenda.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		fazenda.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome" , "Responsável", "Município/Localidade"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		fazenda.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton btnNovaFazenda = new JButton("Nova Área");
		panel.add(btnNovaFazenda);
		
		JButton btnEditarFazenda = new JButton("Editar Área");
		panel.add(btnEditarFazenda);
		
		JButton btnExcluir = new JButton("Excluir Área");
		panel.add(btnExcluir);

		JPanel areaexperimental = new JPanel();
		areaexperimental.setBackground(Color.WHITE);
		areaexperimental.setBorder(new LineBorder(new Color(0, 0, 0)));
		areaexperimental.setEnabled(false);
		tabbedPane.addTab("ÁREA EXPERIMENTAL", null, areaexperimental, null);
		areaexperimental.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		areaexperimental.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		areaexperimental.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton button = new JButton("Nova Fazenda");
		panel_1.add(button);
		
		JButton button_1 = new JButton("Editar Fazenda");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Excluir Fazenda");
		panel_1.add(button_2);


	}
}
