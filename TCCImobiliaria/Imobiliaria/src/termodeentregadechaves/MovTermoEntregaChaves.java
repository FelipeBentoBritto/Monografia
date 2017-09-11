package termodeentregadechaves;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class MovTermoEntregaChaves extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovTermoEntregaChaves frame = new MovTermoEntregaChaves();
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
	public MovTermoEntregaChaves() {
		setTitle("Movimenta\u00E7\u00E3o Termo de Entrega de Chaves");
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
		button.setIcon(new ImageIcon(MovTermoEntregaChaves.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovTermoEntregaChaves.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovTermoEntregaChaves.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovTermoEntregaChaves.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 345);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações do Termo", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 14, 46, 14);
		panel_1.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(165, 8, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigoContratoDe = new JLabel("C\u00F3digo Contrato Loca\u00E7\u00E3o:");
		lblCdigoContratoDe.setBounds(10, 45, 169, 14);
		panel_1.add(lblCdigoContratoDe);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 39, 46, 20);
		panel_1.add(textField_1);
		
		JLabel lblNomeLocatrio = new JLabel("Nome Locat\u00E1rio:");
		lblNomeLocatrio.setBounds(10, 76, 110, 14);
		panel_1.add(lblNomeLocatrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 70, 272, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 101, 110, 20);
		panel_1.add(textField_3);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 107, 46, 14);
		panel_1.add(lblData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Cancelado", "Finalizado"}));
		comboBox.setBounds(165, 132, 110, 20);
		panel_1.add(comboBox);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(10, 138, 82, 14);
		panel_1.add(lblSituao);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovTermoEntregaChaves.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(221, 39, 29, 20);
		panel_1.add(button_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cláusulas Adicionais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblClusulasAdicionais = new JLabel("Cl\u00E1usulas Adicionais:");
		lblClusulasAdicionais.setBounds(10, 11, 151, 14);
		panel_2.add(lblClusulasAdicionais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 669, 270);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
