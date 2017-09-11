package renovacao;

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

public class MovRenovacao extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovRenovacao frame = new MovRenovacao();
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
	public MovRenovacao() {
		setTitle("Movimenta\u00E7\u00E3o de Renova\u00E7\u00E3o de Contrato de Loca\u00E7\u00E3o");
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
		button.setIcon(new ImageIcon(MovRenovacao.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovRenovacao.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovRenovacao.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovRenovacao.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 726, 344);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações da Renovação", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 42, 42, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 73, 42, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 104, 86, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 135, 86, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 166, 86, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 197, 42, 20);
		panel_1.add(textField_5);
		
		JLabel lblCdigoContratoLocao = new JLabel("C\u00F3digo Contrato Loca\u00E7\u00E3o:");
		lblCdigoContratoLocao.setBounds(10, 48, 189, 14);
		panel_1.add(lblCdigoContratoLocao);
		
		JLabel lblPrazoReajuste = new JLabel("Prazo Reajuste:");
		lblPrazoReajuste.setBounds(10, 79, 118, 14);
		panel_1.add(lblPrazoReajuste);
		
		JLabel lblPrximoReajuste = new JLabel("Pr\u00F3ximo Reajuste:");
		lblPrximoReajuste.setBounds(10, 110, 118, 14);
		panel_1.add(lblPrximoReajuste);
		
		JLabel lblnicioDeVigncia = new JLabel("\u00CDnicio de Vig\u00EAncia:");
		lblnicioDeVigncia.setBounds(10, 141, 161, 14);
		panel_1.add(lblnicioDeVigncia);
		
		JLabel lblVencimento = new JLabel("Vencimento:");
		lblVencimento.setBounds(10, 172, 118, 14);
		panel_1.add(lblVencimento);
		
		JLabel lblDataDeAssinatura = new JLabel("Porcentagem do Reajuste:");
		lblDataDeAssinatura.setBounds(10, 203, 177, 14);
		panel_1.add(lblDataDeAssinatura);
		
		JLabel lblPorcentagemDoReajuste = new JLabel("Data de Assinatura:");
		lblPorcentagemDoReajuste.setBounds(10, 234, 161, 14);
		panel_1.add(lblPorcentagemDoReajuste);
		
		JLabel label_8 = new JLabel("Situa\u00E7\u00E3o do Contrato:");
		label_8.setBounds(10, 265, 161, 14);
		panel_1.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(165, 228, 86, 20);
		panel_1.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Cancelado", "Finalizado"}));
		comboBox.setBounds(165, 259, 101, 20);
		panel_1.add(comboBox);
		
		textField_7 = new JTextField();
		textField_7.setBounds(165, 11, 41, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovRenovacao.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(219, 42, 29, 20);
		panel_1.add(button_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(393, 11, 302, 20);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(393, 42, 302, 20);
		panel_1.add(textField_9);
		
		JLabel lblTestemunha = new JLabel("Testemunha 1:");
		lblTestemunha.setBounds(298, 17, 125, 14);
		panel_1.add(lblTestemunha);
		
		JLabel lblTestemunha_1 = new JLabel("Testemunha 2:");
		lblTestemunha_1.setBounds(298, 48, 125, 14);
		panel_1.add(lblTestemunha_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Adicionais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 17, 99, 14);
		panel_2.add(lblObservaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 701, 263);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
	}
}
