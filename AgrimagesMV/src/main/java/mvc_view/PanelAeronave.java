package mvc_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

public class PanelAeronave extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JDialog configuracao;
	private final JPanel contentPanel ;
	private JTextField textNome;
	private JTextField textNumMotor;
	private JTextField textMassa;
	private JTextArea textObservacao;
	private JComboBox comboBox;
		/**
	 * Create the panel.
	 */

public void AddAeronave(){ 
        
        DefaultTableModel modelo= (DefaultTableModel) table.getModel();
        modelo.addRow(new Object[]{textNome.getText(),
                				   textNumMotor.getText(), 
                				   textMassa.getText(),
                				   textObservacao.getText(),
                				   (String)comboBox.getSelectedItem()
        }); 
    } 
	
	
	public PanelAeronave() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		configuracao = new JDialog();
		contentPanel = new JPanel();
		
		configuracao.setTitle("Cadastro de Aeronaves");
		configuracao.setBounds(100, 100, 499, 300);
		configuracao.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		configuracao.getContentPane().add(contentPanel, BorderLayout.CENTER);
		configuracao.setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Modelo", "Nº de Motores", "Massa", "Fabricante", "Observações"  
			}
		));
		table.setBounds(0, 0, 144, 200);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		
		JButton button = new JButton("Novo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAeronaveActionListener(arg0);
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("Editar");
		panel.add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		panel.add(button_2);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBounds(0, 0, 483, 224);
		contentPanel.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblCadastroAeronave = new JLabel("Cadastro Aeronave");
		lblCadastroAeronave.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblCadastroAeronave.setBounds(152, 11, 173, 14);
		panel1.add(lblCadastroAeronave);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblModelo.setBounds(33, 58, 70, 14);
		panel1.add(lblModelo);
		
		textNome = new JTextField();
		textNome.setBorder(new LineBorder(Color.BLACK));
		textNome.setBounds(33, 83, 213, 20);
		panel1.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNDeMotores = new JLabel("Nº de motores");
		lblNDeMotores.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNDeMotores.setBounds(271, 58, 94, 14);
		panel1.add(lblNDeMotores);
		
		textNumMotor = new JTextField();
		textNumMotor.setBorder(new LineBorder(Color.BLACK));
		textNumMotor.setBounds(269, 83, 86, 20);
		panel1.add(textNumMotor);
		textNumMotor.setColumns(10);
		
		JLabel lblMassag = new JLabel("Massa (g)");
		lblMassag.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblMassag.setBounds(384, 58, 87, 14);
		panel1.add(lblMassag);
		
		textMassa = new JTextField();
		textMassa.setBorder(new LineBorder(Color.BLACK));
		textMassa.setBounds(385, 83, 86, 20);
		panel1.add(textMassa);
		textMassa.setColumns(10);
		
		JLabel lblObservaes = new JLabel("Observações");
		lblObservaes.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblObservaes.setBounds(33, 130, 103, 14);
		panel1.add(lblObservaes);
		
		textObservacao = new JTextArea();
		textObservacao.setBorder(new LineBorder(new Color(0, 0, 0)));
		textObservacao.setBounds(33, 155, 213, 47);
		panel1.add(textObservacao);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblFabricante.setBounds(273, 130, 103, 14);
		panel1.add(lblFabricante);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione um fabricante", "SenseFlw", "SkyDrone", "Trimble"}));
		comboBox.setBounds(273, 156, 189, 20);
		panel1.add(comboBox);
		
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		configuracao.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Salvar");
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
		
	}
	private void configActionListener(java.awt.event.ActionEvent evt) {
		AddAeronave();
	}
	private void addAeronaveActionListener(java.awt.event.ActionEvent evt) {
		configuracao.setVisible(true);
	}
}
