package contratoadm;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MovContratoAdm extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovContratoAdm frame = new MovContratoAdm();
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
	public MovContratoAdm() {
		setTitle("Movimenta\u00E7\u00E3o de Contrado de Administra\u00E7\u00E3o");
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
		button.setIcon(new ImageIcon(MovContratoAdm.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovContratoAdm.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovContratoAdm.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovContratoAdm.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 344);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações do Contrato", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel_1.add(lblCdigo);
		
		JLabel lblCdigoDoImvel = new JLabel("C\u00F3digo do Im\u00F3vel:");
		lblCdigoDoImvel.setBounds(10, 36, 103, 14);
		panel_1.add(lblCdigoDoImvel);
		
		JLabel lblCdigoDoProprietrio = new JLabel("Endere\u00E7o:");
		lblCdigoDoProprietrio.setBounds(10, 61, 76, 14);
		panel_1.add(lblCdigoDoProprietrio);
		
		JLabel lblNomeDoProprietrio = new JLabel("N\u00FAmero:");
		lblNomeDoProprietrio.setBounds(10, 86, 82, 14);
		panel_1.add(lblNomeDoProprietrio);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 111, 103, 14);
		panel_1.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 136, 46, 14);
		panel_1.add(lblBairro);
		
		JLabel lblCdigoDoProprietrio_1 = new JLabel("Valor do Aluguel:");
		lblCdigoDoProprietrio_1.setBounds(10, 161, 131, 14);
		panel_1.add(lblCdigoDoProprietrio_1);
		
		JLabel lblNomeDoProprietrio_1 = new JLabel("Taxa de Administra\u00E7\u00E3o:");
		lblNomeDoProprietrio_1.setBounds(10, 186, 145, 14);
		panel_1.add(lblNomeDoProprietrio_1);
		
		JLabel lblValorDoAluguel = new JLabel("C\u00F3digo do Propriet\u00E1rio:");
		lblValorDoAluguel.setBounds(10, 211, 131, 14);
		panel_1.add(lblValorDoAluguel);
		
		JLabel lblNomeDoProprietrio_2 = new JLabel("Nome do Propriet\u00E1rio:");
		lblNomeDoProprietrio_2.setBounds(10, 236, 131, 14);
		panel_1.add(lblNomeDoProprietrio_2);
		
		textField = new JTextField();
		textField.setBounds(154, 5, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 30, 46, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(154, 55, 281, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(154, 80, 46, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(154, 105, 168, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(154, 130, 168, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(154, 155, 86, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(154, 180, 46, 20);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(154, 205, 46, 20);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(154, 230, 281, 20);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("Situa\u00E7\u00E3o da Assinatura:");
		lblNewLabel.setBounds(10, 261, 145, 14);
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Cancelado", "Finalizado"}));
		comboBox.setBounds(154, 255, 113, 20);
		panel_1.add(comboBox);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(MovContratoAdm.class.getResource("/Imagens/Zoom-icon.png")));
		btnPesquisar.setOpaque(false);
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setBackground(new Color(240, 240, 241));
		btnPesquisar.setBounds(210, 30, 29, 20);
		panel_1.add(btnPesquisar);
		
		JLabel label = new JLabel("Data de Assinatura:");
		label.setBounds(10, 284, 131, 14);
		panel_1.add(label);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(154, 279, 86, 20);
		panel_1.add(textField_10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cláusulas Adicionais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblClusulasAdicionais = new JLabel("Cl\u00E1usulas Adicionais:");
		lblClusulasAdicionais.setBounds(10, 11, 142, 14);
		panel_2.add(lblClusulasAdicionais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 669, 269);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
