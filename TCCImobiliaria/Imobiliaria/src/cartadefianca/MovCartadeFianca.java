package cartadefianca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MovCartadeFianca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovCartadeFianca frame = new MovCartadeFianca();
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
	public MovCartadeFianca() {
		setTitle("Movimenta\u00E7\u00E3o de Carta de Fian\u00E7a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 344, 694, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MovCartadeFianca.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovCartadeFianca.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovCartadeFianca.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovCartadeFianca.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 342);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações da Carta de Fiança", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(179, 11, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 17, 46, 14);
		panel_1.add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 42, 46, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 73, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Cancelado", "Finalizado"}));
		comboBox.setBounds(179, 104, 112, 20);
		panel_1.add(comboBox);
		
		JLabel lblCdigoContratoDe = new JLabel("C\u00F3digo Contrato de Loca\u00E7\u00E3o:");
		lblCdigoContratoDe.setBounds(10, 48, 194, 14);
		panel_1.add(lblCdigoContratoDe);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 76, 46, 14);
		panel_1.add(lblData);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(10, 110, 86, 14);
		panel_1.add(lblSituao);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovCartadeFianca.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(236, 42, 29, 20);
		panel_1.add(button_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cláusulas Adicionais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Cl\u00E1usulas Adicionais:");
		label.setBounds(10, 11, 151, 14);
		panel_2.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 669, 270);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
