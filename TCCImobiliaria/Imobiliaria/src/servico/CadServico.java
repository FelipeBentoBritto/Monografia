package servico;

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

public class CadServico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadServico frame = new CadServico();
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
	public CadServico() {
		setTitle("Cadastro de Servi\u00E7os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 484, 185);
		contentPane.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 14, 46, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 8, 86, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setBounds(10, 39, 67, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 33, 386, 20);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 185, 484, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadServico.class.getResource("/Imagens/Button-Add-icon.png")));
		button.setToolTipText("Salvar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadServico.class.getResource("/Imagens/Button-Close-icon.png")));
		button_1.setToolTipText("Cancelar");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(240, 240, 241));
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadServico.class.getResource("/Imagens/Button-Delete-icon.png")));
		button_2.setToolTipText("Deletar");
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setBackground(new Color(240, 240, 241));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadServico.class.getResource("/Imagens/logout-icon.png")));
		button_3.setToolTipText("Sair");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(240, 240, 241));
		panel_1.add(button_3);
	}
}
