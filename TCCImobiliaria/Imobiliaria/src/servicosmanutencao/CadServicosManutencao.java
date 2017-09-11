package servicosmanutencao;

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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class CadServicosManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadServicosManutencao frame = new CadServicosManutencao();
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
	public CadServicosManutencao() {
		setTitle("Cadastro de Servi\u00E7os de uma Manuten\u00E7\u00E3o");
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
		button.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 726, 135);
		contentPane.add(panel_1);
		
		JLabel lblCdigoDaManuteno = new JLabel("C\u00F3digo da Manuten\u00E7\u00E3o:");
		lblCdigoDaManuteno.setBounds(10, 17, 203, 14);
		panel_1.add(lblCdigoDaManuteno);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 11, 86, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 42, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 73, 86, 20);
		panel_1.add(textField_2);
		
		JLabel label_1 = new JLabel("C\u00F3digo do Servi\u00E7o:");
		label_1.setBounds(10, 48, 129, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Valor do Servi\u00E7o:");
		label_2.setBounds(10, 79, 142, 14);
		panel_1.add(label_2);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(254, 11, 29, 20);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(254, 42, 29, 20);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(293, 42, 29, 20);
		panel_1.add(button_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 104, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 110, 142, 14);
		panel_1.add(lblValorTotal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Pago", "Cancelado"}));
		comboBox.setBounds(492, 73, 122, 20);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Situa\u00E7\u00E3o do Pagamento:");
		lblNewLabel.setBounds(346, 79, 188, 14);
		panel_1.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(492, 104, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Em Aberto:");
		lblNewLabel_1.setBounds(346, 110, 122, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(346, 17, 98, 14);
		panel_1.add(lblEndereo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(492, 11, 224, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(346, 48, 76, 14);
		panel_1.add(lblNmero);
		
		textField_6 = new JTextField();
		textField_6.setBounds(492, 42, 46, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 135, 726, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/table-row-insert-icon.png")));
		button_7.setToolTipText("Salvar");
		button_7.setOpaque(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(240, 240, 241));
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(CadServicosManutencao.class.getResource("/Imagens/table-row-delete-icon.png")));
		button_8.setToolTipText("Deletar");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		panel_2.add(button_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 186, 726, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo Servi\u00E7o", "Descri\u00E7\u00E3o do Servi\u00E7o", "C\u00F3digo Prestador Servi\u00E7o", "Nome Prestador de Servi\u00E7o", "Valor do Servi\u00E7o", "Pagamento"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setMinWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setMinWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}
