package proprietario;
import imovel.CadImovel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import menu.MenuPrincipal;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import cidade.CadCidade;
import cidade.Cidade;
import cidade.ConCidade;

import com.mysql.jdbc.Connection;

import javax.swing.JFormattedTextField;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;



public class CadProprietario extends JFrame {

	private JPanel contentPane;
	private static JTextField tfId;
	private static JTextField tfProfissao;
	private static JTextField tfNome;
	private static JTextField tfEndereco;
	private static JTextField tfNumero;
	private static JTextField tfComplemento;
	private static JTextField tfEmail;
	private static JFormattedTextField tfTelefoneCelular;
	private static JFormattedTextField tfTelefoneFixo;
	private static JFormattedTextField tfCPF;
	private static JTextField tfRG;
	private static JFormattedTextField tfDataNascimento;
	private static JFormattedTextField tfDataExpedicao;
	private static JFormattedTextField tfCNPJ;
	private static JTextField tfRazaoSocial;
	private static JTextField tfBanco;
	private static JTextField tfAgencia;
	private static JTextField tfContaBancaria;
	private static JTextField tfNomeCheque;
	private static JFormattedTextField tfChequeCPF;
	private static JTextField tfNomeConjuge;
	private static JTextField tfProfissaoConjuge;
	private static JTextField tfRGConjuge;
	private static JFormattedTextField tfCPFConjuge;
	private static JFormattedTextField tfDataNascimentoConjuge;
	private static JTextField tfBairro;
	private static JTextField tfEnderecoComercial;
	private static JTextField tfNumeroComercial;
	private static JTextField tfComplementoComercial;
	private static JTextField tfBairroComercial;
	private static JTextField tfEmpresa;
	private static JFormattedTextField tfTelefoneComercial;
	private static JTextField tfIdCidade;
	private static Date dataNasc, dataExp, dataNascConj;
	private static Date dataNula;
	private Date dataAtual, dataAtual2, dataAtual3;
	private static String result, result2, result3;
	
	public static boolean visivel;
	
	static JButton btnExcluir;
	private Connection conn;
	private Proprietario proprietario;
	private static JComboBox cbTipoConta;
	private static JComboBox cbTipo;
	private static JComboBox cbRegime;
	private static JComboBox cbEstado;
	private boolean ver;
	private static JTabbedPane tabbedPane;
	private String casado, fis;
	private Date data = null, data2 = null, data3 = null;
	private JPanel panel_3;
	
	public static boolean fecharSemMenu, fecharSemMenu2, aberto;
	
	private MaskFormatter mascaraData;
	private static MaskFormatter mascaraVazia;
	private MaskFormatter mascaraCPF, mascaraCNPJ;
	private MaskFormatter mascaraTelefone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProprietario frame = new CadProprietario();
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
	public CadProprietario() {
		
		try {
			mascaraVazia = new MaskFormatter("");
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##) ####-####");
			mascaraData.setPlaceholderCharacter('_');
			mascaraTelefone.setPlaceholderCharacter('_');
			mascaraCPF.setPlaceholderCharacter('_');
			mascaraCNPJ.setPlaceholderCharacter('_');
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		visivel = false;
		setTitle("Cadastro de Propriet\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 357, 704, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 707, 358);
		tabbedPane.setToolTipText("");
		
		contentPane.add(tabbedPane);
	
		
		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações Pessoais", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 17, 46, 14);
		panel_1.add(lblCdigo);
		
		tfId = new JTextField();
		tfId.setBounds(104, 11, 86, 20);
		panel_1.add(tfId);
		tfId.setColumns(10);
		tfId.setEnabled(false);
		
		JLabel lblNome = new JLabel("Tipo de Pessoa:");
		lblNome.setBounds(10, 67, 99, 14);
		panel_1.add(lblNome);
		
		tfProfissao = new JTextField();
		tfProfissao.setBackground(new Color(173, 255, 47));
		tfProfissao.setColumns(10);
		tfProfissao.setBounds(104, 290, 226, 20);
		panel_1.add(tfProfissao);
		
		JLabel lblEndereo = new JLabel("Nome:");
		lblEndereo.setBounds(10, 92, 62, 14);
		panel_1.add(lblEndereo);
		
		tfNome = new JTextField();
		tfNome.setBackground(new Color(173, 255, 47));
		tfNome.setBounds(104, 86, 226, 20);
		panel_1.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Endere\u00E7o:");
		lblComplemento.setBounds(10, 117, 86, 14);
		panel_1.add(lblComplemento);
		
		tfEndereco = new JTextField();
		tfEndereco.setBackground(new Color(173, 255, 47));
		tfEndereco.setBounds(104, 114, 226, 20);
		panel_1.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("N\u00FAmero:");
		lblBairro.setBounds(10, 142, 86, 14);
		panel_1.add(lblBairro);
		
		tfNumero = new JTextField();
		tfNumero.setBackground(new Color(173, 255, 47));
		tfNumero.setBounds(104, 139, 46, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblTelefoneFixo = new JLabel("Email:");
		lblTelefoneFixo.setBounds(10, 217, 86, 14);
		panel_1.add(lblTelefoneFixo);
		
		tfComplemento = new JTextField();
		tfComplemento.setBounds(104, 164, 226, 20);
		panel_1.add(tfComplemento);
		tfComplemento.setColumns(10);
		
		JLabel lblCelular = new JLabel("Telefone Fixo:");
		lblCelular.setBounds(10, 242, 86, 14);
		panel_1.add(lblCelular);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(104, 214, 165, 20);
		panel_1.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfTelefoneCelular = new JFormattedTextField(mascaraTelefone);
		tfTelefoneCelular.setBackground(new Color(173, 255, 47));
		tfTelefoneCelular.setBounds(104, 265, 99, 20);
		panel_1.add(tfTelefoneCelular);
		tfTelefoneCelular.setColumns(10);
		
		JLabel lblEmail = new JLabel("Complemento:");
		lblEmail.setBounds(10, 167, 99, 14);
		panel_1.add(lblEmail);
		
		tfTelefoneFixo = new JFormattedTextField();
		tfTelefoneFixo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfTelefoneFixo.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfTelefoneFixo.getText().equals("(__) ____-____")) {
					tfTelefoneFixo.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
				}
			}
		});
		tfTelefoneFixo.setBounds(104, 240, 99, 20);
		panel_1.add(tfTelefoneFixo);
		tfTelefoneFixo.setColumns(10);
		
		JLabel lblProfisso = new JLabel("Celular:");
		lblProfisso.setBounds(10, 267, 62, 14);
		panel_1.add(lblProfisso);
		
		JLabel lblTipoDePessoa = new JLabel("Profiss\u00E3o:");
		lblTipoDePessoa.setBounds(10, 292, 99, 14);
		panel_1.add(lblTipoDePessoa);
		
		tfDataExpedicao = new JFormattedTextField();
		tfDataExpedicao.setBackground(new Color(173, 255, 47));
		tfDataExpedicao.setBounds(457, 86, 86, 20);
		panel_1.add(tfDataExpedicao);
		tfDataExpedicao.setColumns(10);
		
		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTipo.getSelectedItem().equals("Física")) {
					tfCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
					tfCNPJ.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
					tfDataExpedicao.setBackground(new Color(173, 255, 47));
					tfRG.setBackground(new Color(173, 255, 47));
					tfCPF.setBackground(new Color(173, 255, 47));
					tfDataNascimento.setBackground(new Color(173, 255, 47));
					tfCNPJ.setBackground(new Color(255, 255, 255));
					tfRazaoSocial.setBackground(new Color(255, 255, 255));
				} else {
					tfCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
					tfCNPJ.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
					tfCNPJ.setBackground(new Color(173, 255, 47));
					tfRazaoSocial.setBackground(new Color(173, 255, 47));
					tfCPF.setBackground(new Color(255, 255, 255));
					tfRG.setBackground(new Color(255, 255, 255));
					tfDataExpedicao.setBackground(new Color(255, 255, 255));
					tfDataNascimento.setBackground(new Color(255, 255, 255));
				}
				tfCPF.setText("");
				tfRG.setText("");
				cbEstado.setEnabled(true);
				cbEstado.setSelectedIndex(0);
				HabilitarCamposTipoPessoa();
				HabilitarConjuge();
			}

			
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		cbTipo.setBounds(104, 61, 87, 20);
		panel_1.add(cbTipo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(350, 17, 46, 14);
		panel_1.add(lblCpf);
		
		tfCPF = new JFormattedTextField(mascaraCPF);
		tfCPF.setBackground(new Color(173, 255, 47));
		tfCPF.setBounds(457, 11, 132, 20);
		panel_1.add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(350, 42, 46, 14);
		panel_1.add(lblRg);
		
		tfRG = new JTextField();
		tfRG.setBackground(new Color(173, 255, 47));
		tfRG.setBounds(457, 36, 132, 20);
		panel_1.add(tfRG);
		tfRG.setColumns(10);
		
		tfDataNascimento = new JFormattedTextField();
		tfDataNascimento.setBackground(new Color(173, 255, 47));
		tfDataNascimento.setBounds(457, 61, 86, 20);
		panel_1.add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(350, 67, 106, 14);
		panel_1.add(lblDataNascimento);
		
		
		
		JLabel lblDataExpedio = new JLabel("Data Expedi\u00E7\u00E3o:");
		lblDataExpedio.setBounds(350, 92, 97, 14);
		panel_1.add(lblDataExpedio);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(350, 167, 46, 14);
		panel_1.add(lblCnpj);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(350, 192, 97, 14);
		panel_1.add(lblRazoSocial);
		
		tfCNPJ = new JFormattedTextField();
		tfCNPJ.setBounds(457, 164, 132, 20);
		panel_1.add(tfCNPJ);
		tfCNPJ.setColumns(10);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(457, 189, 206, 20);
		panel_1.add(tfRazaoSocial);
		tfRazaoSocial.setColumns(10);
		
		JLabel lblEstadoCvil = new JLabel("Estado C\u00EDvil:");
		lblEstadoCvil.setBounds(350, 117, 86, 14);
		panel_1.add(lblEstadoCvil);
		
		cbEstado = new JComboBox();
		cbEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((cbEstado.isEnabled()) && (cbEstado.getSelectedItem().equals("Casado(a)"))) {
					tfNomeConjuge.setBackground(new Color(173, 255, 47));
					tfCPFConjuge.setBackground(new Color(173, 255, 47));
					tfRGConjuge.setBackground(new Color(173, 255, 47));
					tfProfissaoConjuge.setBackground(new Color (173, 255, 47));
					tfDataNascimentoConjuge.setBackground(new Color(173, 255, 47));
				} else {
					tfNomeConjuge.setBackground(new Color(255, 255, 255));
					tfCPFConjuge.setBackground(new Color(255, 255, 255));
					tfRGConjuge.setBackground(new Color(255, 255, 255));
					tfProfissaoConjuge.setBackground(new Color (255, 255, 255));
					tfDataNascimentoConjuge.setBackground(new Color(255, 255, 255));
				}
				
				HabilitarConjuge();
				  
			}
		});
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"Solteiro(a)", "Casado(a)", "Divorciado(a)", "V\u00EDuvo(a)"}));
		cbEstado.setBounds(457, 114, 133, 20);
		panel_1.add(cbEstado);
		
		JLabel lblEmail_1 = new JLabel("Bairro:");
		lblEmail_1.setBounds(10, 192, 46, 14);
		panel_1.add(lblEmail_1);
		
		tfBairro = new JTextField();
		tfBairro.setBackground(new Color(173, 255, 47));
		tfBairro.setBounds(104, 189, 165, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCdigoCidade = new JLabel("C\u00F3digo Cidade:");
		lblCdigoCidade.setBounds(10, 42, 140, 14);
		panel_1.add(lblCdigoCidade);
		
		tfIdCidade = new JTextField();
		tfIdCidade.setBackground(new Color(173, 255, 47));
		tfIdCidade.setColumns(10);
		tfIdCidade.setBounds(104, 36, 86, 20);
		panel_1.add(tfIdCidade);
		tfIdCidade.setEnabled(false);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConProprietario().setVisible(true);
				fecharSemMenu2 = false;
				CadImovel.fecharSemMenu = false;
				aberto = false;
				if (CadProprietario.this.isShowing()) {
					fecharSemMenu2 = true;
					aberto = true;
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Zoom-icon.png")));
		btnConsultar.setToolTipText("Pesquisar");
		btnConsultar.setOpaque(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBackground(new Color(240, 240, 241));
		btnConsultar.setBounds(200, 11, 29, 20);
		panel_1.add(btnConsultar);
		
		JButton btnConsultarCidade = new JButton("");
		btnConsultarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visivel = true;
				new ConCidade().setVisible(true);
				
				if (CadProprietario.this.isShowing()) {
					fecharSemMenu = true;
				}

			}
		});
		btnConsultarCidade.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Zoom-icon.png")));
		btnConsultarCidade.setToolTipText("Pesquisar Cidade");
		btnConsultarCidade.setOpaque(false);
		btnConsultarCidade.setFocusPainted(false);
		btnConsultarCidade.setBackground(new Color(240, 240, 241));
		btnConsultarCidade.setBounds(200, 38, 29, 20);
		panel_1.add(btnConsultarCidade);
		
		JButton btnCadastrarCidade = new JButton("");
		btnCadastrarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadProprietario.this.dispose();
				new CadCidade().setVisible(true);
			}
		});
		btnCadastrarCidade.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Files-New-File-icon.png")));
		btnCadastrarCidade.setToolTipText("Adicionar um Novo Tipo de Imovel");
		btnCadastrarCidade.setOpaque(false);
		btnCadastrarCidade.setFocusPainted(false);
		btnCadastrarCidade.setBackground(new Color(240, 240, 241));
		btnCadastrarCidade.setBounds(239, 38, 29, 20);
		panel_1.add(btnCadastrarCidade);
		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Informações Comerciais", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o Comercial:");
		lblNewLabel_1.setBounds(10, 11, 128, 14);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblComplementoComercial = new JLabel("N\u00FAmero Comercial:");
		lblComplementoComercial.setBounds(10, 36, 115, 14);
		panel_4.add(lblComplementoComercial);
		
		JLabel lblBairroComercial = new JLabel("Complemento Comercial:");
		lblBairroComercial.setBounds(10, 61, 153, 14);
		panel_4.add(lblBairroComercial);
		
		JLabel lblTelefoneComercial = new JLabel("Bairro Comercial:");
		lblTelefoneComercial.setBounds(10, 86, 115, 14);
		panel_4.add(lblTelefoneComercial);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 111, 115, 14);
		panel_4.add(lblEmpresa);
		
		JLabel lblEmpresa_1 = new JLabel("Telefone Comercial:");
		lblEmpresa_1.setBounds(10, 136, 115, 14);
		panel_4.add(lblEmpresa_1);
		
		tfEnderecoComercial = new JTextField();
		tfEnderecoComercial.setBounds(156, 5, 257, 20);
		panel_4.add(tfEnderecoComercial);
		tfEnderecoComercial.setColumns(10);
		
		tfNumeroComercial = new JTextField();
		tfNumeroComercial.setColumns(10);
		tfNumeroComercial.setBounds(156, 30, 43, 20);
		panel_4.add(tfNumeroComercial);
		
		tfComplementoComercial = new JTextField();
		tfComplementoComercial.setColumns(10);
		tfComplementoComercial.setBounds(156, 55, 188, 20);
		panel_4.add(tfComplementoComercial);
		
		tfBairroComercial = new JTextField();
		tfBairroComercial.setColumns(10);
		tfBairroComercial.setBounds(156, 80, 188, 20);
		panel_4.add(tfBairroComercial);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setColumns(10);
		tfEmpresa.setBounds(156, 105, 188, 20);
		panel_4.add(tfEmpresa);
		
		tfTelefoneComercial = new JFormattedTextField();
		tfTelefoneComercial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTelefoneComercial.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfTelefoneComercial.getText().equals("(__) ____-____")) {
				tfTelefoneComercial.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
			}
			}
		});
		
		
		
		tfTelefoneComercial.setColumns(10);
		tfTelefoneComercial.setBounds(156, 130, 98, 20);
		panel_4.add(tfTelefoneComercial);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Cônjuge", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(10, 11, 46, 14);
		panel_3.add(lblNome_1);
		
		JLabel lblProfisso_1 = new JLabel("Profiss\u00E3o:");
		lblProfisso_1.setBounds(10, 36, 79, 14);
		panel_3.add(lblProfisso_1);
		
		JLabel lblRegimeDeBens = new JLabel("Regime de Bens:");
		lblRegimeDeBens.setBounds(10, 61, 96, 14);
		panel_3.add(lblRegimeDeBens);
		
		tfNomeConjuge = new JTextField();
		tfNomeConjuge.setBounds(139, 5, 245, 20);
		panel_3.add(tfNomeConjuge);
		tfNomeConjuge.setColumns(10);
		
		tfProfissaoConjuge = new JTextField();
		tfProfissaoConjuge.setBounds(139, 30, 190, 20);
		panel_3.add(tfProfissaoConjuge);
		tfProfissaoConjuge.setColumns(10);
		
		JLabel lblRg_1 = new JLabel("RG:");
		lblRg_1.setBounds(10, 86, 46, 14);
		panel_3.add(lblRg_1);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setBounds(10, 111, 46, 14);
		panel_3.add(lblCpf_1);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 136, 120, 14);
		panel_3.add(lblDataDeNascimento);
		
		tfRGConjuge = new JTextField();
		tfRGConjuge.setBounds(139, 80, 135, 20);
		panel_3.add(tfRGConjuge);
		tfRGConjuge.setColumns(10);
		
		tfCPFConjuge = new JFormattedTextField();
		tfCPFConjuge.setColumns(10);
		tfCPFConjuge.setBounds(139, 105, 135, 20);
		panel_3.add(tfCPFConjuge);
		
		tfDataNascimentoConjuge = new JFormattedTextField();
		tfDataNascimentoConjuge.setColumns(10);
		tfDataNascimentoConjuge.setBounds(139, 130, 135, 20);
		panel_3.add(tfDataNascimentoConjuge);
		
		cbRegime = new JComboBox();
		cbRegime.setModel(new DefaultComboBoxModel(new String[] {"Comunh\u00E3o Parcial", "Comunh\u00E3o Total", "Separa\u00E7\u00E3o Total"}));
		cbRegime.setBounds(139, 55, 135, 20);
		panel_3.add(cbRegime);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Bancárias", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblBanco = new JLabel("Banco:");
		lblBanco.setBounds(10, 17, 46, 14);
		panel_2.add(lblBanco);
		
		tfBanco = new JTextField();
		tfBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!tfBanco.getText().isEmpty()) {
					tfBanco.setBackground(new Color(173, 255, 47));
					tfAgencia.setBackground(new Color(173, 255, 47));
					tfContaBancaria.setBackground(new Color(173, 255, 47));
					tfNomeCheque.setBackground(new Color(173, 255, 47));
					tfChequeCPF.setBackground(new Color(173, 255, 47));
					tfChequeCPF.setEnabled(true);
					if (tfChequeCPF.getText().equals("")) {
						tfChequeCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
					}
					
					cbTipoConta.setEnabled(true);
					cbTipoConta.setSelectedIndex(0);
				}
				else {
					tfAgencia.setText("");
					tfContaBancaria.setText("");
					tfNomeCheque.setText("");
					tfChequeCPF.setText("");
					tfBanco.setBackground(new Color(255, 255, 255));
					tfAgencia.setBackground(new Color(255, 255, 255));
					tfContaBancaria.setBackground(new Color(255, 255, 255));
					tfNomeCheque.setBackground(new Color(255, 255, 255));
					tfChequeCPF.setBackground(new Color(255, 255, 255));
					tfChequeCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (!tfBanco.getText().isEmpty()) {
					tfBanco.setBackground(new Color(173, 255, 47));
					tfAgencia.setBackground(new Color(173, 255, 47));
					tfContaBancaria.setBackground(new Color(173, 255, 47));
					tfNomeCheque.setBackground(new Color(173, 255, 47));
					tfChequeCPF.setBackground(new Color(173, 255, 47));
					tfChequeCPF.setEnabled(true);
				}
			}
		});
		tfBanco.setBounds(123, 11, 160, 20);
		panel_2.add(tfBanco);
		tfBanco.setColumns(10);
		
		JLabel lblAgncia = new JLabel("Ag\u00EAncia:");
		lblAgncia.setBounds(10, 42, 69, 14);
		panel_2.add(lblAgncia);
		
		tfAgencia = new JTextField();
		tfAgencia.setBounds(123, 36, 160, 20);
		panel_2.add(tfAgencia);
		tfAgencia.setColumns(10);
		
		JLabel lblContaBancria = new JLabel("Conta Banc\u00E1ria:");
		lblContaBancria.setBounds(10, 70, 92, 14);
		panel_2.add(lblContaBancria);
		
		tfContaBancaria = new JTextField();
		tfContaBancaria.setBounds(123, 61, 160, 20);
		panel_2.add(tfContaBancaria);
		tfContaBancaria.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tipo de Conta:");
		lblNewLabel.setBounds(10, 95, 92, 14);
		panel_2.add(lblNewLabel);
		
		cbTipoConta = new JComboBox();
		cbTipoConta.setEnabled(false);
		cbTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Corrente", "Poupan\u00E7a"}));
		cbTipoConta.setBounds(123, 86, 160, 20);
		panel_2.add(cbTipoConta);
		
		JLabel lblChequeParaFavorecido = new JLabel("Nome do Favorecido Cheque:");
		lblChequeParaFavorecido.setBounds(294, 17, 192, 14);
		panel_2.add(lblChequeParaFavorecido);
		
		tfNomeCheque = new JTextField();
		tfNomeCheque.setBounds(461, 11, 231, 20);
		panel_2.add(tfNomeCheque);
		tfNomeCheque.setColumns(10);
		
		JLabel lblCpfDoFavorecido = new JLabel("CPF do Favorecido Cheque:");
		lblCpfDoFavorecido.setBounds(294, 42, 160, 14);
		panel_2.add(lblCpfDoFavorecido);
		
		tfChequeCPF = new JFormattedTextField();
		tfChequeCPF.setEnabled(false);
		tfChequeCPF.setBounds(461, 36, 128, 20);
		panel_2.add(tfChequeCPF);
		tfChequeCPF.setColumns(10);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str, str2, str3 = null;
				DateFormat formatDate;
				str = tfDataNascimento.getText();
				str2 = tfDataExpedicao.getText();
				str3 = tfDataNascimentoConjuge.getText();
				formatDate = new SimpleDateFormat("dd/MM/yyyy");
				if (!tfDataNascimento.getText().isEmpty()) {
				try {
					data = formatDate.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dataNasc = null;
					JOptionPane.showMessageDialog(null, "Data Inválida");
					tfDataNascimento.requestFocus();
					return;
				}
				}
				if (dataNasc != null) {
					new SimpleDateFormat("yyyy-MM-dd").format(data);
				}
				if (!tfDataExpedicao.getText().isEmpty()) {
					try {
						data2 = formatDate.parse(str2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dataExp = null;
						JOptionPane.showMessageDialog(null, "Data Inválida");
						tfDataExpedicao.requestFocus();
						return;
					}
					}
				if (dataExp != null) {
					new SimpleDateFormat("yyyy-MM-dd").format(data2);
				}
				if (!tfDataNascimentoConjuge.getText().isEmpty()) {
					try {
						data3 = formatDate.parse(str3);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dataNascConj = null;
						JOptionPane.showMessageDialog(null, "Data Inválida");
						tabbedPane.setSelectedIndex(2);
						tfDataNascimentoConjuge.requestFocus();
						return;
					}
					}
				if (dataNascConj != null) {
					new SimpleDateFormat("yyyy-MM-dd").format(data3);
				}

//				ValidarCPF();
//				ValidarCPFConjuge();
//				ValidarChequeCPF();
//				ValidarCNPJ();

				try {
				final Integer numeroC;
				if (ver = VerificarCampos(true)) {
					if (ver == ValidarCPF(true)) {
						if (ver == ValidarCPFConjuge(true)) { 
							if (ver == ValidarChequeCPF(true)) {
								if (ver == ValidarCNPJ(true)) {
					if (tfId.getText().isEmpty()) {
					if (tfNumeroComercial.getText().isEmpty()){
						if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								numeroC = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								numeroC,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), data3,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						ProprietarioDAO.Inserir(proprietario);
						LimparDados();
							} else {
								numeroC = null;
								dataNula = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(),
										numeroC,
										tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
										((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
										tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
								ProprietarioDAO.Inserir(proprietario);
								LimparDados();
							}
						} else {
							numeroC = null;
							dataNula = null;
							proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									numeroC,
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
									((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
									tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
							ProprietarioDAO.Inserir(proprietario);
							LimparDados();
						}
					}
					
					else if (!tfNumeroComercial.getText().isEmpty()) {
							if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
							proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
							.getText(), Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(), tfBairro.getText(),
							tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
							tfEmail.getText(), tfProfissao.getText(),
							tfEnderecoComercial.getText(),
							Integer.parseInt(tfNumeroComercial.getText()),
							tfComplementoComercial.getText(),
							tfBairroComercial.getText(), tfEmpresa.getText(),
							tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
									.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
							((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
							tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
									.getText(), data3,
							tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
					ProprietarioDAO.Inserir(proprietario);
					LimparDados();
					} else {
						dataNula = null;
						proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								Integer.parseInt(tfNumeroComercial.getText()),
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						ProprietarioDAO.Inserir(proprietario);
						LimparDados();
					}
					} else {
						numeroC = null;
						dataNula = null;
						proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								Integer.parseInt(tfNumeroComercial.getText()),
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						ProprietarioDAO.Inserir(proprietario);
						LimparDados();
					}
					}
					}
				else {
						if (!tfId.getText().isEmpty()) {
						if (tfNumeroComercial.getText().isEmpty()){
							if (cbTipo.getSelectedItem().equals("Física")) {
								if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								numeroC = null;
									proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									numeroC,
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
									((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
									tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), data3,
									tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
							ProprietarioDAO.Atualizar(proprietario, aux);
							LimparDados();
							} else {
								numeroC = null;
								dataNula = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								numeroC,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
								int aux = Integer.parseInt(tfId.getText());
						ProprietarioDAO.Atualizar(proprietario, aux);
						LimparDados();
							}
							} else {
								numeroC = null;
								dataNula = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								numeroC,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
								int aux = Integer.parseInt(tfId.getText());
						ProprietarioDAO.Atualizar(proprietario, aux);
						LimparDados();	
							}
						}
						
							if (!tfNumeroComercial.getText().isEmpty()){
							if (!tfId.getText().isEmpty()) {
								if (cbTipo.getSelectedItem().equals("Física")) {
									if (cbEstado.getSelectedItem().equals("Casado(a)")) {
									proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									Integer.parseInt(tfNumeroComercial.getText()),
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
									((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
									tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), data3,
									tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
							ProprietarioDAO.Atualizar(proprietario, aux);
							LimparDados();
							} else {
								dataNula = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(),
										Integer.parseInt(tfNumeroComercial.getText()),
										tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
										((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
										tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
										int aux = Integer.parseInt(tfId.getText());
								ProprietarioDAO.Atualizar(proprietario, aux);
								LimparDados();
							}
							} else {
								dataNula = null;
								proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(),
										Integer.parseInt(tfNumeroComercial.getText()),
										tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
										((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
										tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
										int aux = Integer.parseInt(tfId.getText());
								ProprietarioDAO.Atualizar(proprietario, aux);
								LimparDados();
							}
							}
							}
						}
						}
					}
							}
				}
				}
				}
				}
			catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Button-Add-icon.png")));
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDados();
			}
		});
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Button-Close-icon.png")));
		panel.add(btnCancelar);
		
		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (tfNumeroComercial.getText().equals("") || (tfNumeroComercial.getText().equals(null))) {
						final Integer aux1 = null;
						if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
						proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								aux1,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), data3,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						ProprietarioDAO.Remover(proprietario, aux);
						LimparDados();
					} else {
						dataNula = null;
						proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								aux1,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						ProprietarioDAO.Remover(proprietario, aux);
						LimparDados();
					}
						} else {
							dataNula = null;
							proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									aux1,
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
									((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
									tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
							int aux = Integer.parseInt(tfId.getText());
							ProprietarioDAO.Remover(proprietario, aux);
							LimparDados();
						}
					}
					else {
							if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
					proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
							.getText(), Integer.parseInt(tfNumero.getText()),
							tfComplemento.getText(), tfBairro.getText(),
							tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
							tfEmail.getText(), tfProfissao.getText(),
							tfEnderecoComercial.getText(),
							Integer.parseInt(tfNumeroComercial.getText()),
							tfComplementoComercial.getText(),
							tfBairroComercial.getText(), tfEmpresa.getText(),
							tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
									.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
							((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
							tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
									.getText(), data3,
							tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
					int aux = Integer.parseInt(tfId.getText());
					ProprietarioDAO.Remover(proprietario, aux);
					LimparDados();
					} else {
						dataNula = null;
						proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								Integer.parseInt(tfNumeroComercial.getText()),
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), data,
								((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
								tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						ProprietarioDAO.Remover(proprietario, aux);
						LimparDados();
					}
						} else {
							dataNula = null;
							proprietario = new Proprietario(0, Integer.parseInt(tfIdCidade.getText()), tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									Integer.parseInt(tfNumeroComercial.getText()),
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(), tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, tfBanco.getText(), tfContaBancaria.getText(), tfAgencia.getText(), dataNula,
									((String) cbEstado.getSelectedItem()), tfNomeCheque.getText(), tfChequeCPF.getText(), ((String) cbTipo.getSelectedItem()), ((String) cbTipoConta.getSelectedItem()),
									tfNomeConjuge.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegime.getSelectedItem());
							int aux = Integer.parseInt(tfId.getText());
							ProprietarioDAO.Remover(proprietario, aux);
							LimparDados();
						}
					}
				}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}		
		});
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/Button-Delete-icon.png")));
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparDados();
				new MenuPrincipal().setVisible(true);
				CadProprietario.this.dispose();;
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(CadProprietario.class.getResource("/Imagens/logout-icon.png")));
		panel.add(btnSair);
		
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
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		cbTipoConta.setSelectedItem(null);
		
		HabilitarCamposTipoPessoa();
		HabilitarConjuge();
		
		//DEIXAR POR ULTIMO NO CÓDIGO
		addWindowListener(new WindowAdapter()  
	    {  
	      public void windowOpened(WindowEvent e)  
	      {
	      tfNome.requestFocus();
	      if (tfCPF.getText().equals("")) {
	    	  tfCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));}
	      if (tfDataNascimento.getText().equals("")) {
	    	  tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));}
	      if (tfDataExpedicao.getText().equals("")) {
	    	  tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));}
	      if (tfTelefoneCelular.getText().equals("")) {
	    	  tfTelefoneCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));}
	      }  
	    });
		
	}
	

	

	
	boolean VerificarCampos(boolean b) {
		
		Date dataAtualSistema = new Date(System.currentTimeMillis());
		DateFormat formatDate;
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (!tfDataExpedicao.getText().isEmpty()) {
			dataAtual2 = formatDate.parse(tfDataExpedicao.getText());
			} else {
				dataAtual2 = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (!tfDataNascimento.getText().isEmpty()) {
			dataAtual = formatDate.parse(tfDataNascimento.getText());
			} else {
				dataAtual = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (!tfDataNascimentoConjuge.getText().isEmpty()) {
			dataAtual3 = formatDate.parse(tfDataNascimentoConjuge.getText());
			} else {
				dataAtual3 = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 if (tfIdCidade.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Cidade deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				return false;
			 }
		 else if (tfNome.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Nome deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfNome.requestFocus();
				return false;
			 }
				else if (tfEndereco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Endereço deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfEndereco.requestFocus();
					return false;
				}
				else if (tfNumero.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Número do Endereço deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfNumero.requestFocus();
					return false;
				}
				else if (tfBairro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "O Campo Bairro deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfBairro.requestFocus();
					return false;
				}
				else if (tfTelefoneCelular.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Celular deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfTelefoneCelular.requestFocus();
					return false;
				}
				else if (tfProfissao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Profissão deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfProfissao.requestFocus();
					return false;
				}
				else if (tfRG.getText().isEmpty() && (cbTipo.getSelectedItem().equals("Física"))) {
					JOptionPane.showMessageDialog(null, "O Campo RG deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfRG.requestFocus();
					return false;
				}
			 
				else if (tfCPF.getText().isEmpty() && (cbTipo.getSelectedItem().equals("Física"))) {
					JOptionPane.showMessageDialog(null, "O Campo CPF deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfCPF.requestFocus();
					return false;
				}
			 
				else if (tfDataExpedicao.getText().isEmpty() && (cbTipo.getSelectedItem().equals("Física"))) {
					JOptionPane.showMessageDialog(null, "O Campo Data de Expedição deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfDataExpedicao.requestFocus();
					return false;
				}
			 
				else if (tfDataNascimento.getText().isEmpty() && (cbTipo.getSelectedItem().equals("Física"))) {
					JOptionPane.showMessageDialog(null, "O Campo Data Nascimento deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfDataNascimento.requestFocus();
					return false;
				}
				else if ((cbEstado.isEnabled()) && cbEstado.getSelectedItem().equals("Casado(a)") && (tfNomeConjuge.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Nome do Cônjuge deve ser preenchido!");
					tabbedPane.setSelectedIndex(2);
					tfNomeConjuge.requestFocus();
					return false;
				} 
				else if ((cbEstado.isEnabled()) && cbEstado.getSelectedItem().equals("Casado(a)") && (tfProfissaoConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo Profissão do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfProfissao.requestFocus();
				return false;
			} 
				else if ((cbEstado.isEnabled()) && cbEstado.getSelectedItem().equals("Casado(a)") && (tfRGConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo RG do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfRGConjuge.requestFocus();
				return false;
			} 
				else if ((cbEstado.isEnabled()) && cbEstado.getSelectedItem().equals("Casado(a)") && (tfCPFConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo CPF do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfCPFConjuge.requestFocus();
				return false;
			} 
				else if ((cbEstado.isEnabled()) && cbEstado.getSelectedItem().equals("Casado(a)") && (tfDataNascimentoConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo Data de Nascimento do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfDataNascimentoConjuge.requestFocus();
				return false;
			} 
				else if ((!tfBanco.getText().isEmpty()) && (tfAgencia.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Agência Bancária deve ser preenchido!");
					tabbedPane.setSelectedIndex(3);
					tfAgencia.requestFocus();
					return false;
			}
				else if ((!tfBanco.getText().isEmpty()) && (tfContaBancaria.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Conta Bancária deve ser preenchido!");
					tabbedPane.setSelectedIndex(3);
					tfContaBancaria.requestFocus();
					return false;
			}
				else if ((!tfBanco.getText().isEmpty()) && (tfNomeCheque.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Nome do Favorecido do Cheque deve ser preenchido!");
					tabbedPane.setSelectedIndex(3);
					tfNomeCheque.requestFocus();
					return false;
			}
				else if ((!tfBanco.getText().isEmpty()) && (tfChequeCPF.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo CPF do Favorecido do Cheque deve ser preenchido!");
					tabbedPane.setSelectedIndex(3);
					tfChequeCPF.requestFocus();
					return false;
			} 	
				else if ((dataAtual != null) && (dataAtual.after(dataAtualSistema)) && (!tfDataNascimento.getText().isEmpty())){
				 JOptionPane.showMessageDialog(null, "A Data de Nascimento não pode ser maior que a data atual!");
				 tabbedPane.setSelectedIndex(0);
				 tfDataNascimento.requestFocus();
				 	return false;
			 } 
				else if ((dataAtual2 != null) && (dataAtual2.after(dataAtualSistema)) && (!tfDataExpedicao.getText().isEmpty())){
				 JOptionPane.showMessageDialog(null, "A Data de Expedição não pode ser maior que a data atual!");
				 tabbedPane.setSelectedIndex(0);
				 tfDataExpedicao.requestFocus();
				 	return false;
			 } 
				else if ((dataAtual3 != null) && (dataAtual3.after(dataAtualSistema)) && (!tfDataNascimentoConjuge.getText().isEmpty())){
				 JOptionPane.showMessageDialog(null, "A Data de Nascimento do Cônjuge não pode ser maior que a data atual!");
				 tabbedPane.setSelectedIndex(2);
				 tfDataNascimentoConjuge.requestFocus();
				 	return false;
			 }  

				
				else {	
					return true;
						}
	}
	
	public boolean ValidarCPF(boolean vcpf) {
			if (!tfCPF.getText().isEmpty()) {
			 String cpf = tfCPF.getText();
			 CPFValidator validator = new CPFValidator();
			 	try {
			 		validator.assertValid(cpf);
			 		return true;
			 	} catch (InvalidStateException e) {
			 		e.printStackTrace();
			 		JOptionPane.showMessageDialog(null, "O CPF digitado não é válido, por favor digite novamente!");
			 		tabbedPane.setSelectedIndex(0);
					tfCPF.requestFocus();
					return false;
		 } 
	}
			return vcpf;
	}
	
	public boolean ValidarCPFConjuge(boolean vcpfCon) {
		if (!tfCPFConjuge.getText().isEmpty()) {
			String cpfConjuge = tfCPFConjuge.getText();
			 CPFValidator validator = new CPFValidator();
			 	try {
			 		validator.assertValid(cpfConjuge);
			 		return true;
			 	} catch (InvalidStateException e) {
			 		e.printStackTrace();
			 		JOptionPane.showMessageDialog(null, "O CPF digitado não é válido, por favor digite novamente!");
			 		tabbedPane.setSelectedIndex(2);
					tfCPFConjuge.requestFocus();
					return false;
			 	}
		}
		return vcpfCon;
	}
	
	public boolean ValidarChequeCPF(boolean vcpfCheque) {
		if (!tfChequeCPF.getText().isEmpty()) {
			 String cpfCheque = tfChequeCPF.getText();
			 CPFValidator validator = new CPFValidator();
			 	try {
			 		validator.assertValid(cpfCheque);
			 		return true;
			 	} catch (InvalidStateException e) {
			 		e.printStackTrace();
			 		JOptionPane.showMessageDialog(null, "O CPF digitado não é válido, por favor digite novamente!");
			 		tabbedPane.setSelectedIndex(3);
					tfChequeCPF.requestFocus();
					return false;
			 	}
}
		return vcpfCheque;
}
	public boolean ValidarCNPJ(boolean vcnpj) {
		if (cbTipo.getSelectedItem().equals("Jurídica")){
			if (!tfCNPJ.getText().isEmpty()) {
		 String cnpj = tfCNPJ.getText();
		 CNPJValidator validator = new CNPJValidator();
		 try {
			 validator.assertValid(cnpj);
			 return true;
		 } catch (InvalidStateException e) {
			 e.printStackTrace();
		 		JOptionPane.showMessageDialog(null, "O CNPJ digitado não é válido, por favor digite novamente!");
		 		tabbedPane.setSelectedIndex(0);
				tfCNPJ.requestFocus();
				return false;
		 }
			}
		}
		return vcnpj;
	}
	
	public void HabilitarCamposTipoPessoa(){
		fis = cbTipo.getSelectedItem().toString();
		casado = cbEstado.getSelectedItem().toString();
		
		if (fis.equals("Física") && casado.equals("Solteiro(a)")) {
			tfCNPJ.setEditable(false);
			tfRazaoSocial.setEditable(false);
			
			tfRG.setEditable(true);
			tfCPF.setEditable(true);
			tfDataExpedicao.setEditable(true);
			tfDataNascimento.setEditable(true);

			tfNomeConjuge.setEditable(false);
			tfProfissaoConjuge.setEditable(false);
			tfRGConjuge.setEditable(false);
			tfCPFConjuge.setEditable(false);
			tfDataNascimentoConjuge.setEditable(false);
			cbRegime.setEnabled(false);
			cbRegime.setSelectedItem(null);
			
			tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
			tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));


		}
		else {
			
			tfRG.setEditable(false);
			tfCPF.setEditable(false);
			tfDataExpedicao.setEditable(false);
			tfDataNascimento.setEditable(false);
			cbEstado.setEnabled(false);
			cbEstado.setSelectedItem(null);
			tfNomeConjuge.setEditable(false);
			tfProfissaoConjuge.setEditable(false);
			tfRGConjuge.setEditable(false);
			tfCPFConjuge.setEditable(false);
			tfDataNascimentoConjuge.setEditable(false);
			cbRegime.setEnabled(false);
			cbRegime.setSelectedItem(null);
			
			tfCNPJ.setEditable(true);
			tfRazaoSocial.setEditable(true);
			
			tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
			tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
		}
	}
	
	public void HabilitarConjuge() {
		if (fis.equals("Física")) {
			fis = cbTipo.getSelectedItem().toString();
			casado = cbEstado.getSelectedItem().toString();
			if (casado.equals("Casado(a)")) {
			tfNomeConjuge.setEditable(true);
			tfProfissaoConjuge.setEditable(true);
			cbRegime.setEnabled(true);
			cbRegime.setSelectedIndex(0);
			tfRGConjuge.setEditable(true);
			tfCPFConjuge.setEditable(true);
			tfAgencia.setEditable(true);
			tfDataNascimentoConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
			tfCPFConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
			tfDataNascimentoConjuge.setEnabled(true);
			tfDataNascimentoConjuge.setEditable(true);
			

		}
		else {
			tfNomeConjuge.setEditable(false);
			tfProfissaoConjuge.setEditable(false);
			cbRegime.setEnabled(false);
			cbRegime.setSelectedItem(null);
			tfRGConjuge.setEditable(false);
			tfCPFConjuge.setEditable(false);
			tfDataNascimentoConjuge.setEditable(false);
			tfNomeConjuge.setText("");
			tfProfissaoConjuge.setText("");
			tfRGConjuge.setText("");
			tfCPFConjuge.setText("");
			tfDataNascimentoConjuge.setText("");
			tfDataNascimentoConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
			tfCPFConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
		}
	
		}
	}
	
	public void MudarMascara() {
		
		tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
		tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfTelefoneCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
		
	}
	
	public void LimparDados() {
		tfId.setText("");
		tfIdCidade.setText("");
		tfNome.setText("");
		tfEndereco.setText("");
		tfNumero.setText("");
		tfBairro.setText("");
		tfComplemento.setText("");
		tfEmail.setText("");
		tfTelefoneFixo.setText("");
		tfTelefoneCelular.setText("");
		tfProfissao.setText("");
		tfCNPJ.setText("");
		tfCNPJ.setEnabled(false);
		tfRazaoSocial.setText("");
		tfIdCidade.setText("");
		tfCPF.setText("");
		tfRG.setText("");
		tfDataExpedicao.setText("");
		tfNomeCheque.setText("");
		tfChequeCPF.setText("");
		cbTipo.setSelectedIndex(0);
		cbTipoConta.setSelectedIndex(0);
		tfDataNascimento.setText("");
		tfEnderecoComercial.setText("");
		tfNumeroComercial.setText("");
		tfComplementoComercial.setText("");
		tfBairroComercial.setText("");
		tfEmpresa.setText("");
		tfTelefoneComercial.setText("");
		tfBanco.setText("");
		tfContaBancaria.setText("");
		tfAgencia.setText("");
		tfNomeConjuge.setText("");
		tfProfissaoConjuge.setText("");
		tfRGConjuge.setText("");
		tfCPFConjuge.setText("");
		tfDataNascimentoConjuge.setText("");
		cbEstado.setSelectedIndex(0);
		cbRegime.setSelectedIndex(0);
		tabbedPane.setSelectedIndex(0);
		tfNome.requestFocus();
		btnExcluir.setEnabled(false);
		HabilitarConjuge();
		cbTipoConta.setEnabled(false);
		cbTipoConta.setSelectedItem(null);
		tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfChequeCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
		
		tfChequeCPF.setEnabled(false);
		
		tfBanco.setBackground(new Color(255, 255, 255));
		tfAgencia.setBackground(new Color(255, 255, 255));
		tfContaBancaria.setBackground(new Color(255, 255, 255));
		tfNomeCheque.setBackground(new Color(255, 255, 255));
		tfChequeCPF.setBackground(new Color(255, 255, 255));
	}
	
	public static void SetarCidade(Cidade cidade){
		String aux = Integer.toString(cidade.getId());
		tfIdCidade.setText(aux);
	}
	
		public static void SetarDados(ProprietarioCidade proprietario){
			
			String aux4;
			String aux = Integer.toString(proprietario.getId());
			String aux2 = Integer.toString(proprietario.getIdCidade());
			String aux3 = Integer.toString(proprietario.getNumero());
			if (proprietario.getNumeroComercial().equals(0)) {
				aux4 = null;
			}
			else {
			aux4 = Integer.toString(proprietario.getNumeroComercial());
			}
			
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				if ((proprietario.getDataExpedicao() != null)) {
					result2 = out.format(in.parse(proprietario.getDataExpedicao().toString()));
				} else {
					result2 = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				if ((proprietario.getDataNascimento() != null)) {
					result = out.format(in.parse(proprietario.getDataNascimento().toString()));
				} else {
					result = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				if ((proprietario.getDataNascimentoConjuge() != null)) {
					result3 = out.format(in.parse(proprietario.getDataNascimentoConjuge().toString()));
				} else {
					result3 = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			tfId.setText(aux);
			tfIdCidade.setText(aux2);
			tfNome.setText(proprietario.getNome());
			tfEndereco.setText(proprietario.getEndereco());
			tfNumero.setText(aux3);
			tfComplemento.setText(proprietario.getComplemento());
			tfBairro.setText(proprietario.getBairro());
			tfEmail.setText(proprietario.getEmail());
			tfTelefoneFixo.setText(proprietario.getTelefoneFixo());
			tfTelefoneCelular.setText(proprietario.getTelefoneCelular());
			tfProfissao.setText(proprietario.getProfissao());
			cbTipo.setSelectedItem(proprietario.getTipoPessoa());
			tfCNPJ.setText(proprietario.getCNPJ());
			tfRazaoSocial.setText(proprietario.getRazaoSocial());
			tfCPF.setText(proprietario.getCPF());
			tfRG.setText(proprietario.getRG());
			tfDataExpedicao.setText(result2);
			tfDataNascimento.setText(result);
			cbEstado.setSelectedItem(proprietario.getEstadoCivil());
			tfEnderecoComercial.setText(proprietario.getEnderecoComercial());
			tfNumeroComercial.setText(aux4);
			tfComplementoComercial.setText(proprietario.getComplementoComercial());
			tfBairroComercial.setText(proprietario.getBairroComercial());
			tfEmpresa.setText(proprietario.getEmpresa());
			tfTelefoneComercial.setText(proprietario.getTelefoneComercial());
			tfNomeConjuge.setText(proprietario.getNomeConjuge());
			tfProfissaoConjuge.setText(proprietario.getProfissaoConjuge());
			cbRegime.setSelectedItem(proprietario.getRegimeDeBens());
			tfRGConjuge.setText(proprietario.getRGConjuge());
			tfCPFConjuge.setText(proprietario.getCPFConjuge());
			tfDataNascimentoConjuge.setText(result3);
			btnExcluir.setEnabled(true);
			tfCNPJ.setText(proprietario.getCNPJ());
			tfRazaoSocial.setText(proprietario.getRazaoSocial());
			tfNomeCheque.setText(proprietario.getChequeFavorecido());
			tfChequeCPF.setText(proprietario.getChequeCPF());
			tfBanco.setText(proprietario.getBanco());
			tfContaBancaria.setText(proprietario.getContaBancaria());
			tfAgencia.setText(proprietario.getAgenciaBancaria());
			if (!proprietario.getBanco().equals(null)) {
			if (!proprietario.getBanco().isEmpty()) {
				cbTipoConta.setEnabled(true);
				cbTipoConta.setEditable(true);
				cbTipoConta.setSelectedItem(proprietario.getTipoConta());
			}
			}
	}
		
}


	
