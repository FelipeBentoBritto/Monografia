package repasse;

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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class MovRepasse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovRepasse frame = new MovRepasse();
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
	public MovRepasse() {
		setTitle("Movimenta\u00E7\u00E3o de Repasse");
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
		button.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 726, 343);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações do Repasse", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(178, 11, 46, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(178, 42, 46, 20);
		panel_1.add(textField_1);
		
		JLabel lblCdigoAluguel = new JLabel("C\u00F3digo do Aluguel:");
		lblCdigoAluguel.setBounds(10, 48, 156, 14);
		panel_1.add(lblCdigoAluguel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 104, 217, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 135, 217, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 166, 46, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 197, 105, 20);
		panel_1.add(textField_5);
		
		JLabel label_2 = new JLabel("Nome do Propriet\u00E1rio:");
		label_2.setBounds(10, 110, 132, 14);
		panel_1.add(label_2);
		
		JLabel lblEndereoDoImvel = new JLabel("Endere\u00E7o do Im\u00F3vel:");
		lblEndereoDoImvel.setBounds(10, 141, 132, 14);
		panel_1.add(lblEndereoDoImvel);
		
		JLabel lblNmeroDoImvel = new JLabel("N\u00FAmero do Im\u00F3vel:");
		lblNmeroDoImvel.setBounds(10, 172, 132, 14);
		panel_1.add(lblNmeroDoImvel);
		
		JLabel lblDataDoPrimeiro = new JLabel("Data do Primeiro Repasse:");
		lblDataDoPrimeiro.setBounds(10, 203, 169, 14);
		panel_1.add(lblDataDoPrimeiro);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(234, 42, 29, 20);
		panel_1.add(button_4);
		
		JLabel lblCdigoDoProprietrio = new JLabel("C\u00F3digo do Propriet\u00E1rio:");
		lblCdigoDoProprietrio.setBounds(10, 79, 132, 14);
		panel_1.add(lblCdigoDoProprietrio);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(178, 73, 46, 20);
		panel_1.add(textField_6);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações da Manutenção", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("C\u00F3digo Manuten\u00E7\u00E3o:");
		label_1.setBounds(10, 17, 140, 15);
		panel_2.add(label_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(164, 11, 59, 20);
		panel_2.add(textField_7);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(233, 11, 29, 20);
		panel_2.add(button_5);
		
		JLabel label_3 = new JLabel("Valor da Manuten\u00E7\u00E3o:");
		label_3.setBounds(10, 48, 140, 14);
		panel_2.add(label_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(164, 42, 59, 20);
		panel_2.add(textField_8);
		
		JLabel label_4 = new JLabel("Descri\u00E7\u00E3o Manuten\u00E7\u00E3o:");
		label_4.setBounds(10, 108, 152, 14);
		panel_2.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 252, 110);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblParcelaDoRepasse = new JLabel("Parcela do Repasse:");
		lblParcelaDoRepasse.setBounds(10, 79, 126, 14);
		panel_2.add(lblParcelaDoRepasse);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(164, 73, 59, 20);
		panel_2.add(textField_9);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Zoom-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(233, 73, 29, 20);
		panel_2.add(button_6);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Valor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_5 = new JLabel("Valor do Aluguel:");
		label_5.setBounds(10, 17, 125, 14);
		panel_3.add(label_5);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(154, 11, 86, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(154, 42, 54, 20);
		panel_3.add(textField_11);
		
		JLabel lblTaxaDeAdministrao = new JLabel("Taxa de Administra\u00E7\u00E3o:");
		lblTaxaDeAdministrao.setBounds(10, 48, 141, 14);
		panel_3.add(lblTaxaDeAdministrao);
		
		textField_12 = new JTextField();
		textField_12.setBounds(154, 73, 86, 20);
		panel_3.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblValorDoRepasse = new JLabel("Valor do Repasse:");
		lblValorDoRepasse.setBounds(10, 79, 125, 14);
		panel_3.add(lblValorDoRepasse);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Parcelas", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label_6 = new JLabel("Parcelas:");
		label_6.setBounds(10, 20, 78, 14);
		panel_4.add(label_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 49, 701, 221);
		panel_4.add(scrollPane_1);
		
		table = new JTable();
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
				"Parcela", "Data de Repasse", "Valor do Aluguel", "Valor do Repasse", "Decr\u00E9scimo", "Valor Total", "Situa\u00E7\u00E3o", "Descri\u00E7\u00E3o da Manuten\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setMinWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setMinWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setMinWidth(250);
		scrollPane_1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		
		JLabel label_7 = new JLabel("Situa\u00E7\u00E3o:");
		label_7.setBounds(10, 285, 62, 14);
		panel_4.add(label_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Pago", "Atrasado"}));
		comboBox.setBounds(80, 279, 153, 20);
		panel_4.add(comboBox);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/Text-align-right-icon.png")));
		button_7.setToolTipText("Visualizar Aluguel");
		button_7.setOpaque(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(240, 240, 241));
		button_7.setBounds(618, 11, 35, 35);
		panel_4.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(MovRepasse.class.getResource("/Imagens/print-icon.png")));
		button_8.setToolTipText("Imprimir Aluguel");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		button_8.setBounds(673, 11, 35, 35);
		panel_4.add(button_8);
	}
}
