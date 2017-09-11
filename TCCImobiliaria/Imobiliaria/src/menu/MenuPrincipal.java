package menu;

import imovel.CadImovel;
import imovel.ConImovel;

import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import locatario.CadLocatario;
import procuracao.ConProcuracao;
import procuracao.MovProcuracao;
import proprietario.CadProprietario;
import proprietario.ConProprietario;
import tipoimovel.CadTipoImovel;
import tipoimovel.ConTipoImovel;
import cidade.CadCidade;
import cidade.ConCidade;
import fiador.CadFiador;
import fiador.ConFiador;
import javax.swing.JToolBar;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	public static boolean fecharComMenu;
	private JTextField tfUsuario;
	private JTextField tfDataHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		fecharComMenu = false;
		setTitle("Menu Principal - Vale Verde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 634);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu menu = new JMenu("Cadastros");
		menu.setMnemonic('c');
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Propriet\u00E1rio");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadProprietario().setVisible(true);
				MenuPrincipal.this.dispose();;
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Im\u00F3vel");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadImovel().setVisible(true);
				MenuPrincipal.this.dispose();;
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Locat\u00E1rio");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				CadLocatario.main(null);
			}
		});

		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Fiador");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				CadFiador.main(null);	
			}
		});
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Prestador de Servi\u00E7os");
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Servi\u00E7o");
		menu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Manuten\u00E7\u00E3o");
		menu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Tipo de Im\u00F3vel");

		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				CadTipoImovel.main(null);
				
			}
		});
		menu.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Cidade");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				CadCidade.main(null);
			}
		});
		menu.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("Vistoria");
		menu.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("C\u00F4modo");
		menu.add(menuItem_10);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menu.add(menuBar_1);
		
		JMenu menu_1 = new JMenu("Movimenta\u00E7\u00F5es");
		menu_1.setMnemonic('m');
		menuBar.add(menu_1);
		
		JMenuItem menuItem_11 = new JMenuItem("Aluguel");
		menu_1.add(menuItem_11);
		
		JMenuItem menuItem_12 = new JMenuItem("Repasse");
		menu_1.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("Contrato de Loca\u00E7\u00E3o");
		menu_1.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("Contrato de Administra\u00E7\u00E3o");
		menu_1.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("Procura\u00E7\u00E3o");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				new MovProcuracao().setVisible(true);
			}
		});
		menu_1.add(menuItem_15);
		
		JMenuItem menuItem_16 = new JMenuItem("Rescis\u00E3o de Contrato");
		menu_1.add(menuItem_16);
		
		JMenuItem menuItem_17 = new JMenuItem("Reajuste de Aluguel");
		menu_1.add(menuItem_17);
		
		JMenuItem menuItem_18 = new JMenuItem("Carta de Fian\u00E7a");
		menu_1.add(menuItem_18);
		
		JMenuItem menuItem_19 = new JMenuItem("Renova\u00E7\u00E3o de Contrato");
		menu_1.add(menuItem_19);
		
		JMenuItem menuItem_20 = new JMenuItem("Termo de Entrega de Chaves");
		menu_1.add(menuItem_20);
		
		JMenu menu_2 = new JMenu("Relat\u00F3rios");
		menu_2.setMnemonic('R');
		menuBar.add(menu_2);
		
		JMenuItem menuItem_21 = new JMenuItem("Credores");
		menu_2.add(menuItem_21);
		
		JMenuItem menuItem_22 = new JMenuItem("Contas - Prestadores de Servi\u00E7o");
		menu_2.add(menuItem_22);
		
		JMenuItem menuItem_23 = new JMenuItem("Alugueis a Receber");
		menu_2.add(menuItem_23);
		
		JMenuItem menuItem_24 = new JMenuItem("Repasses a Pagar");
		menu_2.add(menuItem_24);
		
		JMenuItem menuItem_25 = new JMenuItem("Lucro Mensal/Anual dos Alugu\u00E9is");
		menu_2.add(menuItem_25);
		
		JMenu menu_3 = new JMenu("Consultas");
		menu_3.setMnemonic('o');
		menuBar.add(menu_3);
		
		JMenuItem menuItem_26 = new JMenuItem("Propriet\u00E1rio");
		menuItem_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose();
				new ConProprietario().setVisible(true);
				
				if (MenuPrincipal.this.isShowing()) {
					fecharComMenu = true;
				}
			}
		});
		menu_3.add(menuItem_26);
		
		JMenuItem menuItem_27 = new JMenuItem("Locat\u00E1rio");
		menu_3.add(menuItem_27);
		
		JMenuItem menuItem_28 = new JMenuItem("Fiador");
		menuItem_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				ConFiador.main(null);	
			}
		});
		menu_3.add(menuItem_28);
		
		JMenuItem menuItem_29 = new JMenuItem("Prestador de Servi\u00E7os");
		menu_3.add(menuItem_29);
		
		JMenuItem menuItem_30 = new JMenuItem("Im\u00F3vel");
		menuItem_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				new ConImovel().setVisible(true);
			}
		});
		menu_3.add(menuItem_30);
		
		JMenuItem mntmCidade = new JMenuItem("Cidade");
		mntmCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				ConCidade.main(null);
			}
		});
		menu_3.add(mntmCidade);
		
		JMenuItem menuItem_31 = new JMenuItem("Procura\u00E7\u00E3o");
		menuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovProcuracao.fecharSemMenu2 = false;
				MenuPrincipal.this.dispose();
				new ConProcuracao().setVisible(true);
				MovProcuracao.aberto = false;
			}
		});
		menu_3.add(menuItem_31);
		
		JMenuItem menuItem_32 = new JMenuItem("Contrato de Administra\u00E7\u00E3o");
		menu_3.add(menuItem_32);
		
		JMenuItem menuItem_33 = new JMenuItem("Contrato de Loca\u00E7\u00E3o");
		menu_3.add(menuItem_33);
		
		JMenuItem menuItem_34 = new JMenuItem("Carta de Fian\u00E7a");
		menu_3.add(menuItem_34);
		
		JMenuItem menuItem_35 = new JMenuItem("Vistoria");
		menu_3.add(menuItem_35);
		
		JMenuItem menuItem_36 = new JMenuItem("Manuten\u00E7\u00E3o");
		menu_3.add(menuItem_36);
		
		JMenuItem menuItem_37 = new JMenuItem("Aluguel");
		menu_3.add(menuItem_37);
		
		JMenuItem menuItem_38 = new JMenuItem("Repasse");
		menu_3.add(menuItem_38);
		
		JMenuItem menuItem_39 = new JMenuItem("Servi\u00E7o");
		menu_3.add(menuItem_39);
		
		JMenuItem menuItem_40 = new JMenuItem("Reajuste");
		menu_3.add(menuItem_40);
		
		JMenuItem menuItem_41 = new JMenuItem("Tipo do Im\u00F3vel");
		menuItem_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.this.dispose();
				ConTipoImovel.main(null);
			}
		});
		menu_3.add(menuItem_41);
		
		JMenuItem menuItem_42 = new JMenuItem("Comodos");
		menu_3.add(menuItem_42);
		
		JMenuItem menuItem_43 = new JMenuItem("Reajuste de Aluguel");
		menu_3.add(menuItem_43);
		
		JMenuItem menuItem_44 = new JMenuItem("Renova\u00E7\u00E3o de Contrato");
		menu_3.add(menuItem_44);
		
		JMenuItem menuItem_45 = new JMenuItem("Rescis\u00E3o de Contrato");
		menu_3.add(menuItem_45);
		
		JMenu menu_4 = new JMenu("Manuten\u00E7\u00E3o");
		menu_4.setMnemonic('e');
		menuBar.add(menu_4);
		
		JMenu menu_5 = new JMenu("Sobre");
		menu_5.setMnemonic('S');
		menuBar.add(menu_5);
		
		JMenu menu_6 = new JMenu("Ajuda");
		menu_6.setMnemonic('A');
		menuBar.add(menu_6);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				System.exit(0);
			}
		});

		mnSair.setMnemonic('i');
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});

		menuBar.add(mnSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 844, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagens/pn.jpg")));
		lblNewLabel_1.setBounds(0, 0, 844, 111);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 110, 844, 473);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagens/ValeVerde.jpg")));
		lblNewLabel.setBounds(0, 0, 844, 451);
		panel_1.add(lblNewLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 451, 234, 22);
		panel_1.add(toolBar);
		
		JLabel Administrador = new JLabel("Usu\u00E1rio:  ");
		toolBar.add(Administrador);
		
		tfUsuario = new JTextField();
		toolBar.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(237, 451, 311, 22);
		panel_1.add(toolBar_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data/Hora:   ");
		toolBar_1.add(lblNewLabel_2);
		
		tfDataHora = new JTextField();
		toolBar_1.add(tfDataHora);
		tfDataHora.setColumns(10);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
