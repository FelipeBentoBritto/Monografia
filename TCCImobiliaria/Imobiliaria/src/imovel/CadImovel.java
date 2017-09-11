package imovel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import menu.MenuPrincipal;
import proprietario.CadProprietario;
import proprietario.ConProprietario;
import proprietario.ProprietarioCidade;
import tipoimovel.CadTipoImovel;
import tipoimovel.ConTipoImovel;
import tipoimovel.TipoImovel;

import javax.swing.JFormattedTextField;

public class CadImovel extends JFrame {

	private JPanel contentPane;
	private static JTextField tfId;
	private static JTextField tfEndereco;
	private static JTextField tfNumero;
	private static JTextField tfCep;
	private static JTextField tfComplemento;
	private static JTextField tfBairro;
	private static JTextField tfProximidades;
	private static JFormattedTextField tfDataEntrada;
	private static JTextField tfEstadoDoImovel;
	private static JTextField tfAreaTe;
	private static JTextField tfAreaCons;
	private static JTextField tfIdTipoImovel;
	private static JTextField tfValorImovel;
	private static JTextField tfTaxaAdm;
	private static JTextField tfIdProprietario;
	private static JTextArea tfDescricao;
	private static JTextArea tfObservacoes;
	
	private static Date dataEntrada;
	private Date data, dataAtual;
	private static String result;
	
	public static boolean visivel, visivelProprietario, fecharSemMenu, fecharSemMenu2, aberto;

	private JTabbedPane tabbedPane;
	private static JComboBox cbEstrutura;
	private static Imovel imovel;
	private boolean ver;
	private Double areate = null, areacons = null;
	static JButton btnExcluir;
	
	private MaskFormatter mascaraData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadImovel frame = new CadImovel();
					frame.setVisible(true);
					for (UIManager.LookAndFeelInfo lnf : UIManager
							.getInstalledLookAndFeels()) {
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
	public CadImovel() {
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Cadastro de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 347, 694, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = null;
				data = null;
				DateFormat formatDate;
				str = tfDataEntrada.getText();
				formatDate = new SimpleDateFormat("dd/MM/yyyy");
				if (!tfDataEntrada.getText().isEmpty()) {
				try {
					data = formatDate.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dataEntrada = null;
					JOptionPane.showMessageDialog(null, "Data Inválida");
					tfDataEntrada.requestFocus();
					return;
				}
				}
				if (dataEntrada != null) {
					new SimpleDateFormat("yyyy-MM-dd").format(data);
				}
				if (ver = VerificarCampos(true)) {
					if (tfId.getText().isEmpty()) {
						if (tfAreaCons.getText().isEmpty()
								&& tfAreaTe.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									areate, areacons, tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							ImovelDAO.Inserir(imovel);
							LimparDados();
						} else if (tfAreaCons.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									Double.parseDouble(tfAreaTe.getText()),
									areacons, tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							ImovelDAO.Inserir(imovel);
							LimparDados();
						} else if (tfAreaTe.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									areate, Double.parseDouble(tfAreaCons
											.getText()), tfObservacoes
											.getText(), (String) cbEstrutura
											.getSelectedItem(), tfProximidades
											.getText(),
											data, tfEstadoDoImovel
											.getText());
							ImovelDAO.Inserir(imovel);
							LimparDados();
						} else {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									Double.parseDouble(tfAreaTe.getText()),
									Double.parseDouble(tfAreaCons.getText()),
									tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							ImovelDAO.Inserir(imovel);
							LimparDados();
						}
					} else {
						if (tfAreaCons.getText().isEmpty()
								&& tfAreaTe.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									areate, areacons, tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							int aux = Integer.parseInt(tfId.getText());
							ImovelDAO.Atualizar(imovel, aux);
							LimparDados();
						} else if (tfAreaCons.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									Double.parseDouble(tfAreaTe.getText()),
									areacons, tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							int aux = Integer.parseInt(tfId.getText());
							ImovelDAO.Atualizar(imovel, aux);
							LimparDados();
						} else if (tfAreaTe.getText().isEmpty()) {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									areate, Double.parseDouble(tfAreaCons
											.getText()), tfObservacoes
											.getText(), (String) cbEstrutura
											.getSelectedItem(), tfProximidades
											.getText(),
											data, tfEstadoDoImovel
											.getText());
							int aux = Integer.parseInt(tfId.getText());
							ImovelDAO.Atualizar(imovel, aux);
							LimparDados();
						} else {
							imovel = new Imovel(
									0,
									Integer.parseInt(tfIdTipoImovel.getText()),
									Integer.parseInt(tfIdProprietario.getText()),
									tfEndereco.getText(),
									Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(),
									tfBairro.getText(),
									tfCep.getText(),
									tfDescricao.getText(),
									Double.parseDouble(tfTaxaAdm.getText()),
									Double.parseDouble(tfValorImovel.getText()),
									Double.parseDouble(tfAreaTe.getText()),
									Double.parseDouble(tfAreaCons.getText()),
									tfObservacoes.getText(),
									(String) cbEstrutura.getSelectedItem(),
									tfProximidades.getText(), data, tfEstadoDoImovel
											.getText());
							int aux = Integer.parseInt(tfId.getText());
							ImovelDAO.Atualizar(imovel, aux);
							LimparDados();
						}
					}
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(240, 240, 241));
		panel.add(btnSalvar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparDados();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Button-Close-icon.png")));
		btnLimpar.setToolTipText("Cancelar");
		btnLimpar.setOpaque(false);
		btnLimpar.setFocusPainted(false);
		btnLimpar.setBackground(new Color(240, 240, 241));
		panel.add(btnLimpar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfAreaCons.getText().isEmpty()
						&& tfAreaTe.getText().isEmpty()) {
					imovel = new Imovel(
							0,
							Integer.parseInt(tfIdTipoImovel.getText()),
							Integer.parseInt(tfIdProprietario.getText()),
							tfEndereco.getText(),
							Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(),
							tfBairro.getText(),
							tfCep.getText(),
							tfDescricao.getText(),
							Double.parseDouble(tfTaxaAdm.getText()),
							Double.parseDouble(tfValorImovel.getText()),
							areate, areacons, tfObservacoes.getText(),
							(String) cbEstrutura.getSelectedItem(),
							tfProximidades.getText(), data, tfEstadoDoImovel
									.getText());
					int aux = Integer.parseInt(tfId.getText());
					ImovelDAO.Remover(imovel, aux);
					LimparDados();
				} else if (tfAreaCons.getText().isEmpty()) {
					imovel = new Imovel(
							0,
							Integer.parseInt(tfIdTipoImovel.getText()),
							Integer.parseInt(tfIdProprietario.getText()),
							tfEndereco.getText(),
							Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(),
							tfBairro.getText(),
							tfCep.getText(),
							tfDescricao.getText(),
							Double.parseDouble(tfTaxaAdm.getText()),
							Double.parseDouble(tfValorImovel.getText()),
							Double.parseDouble(tfAreaTe.getText()),
							areacons, tfObservacoes.getText(),
							(String) cbEstrutura.getSelectedItem(),
							tfProximidades.getText(), data, tfEstadoDoImovel
									.getText());
					int aux = Integer.parseInt(tfId.getText());
					ImovelDAO.Remover(imovel, aux);
					LimparDados();
				} else if (tfAreaTe.getText().isEmpty()) {
					imovel = new Imovel(
							0,
							Integer.parseInt(tfIdTipoImovel.getText()),
							Integer.parseInt(tfIdProprietario.getText()),
							tfEndereco.getText(),
							Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(),
							tfBairro.getText(),
							tfCep.getText(),
							tfDescricao.getText(),
							Double.parseDouble(tfTaxaAdm.getText()),
							Double.parseDouble(tfValorImovel.getText()),
							areate, Double.parseDouble(tfAreaCons
									.getText()), tfObservacoes
									.getText(), (String) cbEstrutura
									.getSelectedItem(), tfProximidades
									.getText(),
									data, tfEstadoDoImovel
									.getText());
					int aux = Integer.parseInt(tfId.getText());
					ImovelDAO.Remover(imovel, aux);
					LimparDados();
				} else {
					imovel = new Imovel(
							0,
							Integer.parseInt(tfIdTipoImovel.getText()),
							Integer.parseInt(tfIdProprietario.getText()),
							tfEndereco.getText(),
							Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(),
							tfBairro.getText(),
							tfCep.getText(),
							tfDescricao.getText(),
							Double.parseDouble(tfTaxaAdm.getText()),
							Double.parseDouble(tfValorImovel.getText()),
							Double.parseDouble(tfAreaTe.getText()),
							Double.parseDouble(tfAreaCons.getText()),
							tfObservacoes.getText(),
							(String) cbEstrutura.getSelectedItem(),
							tfProximidades.getText(), data, tfEstadoDoImovel
									.getText());
					int aux = Integer.parseInt(tfId.getText());
					ImovelDAO.Remover(imovel, aux);
					LimparDados();
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel.add(btnExcluir);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPrincipal().setVisible(true);
				CadImovel.this.dispose();
				;
			}
		});
		btnSair.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel.add(btnSair);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 347);
		contentPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações Principais", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(125, 11, 86, 20);
		panel_1.add(tfId);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 101, 69, 14);
		panel_1.add(lblEndereo);

		tfEndereco = new JTextField();
		tfEndereco.setBackground(new Color(173, 255, 47));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(125, 95, 226, 20);
		panel_1.add(tfEndereco);

		JLabel lblCep = new JLabel("N\u00FAmero:");
		lblCep.setBounds(10, 129, 62, 14);
		panel_1.add(lblCep);

		tfNumero = new JTextField();
		tfNumero.setBackground(new Color(173, 255, 47));
		tfNumero.setColumns(10);
		tfNumero.setBounds(125, 123, 52, 20);
		panel_1.add(tfNumero);

		JLabel lblCep_1 = new JLabel("CEP:");
		lblCep_1.setBounds(10, 159, 86, 14);
		panel_1.add(lblCep_1);

		tfCep = new JTextField();
		tfCep.setBackground(new Color(173, 255, 47));
		tfCep.setColumns(10);
		tfCep.setBounds(125, 151, 115, 20);
		panel_1.add(tfCep);

		JLabel label_4 = new JLabel("Complemento:");
		label_4.setBounds(10, 215, 86, 14);
		panel_1.add(label_4);

		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(125, 207, 226, 20);
		panel_1.add(tfComplemento);

		tfBairro = new JTextField();
		tfBairro.setBackground(new Color(173, 255, 47));
		tfBairro.setColumns(10);
		tfBairro.setBounds(125, 179, 226, 20);
		panel_1.add(tfBairro);

		JLabel label_5 = new JLabel("Bairro:");
		label_5.setBounds(10, 189, 46, 14);
		panel_1.add(label_5);

		JLabel lblProximidades = new JLabel("Proximidades:");
		lblProximidades.setBounds(10, 242, 86, 14);
		panel_1.add(lblProximidades);

		tfProximidades = new JTextField();
		tfProximidades.setColumns(10);
		tfProximidades.setBounds(125, 235, 226, 21);
		panel_1.add(tfProximidades);

		JLabel lblDataDeEntrada = new JLabel("Data de Entrada:");
		lblDataDeEntrada.setBounds(392, 129, 99, 14);
		panel_1.add(lblDataDeEntrada);

		tfDataEntrada = new JFormattedTextField(mascaraData);
		tfDataEntrada.setBackground(new Color(173, 255, 47));
		tfDataEntrada.setColumns(10);
		tfDataEntrada.setBounds(490, 123, 86, 20);
		panel_1.add(tfDataEntrada);

		JLabel lblCdigoDoTipo = new JLabel("C\u00F3digo Tipo Im\u00F3vel:");
		lblCdigoDoTipo.setBounds(10, 44, 115, 14);
		panel_1.add(lblCdigoDoTipo);

		tfIdTipoImovel = new JTextField();
		tfIdTipoImovel.setBackground(new Color(173, 255, 47));
		tfIdTipoImovel.setEnabled(false);
		tfIdTipoImovel.setColumns(10);
		tfIdTipoImovel.setBounds(125, 39, 86, 20);
		panel_1.add(tfIdTipoImovel);

		JButton btnPesquisarTipoIm = new JButton("");
		btnPesquisarTipoIm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visivel = true;
				new ConTipoImovel().setVisible(true);
				
				if (CadImovel.this.isShowing()) {
					
					fecharSemMenu = true;	
					
				}
			}
		});
		btnPesquisarTipoIm.setToolTipText("Pesquisar");
		btnPesquisarTipoIm.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Zoom-icon.png")));
		btnPesquisarTipoIm.setBounds(223, 36, 29, 20);
		panel_1.add(btnPesquisarTipoIm);
		Color color = new Color(240, 240, 241);
		btnPesquisarTipoIm.setBackground(color);
		btnPesquisarTipoIm.setOpaque(false);
		btnPesquisarTipoIm.setFocusPainted(false);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(392, 17, 69, 14);
		panel_1.add(lblDescrio);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 17, 195, 98);
		panel_1.add(scrollPane);

		tfDescricao = new JTextArea();
		tfDescricao.setBackground(new Color(173, 255, 47));
		scrollPane.setViewportView(tfDescricao);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(392, 159, 86, 14);
		panel_1.add(lblObservaes);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(490, 151, 195, 105);
		panel_1.add(scrollPane_1);

		tfObservacoes = new JTextArea();
		scrollPane_1.setViewportView(tfObservacoes);

		JButton btnCadastrarTipoIm = new JButton("");
		btnCadastrarTipoIm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadImovel.this.dispose();
				new CadTipoImovel().setVisible(true);
			}
		});
		btnCadastrarTipoIm.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Files-New-File-icon.png")));
		btnCadastrarTipoIm.setToolTipText("Adicionar um Novo Tipo de Imovel");
		btnCadastrarTipoIm.setOpaque(false);
		btnCadastrarTipoIm.setFocusPainted(false);
		btnCadastrarTipoIm.setBackground(new Color(240, 240, 241));
		btnCadastrarTipoIm.setBounds(262, 36, 29, 20);
		panel_1.add(btnCadastrarTipoIm);

		JLabel lblCdigoDoProprietrio = new JLabel(
				"C\u00F3digo Propriet\u00E1rio:");
		lblCdigoDoProprietrio.setBounds(10, 73, 167, 14);
		panel_1.add(lblCdigoDoProprietrio);

		tfIdProprietario = new JTextField();
		tfIdProprietario.setBackground(new Color(173, 255, 47));
		tfIdProprietario.setEnabled(false);
		tfIdProprietario.setColumns(10);
		tfIdProprietario.setBounds(125, 67, 86, 20);
		panel_1.add(tfIdProprietario);

		JButton btnConsultarProprietario = new JButton("");
		btnConsultarProprietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visivelProprietario = true;
				new ConProprietario().setVisible(true);
				fecharSemMenu = false;
				if (CadImovel.this.isShowing()) {
					
					fecharSemMenu = true;	
					
				}
			}
		});
		btnConsultarProprietario.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Zoom-icon.png")));
		btnConsultarProprietario.setToolTipText("Pesquisar");
		btnConsultarProprietario.setOpaque(false);
		btnConsultarProprietario.setFocusPainted(false);
		btnConsultarProprietario.setBackground(new Color(240, 240, 241));
		btnConsultarProprietario.setBounds(223, 67, 29, 20);
		panel_1.add(btnConsultarProprietario);

		JButton btnCadastrarProprietario = new JButton("");
		btnCadastrarProprietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarProprietario.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Files-New-File-icon.png")));
		btnCadastrarProprietario
				.setToolTipText("Adicionar um Novo Tipo de Imovel");
		btnCadastrarProprietario.setOpaque(false);
		btnCadastrarProprietario.setFocusPainted(false);
		btnCadastrarProprietario.setBackground(new Color(240, 240, 241));
		btnCadastrarProprietario.setBounds(262, 67, 29, 20);
		panel_1.add(btnCadastrarProprietario);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConImovel().setVisible(true);
				aberto = false;
				fecharSemMenu2 = false;
				if (CadImovel.this.isShowing()) {
					aberto = true;
					fecharSemMenu2 = true;
				}
				
			}
		});
		button.setIcon(new ImageIcon(CadImovel.class
				.getResource("/Imagens/Zoom-icon.png")));
		button.setToolTipText("Pesquisar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		button.setBounds(223, 10, 29, 20);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações de Estrutura", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblEstadoDoImvel_1 = new JLabel("Estado do Im\u00F3vel:");
		lblEstadoDoImvel_1.setBounds(10, 17, 99, 14);
		panel_2.add(lblEstadoDoImvel_1);

		tfEstadoDoImovel = new JTextField();
		tfEstadoDoImovel.setColumns(10);
		tfEstadoDoImovel.setBounds(140, 11, 135, 20);
		panel_2.add(tfEstadoDoImovel);

		JLabel lblreaDoTerreno = new JLabel("\u00C1rea do Terreno:");
		lblreaDoTerreno.setBounds(10, 42, 99, 14);
		panel_2.add(lblreaDoTerreno);

		tfAreaTe = new JTextField();
		tfAreaTe.setColumns(10);
		tfAreaTe.setBounds(140, 36, 135, 20);
		panel_2.add(tfAreaTe);

		JLabel lblreaDeConstruo = new JLabel(
				"\u00C1rea de Constru\u00E7\u00E3o:");
		lblreaDeConstruo.setBounds(10, 67, 120, 14);
		panel_2.add(lblreaDeConstruo);

		tfAreaCons = new JTextField();
		tfAreaCons.setColumns(10);
		tfAreaCons.setBounds(140, 61, 135, 20);
		panel_2.add(tfAreaCons);

		JLabel lblEstrutura = new JLabel("Estrutura:");
		lblEstrutura.setBounds(10, 92, 86, 14);
		panel_2.add(lblEstrutura);

		cbEstrutura = new JComboBox();
		cbEstrutura.setModel(new DefaultComboBoxModel(new String[] {"", "Alvenaria", "Madeira", "Alvenaria/Madeira"}));
		cbEstrutura.setBounds(140, 86, 135, 20);
		panel_2.add(cbEstrutura);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Valor", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblValorDoImvel = new JLabel("Valor do Im\u00F3vel:");
		lblValorDoImvel.setBounds(10, 11, 98, 14);
		panel_3.add(lblValorDoImvel);

		JLabel lblTaxaDeAdministrao = new JLabel(
				"Taxa de Administra\u00E7\u00E3o:");
		lblTaxaDeAdministrao.setBounds(10, 36, 141, 14);
		panel_3.add(lblTaxaDeAdministrao);

		tfValorImovel = new JTextField();
		tfValorImovel.setBackground(new Color(173, 255, 47));
		tfValorImovel.setBounds(161, 8, 118, 17);
		panel_3.add(tfValorImovel);
		tfValorImovel.setColumns(10);

		tfTaxaAdm = new JTextField();
		tfTaxaAdm.setBackground(new Color(173, 255, 47));
		tfTaxaAdm.setBounds(161, 33, 76, 17);
		panel_3.add(tfTaxaAdm);
		tfTaxaAdm.setColumns(10);

		setLocationRelativeTo(null);
		setResizable(false);

		// DEIXAR POR ULTIMO NO CÓDIGO
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tfEndereco.requestFocus();
			}
		});
	}

	public static void SetarTipoImovel(TipoImovel tipoImovel) {
		String aux = Integer.toString(tipoImovel.getId());
		tfIdTipoImovel.setText(aux);
	}

	public static void SetarProprietario(ProprietarioCidade proprietarioCidade) {
		String aux = Integer.toString(proprietarioCidade.getId());
		tfIdProprietario.setText(aux);
	}

	boolean VerificarCampos(boolean b) {
		Date dataAtualSistema = new Date(System.currentTimeMillis());
		DateFormat formatDate;
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (!tfDataEntrada.getText().isEmpty()) {
			dataAtual = formatDate.parse(tfDataEntrada.getText());
			} else {
				dataAtual = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tfIdTipoImovel.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Tipo Imóvel deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			return false;
		} else if (tfIdProprietario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Proprietário deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			return false;
		} else if (tfEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Endereço deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			tfEndereco.requestFocus();
			return false;
		} else if (tfNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Número do Endereço deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			tfNumero.requestFocus();
			return false;
		} else if (tfBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Bairro deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			tfBairro.requestFocus();
			return false;
		} else if (tfDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Descrição deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			tfDescricao.requestFocus();
			return false;
		} else if (tfTaxaAdm.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Taxa de Administração deve ser preenchido!");
			tabbedPane.setSelectedIndex(2);
			tfTaxaAdm.requestFocus();
			return false;
		} else if (tfValorImovel.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Valor do Imóvel deve ser preenchido!");
			tabbedPane.setSelectedIndex(2);
			tfValorImovel.requestFocus();
			return false;
		} else if (tfDataEntrada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O Campo Data de Entrada deve ser preenchido!");
			tabbedPane.setSelectedIndex(0);
			tfDataEntrada.requestFocus();
			return false;
		} else if ((dataAtual != null) && (dataAtual.after(dataAtualSistema)) && (!tfDataEntrada.getText().isEmpty())){
			 JOptionPane.showMessageDialog(null, "A Data de Entrada não pode ser maior que a data atual!");
			 tabbedPane.setSelectedIndex(0);
			 tfDataEntrada.requestFocus();
			 	return false;
		 } 
		else {
			return true;
		}
	}

	public void LimparDados() {
		tfId.setText("");
		tfIdTipoImovel.setText("");
		tfIdProprietario.setText("");
		tfEndereco.setText("");
		tfNumero.setText("");
		tfBairro.setText("");
		tfComplemento.setText("");
		tfCep.setText("");
		tfDescricao.setText("");
		tfAreaTe.setText("");
		tfAreaCons.setText("");
		tfTaxaAdm.setText("");
		tfValorImovel.setText("");
		tfObservacoes.setText("");
		tfProximidades.setText("");
		tfDataEntrada.setText("");
		tfEstadoDoImovel.setText("");
		cbEstrutura.setSelectedIndex(0);
		tabbedPane.setSelectedIndex(0);
		tfEndereco.requestFocus();
	}

	public static void SetarDados(ImovelConsulta imovelConsulta) {
		String aux = Integer.toString(imovelConsulta.getId());
		String aux2 = Integer.toString(imovelConsulta.getIdTipoImovel());
		String aux3 = Integer.toString(imovelConsulta.getNumero());
		String aux4;
		String aux5 = Integer.toString(imovelConsulta.getidProprietario());
		String aux6;
		String aux7 = Double.toString(imovelConsulta.getValorImovel());
		String aux8 = Double.toString(imovelConsulta.getTaxaAdm());
		if (imovelConsulta.getAreaTe().equals(0)) {
			aux4 = null;
		} else {
			aux4 = Double.toString(imovelConsulta.getAreaTe());
		}
		if (imovelConsulta.getAreaCons().equals(0)) {
			aux6 = null;
		} else {
			aux6 = Double.toString(imovelConsulta.getAreaCons());
		}

		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if ((imovelConsulta.getDataEntrada() != null)) {
				result = out.format(in.parse(imovelConsulta.getDataEntrada().toString()));
			} else {
				result = "";
			}
				
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tfId.setText(aux);
		tfIdTipoImovel.setText(aux2);
		tfIdProprietario.setText(aux5);
		tfEndereco.setText(imovelConsulta.getEndereco());
		tfCep.setText(imovelConsulta.getCep());
		tfNumero.setText(aux3);
		tfBairro.setText(imovelConsulta.getBairro());
		tfComplemento.setText(imovelConsulta.getComplemento());
		tfDescricao.setText(imovelConsulta.getDescricao());
		tfTaxaAdm.setText(aux8);
		tfValorImovel.setText(aux7);
		tfObservacoes.setText(imovelConsulta.getObservacoes());
		cbEstrutura.setSelectedItem(imovelConsulta.getEstrutura());
		tfProximidades.setText(imovelConsulta.getProximidades());
		tfDataEntrada.setText(result);
		tfEstadoDoImovel.setText(imovelConsulta.getEstado());
	}
}
