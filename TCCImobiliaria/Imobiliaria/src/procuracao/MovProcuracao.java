package procuracao;

import imovel.CadImovel;
import imovel.ConImovelProcuracao;
import imovel.Imovel;
import imovel.ImovelDAO;
import imovel.ImovelProcConsulta;

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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import menu.MenuPrincipal;

import javax.swing.JFormattedTextField;

public class MovProcuracao extends JFrame {

	private JPanel contentPane;
	public static JTextField tfId;
	private static JTextField tfIdImovel;
	private static JTextField tfEnderecoImovel;
	private static JTextField tfNumeroImovel;
	private static JTextField tfComplementoImovel;
	private static JTextField tfBairroImovel;
	private static JTextField tfIdProprietario;
	private static JTextField tfNomeProprietario;
	public static JFormattedTextField tfDataAssinatura;
	private static JComboBox cbSituacao;
	
	private Procuracao procuracao;
	private ProcuracaoConsulta procConsulta;
	private JTabbedPane tabbedPane;
	private boolean ver;
	private Date dataA;
	private static JTextArea tfClausulas;
	private static JButton btnSair;
	public static JButton btnExcluir;
	private Date dataAss;
	private static JTextField tfCnpj;
	private static JTextField tfCpf;
	private static JTextField tfNomeConjuge;
	private static JTextField tfCpfConjuge;
	private static JTextField tfEnderecoProprietario;
	private static JTextField tfNumeroProprietario;
	private static JTextField tfBairroProprietario;
	private static JTextField tfCidade;
	private static JTextField tfTipoImovel;
	private static JComboBox cbTipoPessoa;
	private static JComboBox cbEstadoCivil;
	private static JComboBox cbUf;
	private static String aux6;
	private static String result;
	private static Boolean validarFinalizado, validarCancelado;
	private static JButton btnSalvar;
	private static JButton btnPesquisarImovel;
	private static Date dataAtual;
	private static String auxData;
	public static Boolean fecharSemMenu, fecharSemMenu2, aberto;
	private JButton btnNovoImovel;
	private static JButton btnGerarContrato;
	
	
	private MaskFormatter mascaraData, mascaraVazia;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovProcuracao frame = new MovProcuracao();
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
	public MovProcuracao() {
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
			mascaraVazia = new MaskFormatter("");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Movimenta\u00E7\u00E3o de Procura\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 382, 694, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = null;
				Date data = null;
				DateFormat formatDate;
				str = tfDataAssinatura.getText();
				formatDate = new SimpleDateFormat("dd/MM/yyyy");
				if (!tfDataAssinatura.getText().isEmpty()) {
				try {
					data = formatDate.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dataAss = null;
					JOptionPane.showMessageDialog(null, "Data Inválida");
					tfDataAssinatura.requestFocus();
					return;
				}
				}
				if (dataAss != null) {
					new SimpleDateFormat("yyyy-MM-dd").format(data);
				}
				try {
					if (ProcuracaoConsulta.getValidacaoAssinatura().equals("Assinado")) {
						validarFinalizado = true;
					} else {
						validarFinalizado = false;
					}
					if (ProcuracaoConsulta.getValidacaoAssinatura().equals("Em Aberto")) {
						validarCancelado = true;
					} else {
						validarCancelado = false;
					}
				} catch (Exception e) {
				}
				
				
				if (ver = VerificarCampos(true)) {
					if (tfId.getText().isEmpty()) {
					if (tfDataAssinatura.getText().isEmpty()){
						dataA = null;
								procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
								.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), dataA);
								ProcuracaoDAO.Inserir(procuracao);
								AtualizarImovel();
								LimparDados();
								return;
						}
					else {	
						procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
								.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), data);
								ProcuracaoDAO.Inserir(procuracao);
								AtualizarImovel();
								LimparDados();
								return;
							}
						} else {
							if ((ProcuracaoConsulta.getValidacaoAssinatura().equals("Assinado")) && (cbSituacao.getSelectedItem().equals("Finalizado"))) {
									int resposta;
									resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar esta alteração? Isso será irreversível!");
									if (resposta == JOptionPane.YES_OPTION) {
									// verifica se o usuário clicou no botão YES
										if (tfDataAssinatura.getText().isEmpty()){
											dataA = null;
											procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
											.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), dataA);
											int auxiliar = Integer.parseInt(tfId.getText());
											ProcuracaoDAO.Atualizar(procuracao, auxiliar);
											AtualizarImovel();
											LimparDados();
											return;
										} else {
										procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
												.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), data);
										int auxiliar = Integer.parseInt(tfId.getText());
										ProcuracaoDAO.Atualizar(procuracao, auxiliar);
										AtualizarImovel();
										LimparDados();
										return;
										}
									} else {
										return;
									}
							}
								}
						
							 if (ProcuracaoConsulta.getValidacaoAssinatura().equals("Em Aberto") && (cbSituacao.getSelectedItem().equals("Cancelado"))) {
									int resposta;
									resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar esta alteração? Isso será irreversível!");
									if (resposta == JOptionPane.YES_OPTION) {
									// verifica se o usuário clicou no botão YES
										if (tfDataAssinatura.getText().isEmpty()){
											dataA = null;
											procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
											.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), dataA);
											int auxiliar = Integer.parseInt(tfId.getText());
											ProcuracaoDAO.Atualizar(procuracao, auxiliar);
											AtualizarImovel();
											LimparDados();
											return;
										} else {
										procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
												.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), data);
										int auxiliar = Integer.parseInt(tfId.getText());
										ProcuracaoDAO.Atualizar(procuracao, auxiliar);
										AtualizarImovel();
										LimparDados();
										return;
										}
									} else {
										return;
									}
							}
							 
							 if (ProcuracaoConsulta.getValidacaoAssinatura().equals("Em Aberto") && (cbSituacao.getSelectedItem().equals("Assinado"))) {
										if (tfDataAssinatura.getText().isEmpty()){
											dataA = null;
											procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
											.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), dataA);
											int auxiliar = Integer.parseInt(tfId.getText());
											ProcuracaoDAO.Atualizar(procuracao, auxiliar);
											AtualizarImovel();
											LimparDados();
											return;
										} else if (!tfDataAssinatura.getText().isEmpty()) {
										procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
												.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), data);
										int auxiliar = Integer.parseInt(tfId.getText());
										ProcuracaoDAO.Atualizar(procuracao, auxiliar);
										AtualizarImovel();
										LimparDados();
										return;
										}
									 else {
										return;
									}
							}
							 
							else if (validarFinalizado != true) {
								JOptionPane.showMessageDialog(null, "Não é possivel alterar o registro porque o contrato foi assinado! Agora o contrato só poderá ser Cancelado!");
								System.out.println(validarFinalizado);
								System.out.println(validarCancelado);
								validarFinalizado = true;
							} else if (validarCancelado != true) {
								JOptionPane.showMessageDialog(null, "Não é possivel alterar o registro porque o contrato foi assinado! Agora o contrato só poderá ser Finalizado!");
								System.out.println(validarFinalizado);
								System.out.println(validarCancelado);
								validarCancelado = true;
							}
							
							else {
								
								if (tfDataAssinatura.getText().isEmpty()){
									dataA = null;
									procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
									.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), dataA);
									int auxiliar = Integer.parseInt(tfId.getText());
									ProcuracaoDAO.Atualizar(procuracao, auxiliar);
									AtualizarImovel();
									LimparDados();
									return;
								} else {
								procuracao = new Procuracao(0, Integer.parseInt(tfIdImovel.getText()), Integer.parseInt(tfIdProprietario
										.getText()), tfClausulas.getText(), (String) cbSituacao.getSelectedItem(), data);
								int auxiliar = Integer.parseInt(tfId.getText());
								ProcuracaoDAO.Atualizar(procuracao, auxiliar);
								AtualizarImovel();
								LimparDados();
								return;
								}
							}
			
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(240, 240, 241));
		panel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDados();
			}
		});
		btnLimpar.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Button-Close-icon.png")));
		btnLimpar.setToolTipText("Cancelar");
		btnLimpar.setOpaque(false);
		btnLimpar.setFocusPainted(false);
		btnLimpar.setBackground(new Color(240, 240, 241));
		panel.add(btnLimpar);
		
		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel.add(btnExcluir);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MovProcuracao.this.dispose();
				 new MenuPrincipal().setVisible(true);
			}
		});
		btnSair.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel.add(btnSair);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 381);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações da Procuração", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setBackground(new Color(255, 255, 255));
		tfId.setColumns(10);
		tfId.setBounds(154, 11, 46, 20);
		panel_1.add(tfId);
		
		JLabel label_1 = new JLabel("C\u00F3digo do Im\u00F3vel:");
		label_1.setBounds(10, 42, 103, 14);
		panel_1.add(label_1);
		
		tfIdImovel = new JTextField();
		tfIdImovel.setBackground(new Color(173, 255, 47));
		tfIdImovel.setEnabled(false);
		tfIdImovel.setColumns(10);
		tfIdImovel.setBounds(154, 36, 46, 20);
		panel_1.add(tfIdImovel);
		
		btnPesquisarImovel = new JButton("");
		btnPesquisarImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConImovelProcuracao().setVisible(true);
				if (MovProcuracao.this.isShowing()) {
					
					fecharSemMenu = true;	
					
				}
			}
		});
		btnPesquisarImovel.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Zoom-icon.png")));
		btnPesquisarImovel.setToolTipText("Pesquisar");
		btnPesquisarImovel.setOpaque(false);
		btnPesquisarImovel.setFocusPainted(false);
		btnPesquisarImovel.setBackground(new Color(240, 240, 241));
		btnPesquisarImovel.setBounds(210, 36, 29, 20);
		panel_1.add(btnPesquisarImovel);
		
		JLabel lblEndereoImvel = new JLabel("Endere\u00E7o Im\u00F3vel:");
		lblEndereoImvel.setBounds(10, 92, 103, 14);
		panel_1.add(lblEndereoImvel);
		
		tfEnderecoImovel = new JTextField();
		tfEnderecoImovel.setEnabled(false);
		tfEnderecoImovel.setColumns(10);
		tfEnderecoImovel.setBounds(154, 86, 205, 20);
		panel_1.add(tfEnderecoImovel);
		
		JLabel lblNmeroImvel = new JLabel("N\u00FAmero Im\u00F3vel:");
		lblNmeroImvel.setBounds(10, 117, 103, 14);
		panel_1.add(lblNmeroImvel);
		
		tfNumeroImovel = new JTextField();
		tfNumeroImovel.setEnabled(false);
		tfNumeroImovel.setColumns(10);
		tfNumeroImovel.setBounds(154, 111, 46, 20);
		panel_1.add(tfNumeroImovel);
		
		JLabel lblComplementoImvel = new JLabel("Complemento Im\u00F3vel:");
		lblComplementoImvel.setBounds(10, 142, 134, 14);
		panel_1.add(lblComplementoImvel);
		
		tfComplementoImovel = new JTextField();
		tfComplementoImovel.setEnabled(false);
		tfComplementoImovel.setColumns(10);
		tfComplementoImovel.setBounds(154, 136, 168, 20);
		panel_1.add(tfComplementoImovel);
		
		JLabel lblBairroImvel = new JLabel("Bairro Im\u00F3vel:");
		lblBairroImvel.setBounds(10, 167, 103, 14);
		panel_1.add(lblBairroImvel);
		
		tfBairroImovel = new JTextField();
		tfBairroImovel.setEnabled(false);
		tfBairroImovel.setColumns(10);
		tfBairroImovel.setBounds(154, 161, 168, 20);
		panel_1.add(tfBairroImovel);
		
		JLabel label_6 = new JLabel("C\u00F3digo do Propriet\u00E1rio:");
		label_6.setBounds(10, 192, 131, 14);
		panel_1.add(label_6);
		
		tfIdProprietario = new JTextField();
		tfIdProprietario.setEnabled(false);
		tfIdProprietario.setColumns(10);
		tfIdProprietario.setBounds(154, 186, 46, 20);
		panel_1.add(tfIdProprietario);
		
		JLabel label_7 = new JLabel("Nome do Propriet\u00E1rio:");
		label_7.setBounds(10, 217, 131, 14);
		panel_1.add(label_7);
		
		tfNomeProprietario = new JTextField();
		tfNomeProprietario.setEnabled(false);
		tfNomeProprietario.setColumns(10);
		tfNomeProprietario.setBounds(154, 211, 205, 20);
		panel_1.add(tfNomeProprietario);
		
		JLabel label_8 = new JLabel("Situa\u00E7\u00E3o da Assinatura:");
		label_8.setBounds(377, 242, 145, 14);
		panel_1.add(label_8);
		
		
		JLabel lblDataDeAssinatura = new JLabel("Data de Assinatura:");
		lblDataDeAssinatura.setBounds(377, 267, 131, 14);
		panel_1.add(lblDataDeAssinatura);
		
		tfDataAssinatura = new JFormattedTextField();
		tfDataAssinatura.setEnabled(true);
		tfDataAssinatura.setBounds(518, 261, 86, 20);
		panel_1.add(tfDataAssinatura);
		tfDataAssinatura.setColumns(10);
		
		cbSituacao = new JComboBox();
		cbSituacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbSituacao.getSelectedItem().equals("Assinado") || (cbSituacao.getSelectedItem().equals("Finalizado"))) {
					tfDataAssinatura.setBackground(new Color(173, 255, 47));
					if (!tfDataAssinatura.getText().isEmpty()) {
					auxData = tfDataAssinatura.getText();
					}
//					if (tfDataAssinatura.getText().equals("")) {
//						tfDataAssinatura.setFormatterFactory(new DefaultFormatterFactory(mascaraData));	
//					}
					
				} else {
					tfDataAssinatura.setBackground(new Color(255, 255, 255));
					
				}
				if (cbSituacao.getSelectedItem().equals("Em Aberto")) {
					tfDataAssinatura.setText(null);
					tfDataAssinatura.setEnabled(false);
					tfDataAssinatura.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
				}
				if (cbSituacao.getSelectedItem().equals("Cancelado") && (!tfDataAssinatura.getText().isEmpty())) {
//					auxData = tfDataAssinatura.getText();
				}
				
				if (cbSituacao.getSelectedItem().equals("Cancelado")) {
					tfDataAssinatura.setText(null);
					tfDataAssinatura.setEnabled(false);
					tfDataAssinatura.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
				}
				
				if (cbSituacao.getSelectedItem().equals("Assinado")) {
					tfDataAssinatura.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
					tfDataAssinatura.setText(auxData);
					tfDataAssinatura.setEnabled(true);
					tfDataAssinatura.requestFocus();
				}
				if (cbSituacao.getSelectedItem().equals("Finalizado")) {
					tfDataAssinatura.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
					tfDataAssinatura.setText(auxData);
					tfDataAssinatura.setEnabled(true);
					tfDataAssinatura.requestFocus();
				}
				
			}
		});
		cbSituacao.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Assinado", "Cancelado", "Finalizado"}));
		cbSituacao.setMaximumRowCount(4);
		cbSituacao.setBounds(518, 236, 113, 20);
		
		panel_1.add(cbSituacao);
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConProcuracao().setVisible(true);
				aberto = false;
				fecharSemMenu2 = false;
				if (MovProcuracao.this.isShowing()) {
					aberto = true;
					fecharSemMenu2 = true;
				}
			}
		});
		btnPesquisar.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Zoom-icon.png")));
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setOpaque(false);
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setBackground(new Color(240, 240, 241));
		btnPesquisar.setBounds(210, 11, 29, 20);
		panel_1.add(btnPesquisar);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 242, 46, 14);
		panel_1.add(lblCnpj);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 267, 46, 14);
		panel_1.add(lblCpf);
		
		tfCnpj = new JTextField();
		tfCnpj.setEnabled(false);
		tfCnpj.setBounds(154, 236, 168, 20);
		panel_1.add(tfCnpj);
		tfCnpj.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(false);
		tfCpf.setBounds(154, 261, 169, 20);
		panel_1.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblTipoDePessoa = new JLabel("Tipo de Pessoa:");
		lblTipoDePessoa.setBounds(10, 292, 103, 14);
		panel_1.add(lblTipoDePessoa);
		
		cbTipoPessoa = new JComboBox();
		cbTipoPessoa.setEnabled(false);
		cbTipoPessoa.setModel(new DefaultComboBoxModel(new String[] {"", "F\u00EDsica", "Jur\u00EDdica"}));
		cbTipoPessoa.setBounds(154, 286, 86, 20);
		cbTipoPessoa.setSelectedItem(null);
		panel_1.add(cbTipoPessoa);
		
		JLabel lblEstadoCvil = new JLabel("Estado C\u00EDvil:");
		lblEstadoCvil.setBounds(10, 317, 86, 14);
		panel_1.add(lblEstadoCvil);
		
		JLabel lblNewLabel = new JLabel("Nome C\u00F4njuge:");
		lblNewLabel.setBounds(377, 142, 86, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblCpfCnjuge = new JLabel("CPF C\u00F4njuge:");
		lblCpfCnjuge.setBounds(377, 167, 86, 14);
		panel_1.add(lblCpfCnjuge);
		
		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setEnabled(false);
		cbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"", "Solteiro(a)", "Casado(a)", "Divorciado(a)", "V\u00EDuvo(a)"}));
		cbEstadoCivil.setBounds(154, 311, 86, 20);
		cbEstadoCivil.setSelectedItem(null);
		panel_1.add(cbEstadoCivil);
		
		tfNomeConjuge = new JTextField();
		tfNomeConjuge.setEnabled(false);
		tfNomeConjuge.setBounds(467, 136, 212, 20);
		panel_1.add(tfNomeConjuge);
		tfNomeConjuge.setColumns(10);
		
		tfCpfConjuge = new JTextField();
		tfCpfConjuge.setEnabled(false);
		tfCpfConjuge.setBounds(467, 161, 168, 20);
		panel_1.add(tfCpfConjuge);
		tfCpfConjuge.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(377, 17, 86, 14);
		panel_1.add(lblEndereo);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(377, 42, 80, 14);
		panel_1.add(lblNmero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(377, 67, 46, 14);
		panel_1.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(377, 92, 46, 14);
		panel_1.add(lblCidade);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(377, 117, 46, 14);
		panel_1.add(lblUf);
		
		tfEnderecoProprietario = new JTextField();
		tfEnderecoProprietario.setEnabled(false);
		tfEnderecoProprietario.setBounds(467, 11, 86, 20);
		panel_1.add(tfEnderecoProprietario);
		tfEnderecoProprietario.setColumns(10);
		
		tfNumeroProprietario = new JTextField();
		tfNumeroProprietario.setEnabled(false);
		tfNumeroProprietario.setBounds(467, 36, 86, 20);
		panel_1.add(tfNumeroProprietario);
		tfNumeroProprietario.setColumns(10);
		
		tfBairroProprietario = new JTextField();
		tfBairroProprietario.setEnabled(false);
		tfBairroProprietario.setBounds(467, 61, 86, 20);
		panel_1.add(tfBairroProprietario);
		tfBairroProprietario.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setEnabled(false);
		tfCidade.setBounds(467, 86, 86, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		
		cbUf = new JComboBox();
		cbUf.setEnabled(false);
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUf.setBounds(467, 111, 55, 20);
		cbUf.setSelectedItem(null);
		panel_1.add(cbUf);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Im\u00F3vel:");
		lblNewLabel_1.setBounds(10, 67, 103, 14);
		panel_1.add(lblNewLabel_1);
		
		tfTipoImovel = new JTextField();
		tfTipoImovel.setEnabled(false);
		tfTipoImovel.setBounds(154, 61, 131, 20);
		panel_1.add(tfTipoImovel);
		tfTipoImovel.setColumns(10);
		
		btnNovoImovel = new JButton("");
		btnNovoImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovProcuracao.this.dispose();
				new CadImovel().setVisible(true);
			}
		});
		btnNovoImovel.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Files-New-File-icon.png")));
		btnNovoImovel.setToolTipText("Pesquisar");
		btnNovoImovel.setOpaque(false);
		btnNovoImovel.setFocusPainted(false);
		btnNovoImovel.setBackground(new Color(240, 240, 241));
		btnNovoImovel.setBounds(244, 36, 29, 20);
		panel_1.add(btnNovoImovel);
		
		btnGerarContrato = new JButton("");
		btnGerarContrato.setEnabled(false);
		btnGerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (cbTipoPessoa.getSelectedItem().equals("Jurídica")) {
						ProcuracaoDAO.GerarContratoJuridica();
					}
					else if (cbTipoPessoa.getSelectedItem().equals("Física") && (cbEstadoCivil.getSelectedItem().equals("Casado(a)"))) {
						ProcuracaoDAO.GerarContratoFisicaCompleto();
					}
					else {
						ProcuracaoDAO.GerarContratoFisicaSolteiro();
					}
					
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnGerarContrato.setIcon(new ImageIcon(MovProcuracao.class.getResource("/Imagens/Text-align-right-icon.png")));
		btnGerarContrato.setToolTipText("Visualizar Contrato");
		btnGerarContrato.setOpaque(false);
		btnGerarContrato.setFocusPainted(false);
		btnGerarContrato.setBackground(new Color(240, 240, 241));
		btnGerarContrato.setBounds(377, 286, 86, 47);
		panel_1.add(btnGerarContrato);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cláusulas Adicionais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblClusualasAdicionais = new JLabel("Cl\u00E1usualas Adicionais:");
		lblClusualasAdicionais.setBounds(10, 11, 138, 14);
		panel_2.add(lblClusualasAdicionais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 669, 272);
		panel_2.add(scrollPane);
		
		tfClausulas = new JTextArea();
		scrollPane.setViewportView(tfClausulas);
		
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		//DEIXAR POR ULTIMO NO CÓDIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {tfDataAssinatura.requestFocus();}  
	    });
		
}
	
	boolean VerificarCampos(boolean b) {
		Date dataAtualSistema = new Date(System.currentTimeMillis());
		DateFormat formatDate;
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (!tfDataAssinatura.getText().isEmpty()) {
			dataAtual = formatDate.parse(tfDataAssinatura.getText());
			} else {
				dataAtual = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (tfIdImovel.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo ID do Imóvel deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfIdImovel.requestFocus();
				return false;
			 } else if ((cbSituacao.getSelectedItem().equals("Assinado") || cbSituacao.getSelectedItem().equals("Finalizado")) && tfDataAssinatura.getText().isEmpty()){
				 	JOptionPane.showMessageDialog(null, "O Campo Data de Assinatura deve ser preenchida quando a situação do contrato for igual a Assinado ou Finalizado! Se a Situação atual for igual a 'Em Aberto' tente colocar como Cancelado!");
					tabbedPane.setSelectedIndex(0);
					tfDataAssinatura.requestFocus();
					return false;
			 } else if ((cbSituacao.getSelectedItem().equals("Cancelado") || cbSituacao.getSelectedItem().equals("Em Aberto")) && !tfDataAssinatura.getText().isEmpty()) {
				 JOptionPane.showMessageDialog(null, "A Data de Assinatura só pode ser preenchida quando a situação for igual a Assinado ou Finalizado! Se a Situação for igual a 'Em Aberto' tente colocar como Cancelado!");
				 	tabbedPane.setSelectedIndex(0);
					return false;
			 } else if ((dataAtual != null) && (dataAtual.after(dataAtualSistema)) && (!tfDataAssinatura.getText().isEmpty())){
				 JOptionPane.showMessageDialog(null, "A Data de Assinatura não pode ser maior que a data atual!");
				 tabbedPane.setSelectedIndex(0);
				 tfDataAssinatura.requestFocus();
				 	return false;
			 } 
				else {	
					return true;
						}
				}
	
	public void LimparDados() {
		tfId.setText("");
		tfIdImovel.setText("");
		tfIdProprietario.setText("");
		tfBairroImovel.setText("");
		tfClausulas.setText("");
		tfComplementoImovel.setText("");
		tfDataAssinatura.setText("");
		tfEnderecoImovel.setText("");
		tfNomeProprietario.setText("");
		tfNumeroImovel.setText("");
		cbSituacao.setSelectedIndex(0);
		tfDataAssinatura.requestFocus();
		tfTipoImovel.setText("");
		tfCpf.setText("");
		tfEnderecoProprietario.setText("");
		tfNumeroProprietario.setText("");
		tfBairroProprietario.setText("");
		tfCidade.setText("");
		cbTipoPessoa.setSelectedItem(null);
		cbUf.setSelectedItem(null);
		cbEstadoCivil.setSelectedItem(null);
		tfNomeConjuge.setText("");
		tfCpfConjuge.setText("");
		btnSalvar.setEnabled(true);
		cbSituacao.setEnabled(true);
		tfDataAssinatura.setEnabled(false);
		btnPesquisarImovel.setEnabled(true);
		btnGerarContrato.setEnabled(false);
		tfCnpj.setText("");
		
	}
	
	public static void SetarImovel(ImovelProcConsulta imovelProcConsulta) {
		String aux = Integer.toString(imovelProcConsulta.getId());
		String aux2 = Integer.toString(imovelProcConsulta.getNumeroImovel());
		String aux3 = Integer.toString(imovelProcConsulta.getIdProprietario());
		String aux4 = Integer.toString(imovelProcConsulta.getNumeroProprietario());
		tfIdImovel.setText(aux);
		tfTipoImovel.setText(imovelProcConsulta.getNomeTipoImovel());
		tfEnderecoImovel.setText(imovelProcConsulta.getEnderecoImovel());
		tfNumeroImovel.setText(aux2);
		tfComplementoImovel.setText(imovelProcConsulta.getComplementoImovel());
		tfBairroImovel.setText(imovelProcConsulta.getBairroImovel());
		tfIdProprietario.setText(aux3);
		cbTipoPessoa.setSelectedItem(imovelProcConsulta.getTipoPessoaProprietario());
		if (imovelProcConsulta.getTipoPessoaProprietario().equals("Física")) {
			tfNomeProprietario.setText(imovelProcConsulta.getNomeProprietario());
		} else {
			tfNomeProprietario.setText(imovelProcConsulta.getRazaoSocialProprietario());
		}
		if (imovelProcConsulta.getTipoPessoaProprietario().equals("Física")) {
			tfCpf.setText(imovelProcConsulta.getCpfProprietario());
		} else {
			tfCnpj.setText(imovelProcConsulta.getCnpjProprietario());
		}
		cbEstadoCivil.setSelectedItem(imovelProcConsulta.getEstadoCivilProprietario());
		tfEnderecoProprietario.setText(imovelProcConsulta.getEnderecoProprietario());
		tfNumeroProprietario.setText(aux4);
		tfBairroProprietario.setText(imovelProcConsulta.getBairroProprietario());
		tfCidade.setText(imovelProcConsulta.getNomeCidade());
		cbUf.setSelectedItem(imovelProcConsulta.getUfCidade());
//		if ((cbEstadoCivil.getSelectedItem().equals(null)) && imovelProcConsulta.getEstadoCivilProprietario().equals("Casado(a)")) {
			tfNomeConjuge.setText(imovelProcConsulta.getNomeConjuge());
			tfCpfConjuge.setText(imovelProcConsulta.getCpfConjuge());
//		}
		
	}
	
	public static void SetarDados(ProcuracaoConsulta procuracaoConsulta) {
		String aux = Integer.toString(procuracaoConsulta.getIdImovel());
		String aux2 = Integer.toString(procuracaoConsulta.getNumeroImovel());
		String aux3 = Integer.toString(procuracaoConsulta.getIdProprietario());
		String aux4 = Integer.toString(procuracaoConsulta.getNumeroProprietario());
		String aux5 = Integer.toString(procuracaoConsulta.getId());
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if ((procuracaoConsulta.getDataAssinaturaProcuracao() != null)) {
				result = out.format(in.parse(procuracaoConsulta.getDataAssinaturaProcuracao().toString()));
			} else {
				result = "";
			}
				
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tfId.setText(aux5);
		tfIdImovel.setText(aux);
		tfTipoImovel.setText(procuracaoConsulta.getNomeTipoImovel());
		tfEnderecoImovel.setText(procuracaoConsulta.getEnderecoImovel());
		tfNumeroImovel.setText(aux2);
		tfComplementoImovel.setText(procuracaoConsulta.getComplementoImovel());
		tfBairroImovel.setText(procuracaoConsulta.getBairroImovel());
		tfIdProprietario.setText(aux3);
		cbTipoPessoa.setSelectedItem(procuracaoConsulta.getTipoPessoaProprietario());
		if (procuracaoConsulta.getTipoPessoaProprietario().equals("Física")) {
			tfNomeProprietario.setText(procuracaoConsulta.getNomeProprietario());
		} else {
			tfNomeProprietario.setText(procuracaoConsulta.getRazaoSocialProprietario());
		}
		if (procuracaoConsulta.getTipoPessoaProprietario().equals("Física")) {
			tfCpf.setText(procuracaoConsulta.getCpfProprietario());
		} else {
			tfCnpj.setText(procuracaoConsulta.getCnpjProprietario());
		}
		cbEstadoCivil.setSelectedItem(procuracaoConsulta.getEstadoCivilProprietario());
		tfEnderecoProprietario.setText(procuracaoConsulta.getEnderecoProprietario());
		tfNumeroProprietario.setText(aux4);
		tfBairroProprietario.setText(procuracaoConsulta.getBairroProprietario());
		tfCidade.setText(procuracaoConsulta.getNomeCidade());
		cbUf.setSelectedItem(procuracaoConsulta.getUfCidade());
//		if (procuracaoConsulta.getEstadoCivilProprietario().equals("Casado(a)")) {
			tfNomeConjuge.setText(procuracaoConsulta.getNomeConjuge());
			tfCpfConjuge.setText(procuracaoConsulta.getCpfConjuge());
//		}
		tfClausulas.setText(procuracaoConsulta.getClausulas());
		cbSituacao.setSelectedItem(procuracaoConsulta.getSituacao());
		tfDataAssinatura.setText(result);

		
		if ((cbSituacao.getSelectedItem().equals("Cancelado") || cbSituacao.getSelectedItem().equals("Finalizado")) && (!tfId.getText().isEmpty())) {
			btnSalvar.setEnabled(false);
			cbSituacao.setEnabled(false);
			tfDataAssinatura.setEnabled(false);
			btnPesquisarImovel.setEnabled(false);
			
		}
		
		if (ProcuracaoConsulta.getValidacaoAssinatura().equals("Assinado")) {
			btnGerarContrato.setEnabled(true);
		} else {
			btnGerarContrato.setEnabled(false);
		}
		
		
	}
	
	public void AtualizarImovel() {
		if (cbSituacao.getSelectedItem().equals("Assinado") || (cbSituacao.getSelectedItem().equals("Em Aberto"))) {
			int id = Integer.parseInt(tfIdImovel.getText());
			String ativo = "Ativo";
			Imovel imovel = new Imovel();
			ImovelDAO.AtualizarImovel(imovel, id, ativo);
		} else {
			int id = Integer.parseInt(tfIdImovel.getText());
			String ativo = "Inativo";
			Imovel imovel = new Imovel();
			ImovelDAO.AtualizarImovel(imovel, id, ativo);
		}
	}
	
}
