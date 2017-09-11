package vistoria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConVistoria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConVistoria frame = new ConVistoria();
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
	public ConVistoria() {
		setTitle("Consulta de Vistoria");
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
		
		JLabel lblPesquisarPorEndereo = new JLabel("Pesquisar por Endere\u00E7o:");
		lblPesquisarPorEndereo.setBounds(10, 11, 168, 14);
		panel.add(lblPesquisarPorEndereo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 237, 20);
		panel.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 726, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Endere\u00E7o", "N\u00FAmero", "Bairro", "Complemento", "CEP", "Data da Vistoria", "Vistoriador"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(110);
		table.getColumnModel().getColumn(7).setMinWidth(150);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 280, 726, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/Actions-go-first-view-icon.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/Actions-go-previous-view-icon.png")));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_1.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/Basic-Minus-icon.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/Actions-go-next-view-icon.png")));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/Actions-go-last-view-icon.png")));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 726, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(ConVistoria.class.getResource("/Imagens/logout-icon.png")));
		button_4.setToolTipText("Sair");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		panel_2.add(button_4);
	}

}
