package contratoLoc;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MovContratoLoc extends JFrame {

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
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovContratoLoc frame = new MovContratoLoc();
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
	public MovContratoLoc() {
		setTitle("Movimenta\u00E7\u00E3o de Contrato de Loca\u00E7\u00E3o");
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
		button.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 729, 344);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações Contrato", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 14, 46, 14);
		panel_1.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(165, 8, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 39, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(165, 70, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(165, 101, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(165, 132, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(165, 163, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(165, 194, 230, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label = new JLabel("Prazo para Reajuste:");
		label.setBounds(10, 45, 118, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Pr\u00F3ximo Reajuste:");
		label_1.setBounds(10, 76, 118, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u00CDnicio de Vig\u00EAncia:");
		label_2.setBounds(10, 107, 118, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Vencimento do Contrato:");
		label_3.setBounds(10, 138, 161, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Data de Assinatura:");
		label_4.setBounds(10, 169, 118, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Testemunha 1:");
		label_5.setBounds(10, 200, 101, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Testemunha 2:");
		label_6.setBounds(10, 231, 101, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Situa\u00E7\u00E3o do Contrato:");
		label_7.setBounds(10, 262, 161, 14);
		panel_1.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(165, 225, 230, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Finalizado", "Cancelado", "Rescindido"}));
		comboBox.setBounds(165, 256, 101, 20);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Locatário", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblCdigoLocatrio = new JLabel("C\u00F3digo Locat\u00E1rio:");
		lblCdigoLocatrio.setBounds(10, 17, 111, 14);
		panel_2.add(lblCdigoLocatrio);
		
		textField_8 = new JTextField();
		textField_8.setBounds(131, 11, 48, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(131, 42, 230, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNomeDoLocatrio = new JLabel("Nome:");
		lblNomeDoLocatrio.setBounds(10, 48, 111, 14);
		panel_2.add(lblNomeDoLocatrio);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(189, 11, 29, 20);
		panel_2.add(button_4);
		
		textField_10 = new JTextField();
		textField_10.setBounds(132, 73, 230, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(132, 104, 104, 20);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(131, 135, 105, 20);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(10, 79, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone Fixo:");
		lblNewLabel_1.setBounds(10, 110, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone Celular:");
		lblNewLabel_2.setBounds(10, 141, 111, 14);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Informações Imóvel", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblCdigoImvel = new JLabel("C\u00F3digo Im\u00F3vel:");
		lblCdigoImvel.setBounds(10, 17, 111, 14);
		panel_3.add(lblCdigoImvel);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(149, 11, 48, 20);
		panel_3.add(textField_13);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_5.setToolTipText("Pesquisar");
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(240, 240, 241));
		button_5.setBounds(207, 11, 29, 20);
		panel_3.add(button_5);
		
		textField_14 = new JTextField();
		textField_14.setBounds(149, 42, 230, 20);
		panel_3.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(149, 73, 48, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(149, 104, 147, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(149, 135, 147, 20);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(149, 166, 86, 20);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(149, 197, 48, 20);
		panel_3.add(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 48, 86, 14);
		panel_3.add(lblEndereo);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 79, 71, 14);
		panel_3.add(lblNmero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 110, 101, 14);
		panel_3.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 141, 46, 14);
		panel_3.add(lblBairro);
		
		JLabel lblValorDoAluguel = new JLabel("Valor do Aluguel:");
		lblValorDoAluguel.setBounds(10, 172, 111, 14);
		panel_3.add(lblValorDoAluguel);
		
		JLabel lblTaxaDeAdministrao = new JLabel("Taxa Administra\u00E7\u00E3o:");
		lblTaxaDeAdministrao.setBounds(10, 203, 136, 14);
		panel_3.add(lblTaxaDeAdministrao);
		
		textField_20 = new JTextField();
		textField_20.setBounds(149, 228, 86, 20);
		panel_3.add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblValorComBonificao = new JLabel("Valor com Bonifica\u00E7\u00E3o:");
		lblValorComBonificao.setBounds(10, 234, 136, 14);
		panel_3.add(lblValorComBonificao);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Informações Fiador", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblCdigoFiador = new JLabel("C\u00F3digo Fiador 1:");
		lblCdigoFiador.setBounds(10, 11, 110, 14);
		panel_5.add(lblCdigoFiador);
		
		textField_21 = new JTextField();
		textField_21.setBounds(110, 5, 86, 20);
		panel_5.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(110, 36, 230, 20);
		panel_5.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(110, 67, 110, 20);
		panel_5.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(110, 98, 110, 20);
		panel_5.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(110, 129, 230, 20);
		panel_5.add(textField_25);
		textField_25.setColumns(10);
		
		JLabel lblNomeFiador = new JLabel("Nome:");
		lblNomeFiador.setBounds(10, 42, 110, 14);
		panel_5.add(lblNomeFiador);
		
		JLabel lblTelefoneFixoFiador = new JLabel("Telefone Fixo:");
		lblTelefoneFixoFiador.setBounds(10, 73, 143, 14);
		panel_5.add(lblTelefoneFixoFiador);
		
		JLabel lblTelefoneCelularFiador = new JLabel("Telefone Celular:");
		lblTelefoneCelularFiador.setBounds(10, 104, 143, 14);
		panel_5.add(lblTelefoneCelularFiador);
		
		JLabel lblEmailFiador = new JLabel("Email:");
		lblEmailFiador.setBounds(10, 135, 125, 14);
		panel_5.add(lblEmailFiador);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_6.setToolTipText("Pesquisar");
		button_6.setOpaque(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(240, 240, 241));
		button_6.setBounds(206, 5, 29, 20);
		panel_5.add(button_6);
		
		JLabel lblCdigoFiador_1 = new JLabel("C\u00F3digo Fiador 3:");
		lblCdigoFiador_1.setBounds(378, 11, 110, 14);
		panel_5.add(lblCdigoFiador_1);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(478, 5, 86, 20);
		panel_5.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(478, 36, 230, 20);
		panel_5.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(478, 67, 110, 20);
		panel_5.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(478, 98, 110, 20);
		panel_5.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(478, 129, 230, 20);
		panel_5.add(textField_30);
		
		JLabel label_9 = new JLabel("Nome:");
		label_9.setBounds(378, 42, 110, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Telefone Fixo:");
		label_10.setBounds(378, 73, 143, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Telefone Celular:");
		label_11.setBounds(378, 104, 143, 14);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Email:");
		label_12.setBounds(378, 135, 125, 14);
		panel_5.add(label_12);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_7.setToolTipText("Pesquisar");
		button_7.setOpaque(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(240, 240, 241));
		button_7.setBounds(574, 5, 29, 20);
		panel_5.add(button_7);
		
		JLabel lblCdigoFiador_2 = new JLabel("C\u00F3digo Fiador 2:");
		lblCdigoFiador_2.setBounds(10, 166, 110, 14);
		panel_5.add(lblCdigoFiador_2);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(110, 160, 86, 20);
		panel_5.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(110, 191, 230, 20);
		panel_5.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(110, 222, 110, 20);
		panel_5.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(110, 253, 110, 20);
		panel_5.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(110, 284, 230, 20);
		panel_5.add(textField_35);
		
		JLabel label_13 = new JLabel("Nome:");
		label_13.setBounds(10, 197, 110, 14);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Telefone Fixo:");
		label_14.setBounds(10, 228, 143, 14);
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("Telefone Celular:");
		label_15.setBounds(10, 259, 143, 14);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("Email:");
		label_16.setBounds(10, 290, 125, 14);
		panel_5.add(label_16);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_8.setToolTipText("Pesquisar");
		button_8.setOpaque(false);
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(240, 240, 241));
		button_8.setBounds(206, 160, 29, 20);
		panel_5.add(button_8);
		
		JLabel lblCdigoFiador_3 = new JLabel("C\u00F3digo Fiador 4:");
		lblCdigoFiador_3.setBounds(378, 166, 110, 14);
		panel_5.add(lblCdigoFiador_3);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(478, 160, 86, 20);
		panel_5.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(478, 191, 230, 20);
		panel_5.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(478, 222, 110, 20);
		panel_5.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(478, 253, 110, 20);
		panel_5.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(478, 284, 230, 20);
		panel_5.add(textField_40);
		
		JLabel label_17 = new JLabel("Nome:");
		label_17.setBounds(378, 197, 110, 14);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("Telefone Fixo:");
		label_18.setBounds(378, 228, 143, 14);
		panel_5.add(label_18);
		
		JLabel label_19 = new JLabel("Telefone Celular:");
		label_19.setBounds(378, 259, 143, 14);
		panel_5.add(label_19);
		
		JLabel label_20 = new JLabel("Email:");
		label_20.setBounds(378, 290, 125, 14);
		panel_5.add(label_20);
		
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(MovContratoLoc.class.getResource("/Imagens/Zoom-icon.png")));
		button_9.setToolTipText("Pesquisar");
		button_9.setOpaque(false);
		button_9.setFocusPainted(false);
		button_9.setBackground(new Color(240, 240, 241));
		button_9.setBounds(574, 160, 29, 20);
		panel_5.add(button_9);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Informações Adicionais", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 11, 94, 14);
		panel_4.add(lblObservaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 704, 116);
		panel_4.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblClusulasAdicionais = new JLabel("Cl\u00E1usulas Adicionais:");
		lblClusulasAdicionais.setBounds(10, 164, 152, 14);
		panel_4.add(lblClusulasAdicionais);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 189, 704, 116);
		panel_4.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
	}
}
