package vistoriacomodos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class CadVistoriaComodos extends JFrame {

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
					CadVistoriaComodos frame = new CadVistoriaComodos();
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
	public CadVistoriaComodos() {
		setTitle("Cadastro de C\u00F4modos de uma Vistoria");
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
		button.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 726, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigoDaVistoria = new JLabel("C\u00F3digo da Vistoria:");
		lblCdigoDaVistoria.setBounds(10, 13, 122, 14);
		panel_1.add(lblCdigoDaVistoria);
		
		textField = new JTextField();
		textField.setBounds(126, 7, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 38, 46, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCdigoDoCmodo = new JLabel("C\u00F3digo do C\u00F4modo:");
		lblCdigoDoCmodo.setBounds(10, 44, 150, 14);
		panel_1.add(lblCdigoDoCmodo);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(182, 7, 29, 20);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(182, 38, 29, 20);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/Files-New-File-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(221, 38, 29, 20);
		panel_1.add(button_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 69, 179, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCmodo = new JLabel("C\u00F4modo:");
		lblCmodo.setBounds(10, 75, 69, 14);
		panel_1.add(lblCmodo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(323, 13, 84, 14);
		panel_1.add(lblDescrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 38, 393, 106);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 155, 726, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/table-row-insert-icon.png")));
		button_7.setToolTipText("Salvar");
		button_7.setOpaque(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(240, 240, 241));
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(CadVistoriaComodos.class.getResource("/Imagens/table-row-delete-icon.png")));
		button_8.setToolTipText("Deletar");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		panel_2.add(button_8);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 206, 726, 137);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"C\u00F3digo do C\u00F4modo", "C\u00F4modo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		scrollPane_1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}
