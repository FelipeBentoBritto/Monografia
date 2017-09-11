package aluguel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class MovAluguel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovAluguel frame = new MovAluguel();
					frame.setVisible(true);
					for (UIManager.LookAndFeelInfo lnf : UIManager.getInstalledLookAndFeels()) {
						if ("Metal".equals(lnf.getName())) {
							UIManager.setLookAndFeel(lnf.getClassName());
							break;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MovAluguel() {
		setTitle("Movimenta\u00E7\u00E3o de Aluguel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 344, 726, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 726, 343);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações do Aluguel", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel_1.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(178, 5, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 36, 46, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCdigoContratoLocao = new JLabel("C\u00F3digo Contrato Loca\u00E7\u00E3o:");
		lblCdigoContratoLocao.setBounds(10, 42, 156, 14);
		panel_1.add(lblCdigoContratoLocao);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 67, 217, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 98, 217, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(178, 129, 217, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(178, 160, 46, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(178, 191, 86, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Propriet\u00E1rio:");
		lblNewLabel_1.setBounds(10, 73, 132, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do Locat\u00E1rio:");
		lblNewLabel_2.setBounds(10, 104, 132, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o do Im\u00F3vel:");
		lblNewLabel_3.setBounds(10, 135, 132, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero do Im\u00F3vel:");
		lblNewLabel_4.setBounds(10, 166, 132, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data do Primeiro Aluguel:");
		lblNewLabel_5.setBounds(10, 197, 144, 14);
		panel_1.add(lblNewLabel_5);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(234, 36, 29, 20);
		panel_1.add(button_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações da Manutenção", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo Manuten\u00E7\u00E3o:");
		lblNewLabel.setBounds(10, 11, 140, 15);
		panel_2.add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.setBounds(164, 5, 59, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(233, 5, 29, 20);
		panel_2.add(button_5);
		
		JLabel lblValorDaManuteno = new JLabel("Valor da Manuten\u00E7\u00E3o:");
		lblValorDaManuteno.setBounds(10, 42, 140, 14);
		panel_2.add(lblValorDaManuteno);
		
		textField_8 = new JTextField();
		textField_8.setBounds(164, 36, 59, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDescrioDaManuteno = new JLabel("Descri\u00E7\u00E3o Manuten\u00E7\u00E3o:");
		lblDescrioDaManuteno.setBounds(10, 102, 152, 14);
		panel_2.add(lblDescrioDaManuteno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 127, 252, 110);
		panel_2.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblParcelaDoAluguel = new JLabel("Parcela do Aluguel:");
		lblParcelaDoAluguel.setBounds(10, 73, 126, 14);
		panel_2.add(lblParcelaDoAluguel);
		
		textField_9 = new JTextField();
		textField_9.setBounds(164, 67, 59, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Zoom-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(233, 67, 29, 20);
		panel_2.add(button_6);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Valor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Valor do Aluguel:");
		lblNewLabel_6.setBounds(10, 11, 125, 14);
		panel_3.add(lblNewLabel_6);
		
		textField_10 = new JTextField();
		textField_10.setBounds(139, 5, 86, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(139, 36, 86, 20);
		panel_3.add(textField_11);
		
		JLabel lblNewLabel_7 = new JLabel("Valor da Bonifica\u00E7\u00E3o:");
		lblNewLabel_7.setBounds(10, 42, 125, 14);
		panel_3.add(lblNewLabel_7);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Parcelas", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(10, 11, 78, 14);
		panel_4.add(lblParcelas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 40, 701, 221);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Parcela", "Data de Vencimento", "Valor Com Bonifica\u00E7\u00E3o", "Valor Sem Bonifica\u00E7\u00E3o", "Acr\u00E9scimo", "Valor Total", "Situa\u00E7\u00E3o", "Descri\u00E7\u00E3o da Manuten\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setMinWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setMinWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setMinWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setMinWidth(250);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(10, 276, 62, 14);
		panel_4.add(lblSituao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Recebido", "Atrasado"}));
		comboBox.setBounds(80, 270, 153, 20);
		panel_4.add(comboBox);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/Text-align-right-icon.png")));
		button_7.setToolTipText("Visualizar Aluguel");
		button_7.setOpaque(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(240, 240, 241));
		button_7.setBounds(618, 2, 35, 35);
		panel_4.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(MovAluguel.class.getResource("/Imagens/print-icon.png")));
		button_8.setToolTipText("Imprimir Aluguel");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		button_8.setBounds(673, 2, 35, 35);
		panel_4.add(button_8);
	}
}
