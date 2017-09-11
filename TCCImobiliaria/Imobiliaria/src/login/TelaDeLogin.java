package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class TelaDeLogin extends JFrame {

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
					TelaDeLogin frame = new TelaDeLogin();
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
	public TelaDeLogin() {
		setTitle("Login - Vale Verde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 133);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(107, 40, 46, 14);
		panel.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(168, 34, 125, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(107, 79, 46, 14);
		panel.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 73, 125, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/Imagens/Login.jpg")));
		lblNewLabel.setBounds(0, 0, 436, 133);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 133, 436, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Color color = new Color(240,240,241);
		
		JButton btnLogar = new JButton("");
		btnLogar.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/Imagens/Accept-icon.png")));
		panel_1.add(btnLogar);
		btnLogar.setBackground(color);
		btnLogar.setOpaque(false);
		btnLogar.setFocusPainted(false);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/Imagens/logout-icon.png")));
		panel_1.add(btnSair);
		btnSair.setBackground(color);
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
	}
}
