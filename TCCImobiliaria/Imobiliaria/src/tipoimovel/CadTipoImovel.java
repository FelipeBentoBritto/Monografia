package tipoimovel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import menu.MenuPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import java.awt.Component;


public class CadTipoImovel extends JFrame {

	private JPanel contentPane;
	private static JTextField tfId;
	private static JTextField tfDescricao;
	private TipoImovel tipoimovel;
	
	
	static JButton btnExcluir;
	private boolean ver;
	public static boolean fecharSemMenu, aberto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadTipoImovel frame = new CadTipoImovel();
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
	public CadTipoImovel() {
		setTitle("Cadastro Tipo de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 14, 46, 14);
		panel.add(lblCdigo);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(88, 8, 86, 20);
		panel.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 39, 67, 14);
		panel.add(lblDescrio);
		
		tfDescricao = new JTextField();
		tfDescricao.setBackground(new Color(173, 255, 47));
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(88, 33, 386, 20);
		panel.add(tfDescricao);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 145, 494, 51);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (ver = VerificarCampos(true)) {
						if (tfId.getText().isEmpty()) {
							tipoimovel = new TipoImovel(0, tfDescricao.getText());
							TipoImovelDAO.Inserir(tipoimovel);
							LimparDados();		
						}
						else {
							tipoimovel = new TipoImovel(0, tfDescricao.getText());
							int aux = Integer.parseInt(tfId.getText());
							TipoImovelDAO.Atualizar(tipoimovel, aux);
							LimparDados();
						}
					}
				}
				catch (Exception e) {
				}
				
			}
		});
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setIcon(new ImageIcon(CadTipoImovel.class.getResource("/Imagens/Button-Add-icon.png")));
		panel_1.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparDados();
				tfDescricao.requestFocus();
			}
		});
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CadTipoImovel.class.getResource("/Imagens/Button-Close-icon.png")));
		panel_1.add(btnCancelar);
		
		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipoimovel = new TipoImovel(0, tfDescricao.getText());
				int aux = Integer.parseInt(tfId.getText());
				TipoImovelDAO.Remover(tipoimovel, aux);
				LimparDados();
			}
		});
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setIcon(new ImageIcon(CadTipoImovel.class.getResource("/Imagens/Button-Delete-icon.png")));
		panel_1.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPrincipal().setVisible(true);
				CadTipoImovel.this.dispose();;
				
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(CadTipoImovel.class.getResource("/Imagens/logout-icon.png")));
		panel_1.add(btnSair);
		
		Color color = new Color(240,240,241);
		btnSalvar.setBackground(color);
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		
		btnCancelar.setBackground(color);
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		
		btnExcluir.setBackground(color);
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		
		btnSair.setBackground(color);
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConTipoImovel().setVisible(true);
				fecharSemMenu = false;
				aberto = false;
				if (CadTipoImovel.this.isShowing()) {
					fecharSemMenu = true;
					aberto = true;
				}
			}
		});
		btnPesquisar.setIcon(new ImageIcon(CadTipoImovel.class.getResource("/Imagens/Zoom-icon.png")));
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setOpaque(false);
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setBackground(new Color(240, 240, 241));
		btnPesquisar.setBounds(184, 8, 29, 20);
		panel.add(btnPesquisar);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CÓDIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfDescricao.requestFocus();}  
	    });
	}
	
	public void LimparDados(){
		tfId.setText("");
		tfDescricao.setText("");
		tfDescricao.requestFocus();
		btnExcluir.setEnabled(false);
	}
	
	boolean VerificarCampos(boolean b) {
		
		if (tfDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Campo Descrição deve ser preenchido!");
			tfDescricao.requestFocus();
			return false;
		} else {
			return true;
		}
		
	}

	public static void SetarDados(TipoImovel tipoimovel){
		String aux = Integer.toString(tipoimovel.getId());
		tfId.setText(aux);
		tfDescricao.setText(tipoimovel.getDescricao());
		btnExcluir.setEnabled(true);
	}
	
}
