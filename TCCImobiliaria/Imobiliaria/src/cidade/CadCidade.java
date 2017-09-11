package cidade;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import menu.MenuPrincipal;

public class CadCidade extends JFrame {

	private JPanel contentPane;
	private static JTextField tfId;
	private static JTextField tfNome;
	private static JComboBox cbUf;
	
	private Cidade cidade;
	private boolean ver;
	static JButton btnExcluir;
	public static boolean fecharSemMenu, aberto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadCidade frame = new CadCidade();
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
	public CadCidade() {
		setTitle("Cadastro de Cidade");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 490, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 484, 141);
		contentPane.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 14, 46, 14);
		panel.add(label);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(88, 8, 86, 20);
		panel.add(tfId);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 39, 54, 14);
		panel.add(lblCidade);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(173, 255, 47));
		tfNome.setColumns(10);
		tfNome.setBounds(88, 33, 236, 20);
		panel.add(tfNome);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(10, 64, 46, 14);
		panel.add(lblUf);
		
		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUf.setMaximumRowCount(27);
		cbUf.setBounds(88, 61, 61, 20);
		panel.add(cbUf);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConCidade().setVisible(true);;
				fecharSemMenu = false;
				aberto = false;
				if (CadCidade.this.isShowing()) {
					fecharSemMenu = true;
					aberto = true;
				}
				
			}
		});
		btnConsultar.setIcon(new ImageIcon(CadCidade.class.getResource("/Imagens/Zoom-icon.png")));
		btnConsultar.setToolTipText("Pesquisar");
		btnConsultar.setOpaque(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBackground(new Color(240, 240, 241));
		btnConsultar.setBounds(184, 8, 29, 20);
		panel.add(btnConsultar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 142, 484, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnSalvar = new JButton("");

		btnSalvar.setIcon(new ImageIcon(CadCidade.class.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(240, 240, 241));
		panel_1.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDados();
			}
		});
		btnCancelar.setIcon(new ImageIcon(CadCidade.class.getResource("/Imagens/Button-Close-icon.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(240, 240, 241));
		panel_1.add(btnCancelar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cidade = new Cidade(0, tfNome.getText(), (String)cbUf.getSelectedItem());
				int aux = Integer.parseInt(tfId.getText());
				CidadeDAO.Remover(cidade, aux);
				LimparDados();
			}
		});
		btnExcluir.setIcon(new ImageIcon(CadCidade.class.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel_1.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuPrincipal().setVisible(true);;
				CadCidade.this.dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(CadCidade.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel_1.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					if (ver = VerificarCampos(true)) {
						if (tfId.getText().isEmpty()) {
							cidade = new Cidade(0, tfNome.getText(), (String) cbUf.getSelectedItem());
							CidadeDAO.Inserir(cidade);
							LimparDados();
						}
						else {
							cidade = new Cidade(0, tfNome.getText(), (String)cbUf.getSelectedItem());
							int aux = Integer.parseInt(tfId.getText());
							CidadeDAO.Atualizar(cidade, aux);
							LimparDados();	
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CODIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfNome.requestFocus();}  
	    });
		
	}
	
	public void LimparDados() {
		tfId.setText("");
		tfNome.setText("");
		cbUf.setSelectedIndex(0);
		tfNome.requestFocus();
		btnExcluir.setEnabled(false);
	}
	
	boolean VerificarCampos(boolean b){
		 if (tfNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo cidade deve ser preenchido!");
			tfNome.requestFocus();
			return false;
		 }
		 else {
			 return true;
		 }
	}
	
	public static void SetarDados(Cidade cidade){
		String aux = Integer.toString(cidade.getId());
		tfId.setText(aux);
		tfNome.setText(cidade.getNome());
		cbUf.setSelectedItem(cidade.getUf());
		btnExcluir.setEnabled(true);
	}
}
