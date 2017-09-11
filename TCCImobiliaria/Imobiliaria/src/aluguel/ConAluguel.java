package aluguel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConAluguel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConAluguel frame = new ConAluguel();
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
	public ConAluguel() {
		setTitle("Consulta de Aluguel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 726, 84);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Pesquisar:");
		label.setBounds(10, 7, 168, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 23, 237, 20);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(308, 14, 351, 62);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Selecione o Modo de Consulta:");
		label_1.setBounds(10, 11, 236, 14);
		panel_1.add(label_1);
		
		JRadioButton rdbtnNomeDoLocatrio = new JRadioButton("Nome do Locat\u00E1rio");
		rdbtnNomeDoLocatrio.setBounds(189, 7, 156, 23);
		panel_1.add(rdbtnNomeDoLocatrio);
		
		JRadioButton rdbtnEndereoDoImvel = new JRadioButton("Endere\u00E7o do Im\u00F3vel");
		rdbtnEndereoDoImvel.setBounds(189, 35, 156, 23);
		panel_1.add(rdbtnEndereoDoImvel);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Parcela:");
		lblNewLabel.setBounds(10, 44, 193, 14);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 60, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 726, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Parcela", "Locat\u00E1rio", "Endere\u00E7o", "N\u00FAmero", "Bairro", "Complemento", "CEP", "Valor Aluguel", "Valor Bonifica\u00E7\u00E3o", "Acr\u00E9scimo", "Valor Final", "Data de Vencimento", "Situa\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setMinWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setMinWidth(90);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setMinWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(110);
		table.getColumnModel().getColumn(9).setMinWidth(110);
		table.getColumnModel().getColumn(12).setPreferredWidth(120);
		table.getColumnModel().getColumn(12).setMinWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(90);
		table.getColumnModel().getColumn(13).setMinWidth(90);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 287, 726, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_2.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_2.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/Basic-Minus-icon.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_2.add(button_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 335, 726, 60);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(ConAluguel.class.getResource("/Imagens/logout-icon.png")));
		button_4.setToolTipText("Sair");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		panel_3.add(button_4);
	}
}
