package prestadordeservico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class CadPS extends JFrame {

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
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_9;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPS frame = new CadPS();
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
	public CadPS() {
		setTitle("Cadastro de Prestador de Servi\u00E7os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 345, 694, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnSalvar = new JButton("");
		
		btnSalvar.setIcon(new ImageIcon(CadPS.class.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(240, 240, 241));
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(CadPS.class.getResource("/Imagens/Button-Close-icon.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(240, 240, 241));
		panel.add(btnCancelar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(CadPS.class.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(CadPS.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel.add(btnSair);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 347);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações Pessoais", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(10, 67, 46, 14);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(104, 61, 226, 20);
		panel_1.add(textField);
		
		JLabel label_2 = new JLabel("Endere\u00E7o:");
		label_2.setBounds(10, 92, 62, 14);
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 86, 226, 20);
		panel_1.add(textField_1);
		
		JLabel label_3 = new JLabel("N\u00FAmero:");
		label_3.setBounds(10, 117, 86, 14);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 111, 54, 20);
		panel_1.add(textField_2);
		
		JLabel label_4 = new JLabel("Complemento:");
		label_4.setBounds(10, 142, 86, 14);
		panel_1.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(104, 136, 226, 20);
		panel_1.add(textField_3);
		
		JLabel label_5 = new JLabel("Telefone Fixo:");
		label_5.setBounds(10, 232, 86, 14);
		panel_1.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 166, 226, 20);
		panel_1.add(textField_4);
		
		JLabel label_6 = new JLabel("Celular:");
		label_6.setBounds(10, 263, 46, 14);
		panel_1.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 226, 165, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(104, 288, 165, 20);
		panel_1.add(textField_6);
		
		JLabel label_7 = new JLabel("Bairro:");
		label_7.setBounds(10, 172, 46, 14);
		panel_1.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(104, 257, 165, 20);
		panel_1.add(textField_7);
		
		JLabel label_8 = new JLabel("Profiss\u00E3o:");
		label_8.setBounds(10, 294, 62, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Tipo Pessoa:");
		label_9.setBounds(10, 42, 74, 14);
		panel_1.add(label_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		comboBox.setBounds(104, 36, 87, 20);
		panel_1.add(comboBox);
		
		JLabel label_10 = new JLabel("CPF:");
		label_10.setBounds(361, 17, 46, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("RG:");
		label_11.setBounds(361, 42, 46, 14);
		panel_1.add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(457, 36, 132, 20);
		panel_1.add(textField_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(457, 61, 86, 20);
		panel_1.add(textField_10);
		
		JLabel label_13 = new JLabel("Data Expedi\u00E7\u00E3o:");
		label_13.setBounds(361, 67, 97, 14);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("CNPJ:");
		label_14.setBounds(361, 117, 46, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("Raz\u00E3o Social:");
		label_15.setBounds(361, 142, 97, 14);
		panel_1.add(label_15);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(457, 111, 132, 20);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(457, 136, 206, 20);
		panel_1.add(textField_12);
		
		JLabel label_17 = new JLabel("Email:");
		label_17.setBounds(10, 201, 46, 14);
		panel_1.add(label_17);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(104, 195, 86, 20);
		panel_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(104, 11, 86, 20);
		panel_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(457, 11, 132, 20);
		panel_1.add(textField_15);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(361, 201, 46, 14);
		panel_1.add(lblFuno);
		
		textField_9 = new JTextField();
		textField_9.setBounds(457, 195, 206, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(361, 232, 86, 14);
		panel_1.add(lblObservaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(456, 232, 207, 76);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Comerciais", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(156, 11, 257, 20);
		panel_2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(156, 36, 43, 20);
		panel_2.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(156, 61, 188, 20);
		panel_2.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(156, 86, 188, 20);
		panel_2.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(156, 111, 188, 20);
		panel_2.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(156, 136, 98, 20);
		panel_2.add(textField_21);
		
		JLabel label_12 = new JLabel("N\u00FAmero Comercial:");
		label_12.setBounds(10, 42, 115, 14);
		panel_2.add(label_12);
		
		JLabel label_16 = new JLabel("Bairro Comercial:");
		label_16.setBounds(10, 92, 115, 14);
		panel_2.add(label_16);
		
		JLabel label_18 = new JLabel("Empresa:");
		label_18.setBounds(10, 117, 115, 14);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel("Telefone Comercial:");
		label_19.setBounds(10, 142, 115, 14);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("Complemento Comercial:");
		label_20.setBounds(10, 67, 153, 14);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("Endere\u00E7o Comercial:");
		label_21.setBounds(10, 17, 128, 14);
		panel_2.add(label_21);
	}
}
