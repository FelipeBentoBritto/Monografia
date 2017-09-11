package reajuste;

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

public class MovReajuste extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovReajuste frame = new MovReajuste();
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
	public MovReajuste() {
		setTitle("Movimenta\u00E7\u00E3o de Reajuste de Aluguel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 563, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel_1.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(177, 5, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 36, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 67, 86, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 98, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblCdigoDoAluguel = new JLabel("C\u00F3digo do Aluguel:");
		lblCdigoDoAluguel.setBounds(10, 42, 114, 14);
		panel_1.add(lblCdigoDoAluguel);
		
		JLabel lblNewLabel = new JLabel("Porcentagem do Reajuste:");
		lblNewLabel.setBounds(10, 73, 167, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblPrazoDeReajuste = new JLabel("Prazo de Reajuste:");
		lblPrazoDeReajuste.setBounds(10, 104, 145, 14);
		panel_1.add(lblPrazoDeReajuste);
		
		textField_4 = new JTextField();
		textField_4.setBounds(177, 129, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(177, 160, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPrximoReajuste = new JLabel("Pr\u00F3ximo Reajuste");
		lblPrximoReajuste.setBounds(10, 135, 145, 14);
		panel_1.add(lblPrximoReajuste);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 166, 69, 14);
		panel_1.add(lblValor);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MovReajuste.class.getResource("/Imagens/Zoom-icon.png")));
		button_4.setToolTipText("Pesquisar");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(240, 240, 241));
		button_4.setBounds(271, 36, 29, 20);
		panel_1.add(button_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 191, 563, 51);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MovReajuste.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MovReajuste.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MovReajuste.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MovReajuste.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel.add(button_3);
	}
}
