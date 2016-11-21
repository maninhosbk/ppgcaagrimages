package mvc_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Panel {

	public Panel(String[] test) {
		JPanel panelPrinc = new JPanel();
		Vector<String> vetor = new Vector<String>(Arrays.asList(test));
		panelPrinc.setBackground(Color.WHITE);
		panelPrinc.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelPrinc.add(scrollPane);

		JTable table = new JTable();
		table.setModel(new DefaultTableModel(vetor, 0));
		table.setBounds(0, 0, 144, 200);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panelPrinc.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 10));

		JButton button = new JButton("Novo");
		panel.add(button);

		JButton button_1 = new JButton("Editar");
		panel.add(button_1);

		JButton button_2 = new JButton("Excluir");
		panel.add(button_2);

	}

}
