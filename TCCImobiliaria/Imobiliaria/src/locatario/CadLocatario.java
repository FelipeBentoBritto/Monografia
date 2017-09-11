package locatario;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import menu.MenuPrincipal;

import com.mysql.jdbc.Connection;

import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadLocatario extends JFrame {

	private JPanel contentPane;
	private static JTextField tfId;
	private static JTextField tfProfissao;
	private static JTextField tfNome;
	private static JTextField tfEndereco;
	private static JTextField tfNumero;
	private static JTextField tfComplemento;
	private static JTextField tfBairro;
	private static JTextField tfEmail;
	private static JTextField tfRazaoSocial;
	private static JFormattedTextField tfDataNascimento;
	private static JTextField tfRG;
	private static JTextField tfRenda;
	private static JTextField tfEnderecoComercial;
	private static JTextField tfNumeroComercial;
	private static JTextField tfComplementoComercial;
	private static JTextField tfBairroComercial;
	private static JTextField tfEmpresa;
	private static JTextField tfTelefoneComercial;
	private static JTextField tfNomeConjuge;
	private static JTextField tfProfissaoConjuge;
	private static JTextField tfRGConjuge;
	private static JFormattedTextField tfDataExpedicao;
	private static JFormattedTextField tfTelefoneFixo;
	private static JFormattedTextField tfTelefoneCelular;
	private static JComboBox cbTipo;
	private static JComboBox cbEstado;
	private static JComboBox cbRegimeDeBens;
	private JButton btnSalvar;
	private JButton btnCancelar;
	static JButton btnExcluir;
	private JButton btnSair;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	JTabbedPane tabbedPane;
	
	private static Date dataNasc, dataExp, dataNascConj;
	private static Date dataNula;
	private Date data = null, data2 = null, data3 = null;
	private Date dataAtual, dataAtual2, dataAtual3;
	private static String result, result2, result3;
	
	private Connection conn;
	private Locatario locatario;
	private boolean ver;
	private String fis;
	private String casado;
	
	private MaskFormatter mascaraData;
	private static MaskFormatter mascaraVazia;
	
	private MaskFormatter mascaraCPF, mascaraCNPJ;
	private MaskFormatter mascaraTelefone;
	private static JFormattedTextField tfCPF;
	private static JFormattedTextField tfCNPJ;
	private static JFormattedTextField tfDataNascimentoConjuge;
	private static JFormattedTextField tfCPFConjuge;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadLocatario frame = new CadLocatario();
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
	public CadLocatario() {
		
		
		
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
		
		setTitle("Cadastro de Locat\u00E1rio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 699, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 345, 694, 52);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 347);
		contentPane.add(tabbedPane);

		panel_1 = new JPanel();
		tabbedPane.addTab("Informações Pessoais", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 13, 46, 14);
		panel_1.add(label);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(104, 8, 86, 20);
		panel_1.add(tfId);

		JLabel lblTipoPessoa = new JLabel("Tipo Pessoa:");
		lblTipoPessoa.setBounds(10, 40, 86, 12);
		panel_1.add(lblTipoPessoa);

		tfProfissao = new JTextField();
		tfProfissao.setBackground(new Color(173, 255, 47));
		tfProfissao.setColumns(10);
		tfProfissao.setBounds(104, 288, 226, 20);
		panel_1.add(tfProfissao);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 67, 62, 14);
		panel_1.add(lblNome);

		tfNome = new JTextField();
		tfNome.setBackground(new Color(173, 255, 47));
		tfNome.setColumns(10);
		tfNome.setBounds(104, 64, 226, 20);
		panel_1.add(tfNome);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 95, 86, 14);
		panel_1.add(lblEndereo);

		tfEndereco = new JTextField();
		tfEndereco.setBackground(new Color(173, 255, 47));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(104, 92, 226, 20);
		panel_1.add(tfEndereco);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 123, 86, 14);
		panel_1.add(lblNmero);

		tfNumero = new JTextField();
		tfNumero.setBackground(new Color(173, 255, 47));
		tfNumero.setColumns(10);
		tfNumero.setBounds(104, 120, 46, 20);
		panel_1.add(tfNumero);

		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(104, 148, 226, 20);
		panel_1.add(tfComplemento);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 151, 99, 14);
		panel_1.add(lblComplemento);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 179, 46, 14);
		panel_1.add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setBackground(new Color(173, 255, 47));
		tfBairro.setColumns(10);
		tfBairro.setBounds(104, 176, 165, 20);
		panel_1.add(tfBairro);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 207, 86, 14);
		panel_1.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(104, 204, 165, 20);
		panel_1.add(tfEmail);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setBounds(10, 235, 86, 14);
		panel_1.add(lblTelefoneFixo);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 263, 62, 14);
		panel_1.add(lblCelular);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(10, 291, 99, 14);
		panel_1.add(lblProfisso);

		
		
		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Juridica"}));
		cbTipo.setBounds(103, 36, 87, 20);
		panel_1.add(cbTipo);

		JLabel label_11 = new JLabel("CPF:");
		label_11.setBounds(350, 13, 46, 14);
		panel_1.add(label_11);

		JLabel label_12 = new JLabel("RG:");
		label_12.setBounds(350, 39, 46, 14);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel("Data Nascimento:");
		label_13.setBounds(350, 67, 106, 14);
		panel_1.add(label_13);

		JLabel label_14 = new JLabel("Data Expedi\u00E7\u00E3o:");
		label_14.setBounds(350, 95, 97, 14);
		panel_1.add(label_14);

		JLabel label_15 = new JLabel("Estado C\u00EDvil:");
		label_15.setBounds(350, 123, 86, 14);
		panel_1.add(label_15);

		JLabel label_16 = new JLabel("CNPJ:");
		label_16.setBounds(350, 179, 46, 14);
		panel_1.add(label_16);

		JLabel label_17 = new JLabel("Raz\u00E3o Social:");
		label_17.setBounds(350, 207, 97, 14);
		panel_1.add(label_17);

		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(457, 204, 206, 20);
		panel_1.add(tfRazaoSocial);

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
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {
						"Solteiro(a)", "Casado(a)", "Divorciado(a)",
						"V\u00EDuvo(a)" }));
		cbEstado.setBounds(456, 120, 133, 20);
		panel_1.add(cbEstado);

		tfRG = new JTextField();
		tfRG.setBackground(new Color(173, 255, 47));
		tfRG.setColumns(10);
		tfRG.setBounds(457, 36, 132, 20);
		panel_1.add(tfRG);

		JLabel lblRenda = new JLabel("Renda Familiar:");
		lblRenda.setBounds(342, 291, 97, 14);
		panel_1.add(lblRenda);

		tfRenda = new JTextField();
		tfRenda.setBackground(new Color(173, 255, 47));
		tfRenda.setBounds(457, 288, 86, 20);
		panel_1.add(tfRenda);
		tfRenda.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConLocatario().setVisible(true);
				CadLocatario.this.dispose();;
			}
		});
		button.setIcon(new ImageIcon(CadLocatario.class.getResource("/Imagens/Zoom-icon.png")));
		button.setToolTipText("Pesquisar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		button.setBounds(200, 8, 29, 20);
		panel_1.add(button);
		
		tfDataNascimento = new JFormattedTextField(mascaraData);
		tfDataNascimento.setBackground(new Color(173, 255, 47));
		tfDataNascimento.setBounds(457, 64, 86, 20);
		panel_1.add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		tfDataExpedicao = new JFormattedTextField(mascaraData);
		tfDataExpedicao.setBackground(new Color(173, 255, 47));
		tfDataExpedicao.setBounds(457, 92, 86, 20);
		panel_1.add(tfDataExpedicao);
		
		tfCPF = new JFormattedTextField();
		tfCPF.setBackground(new Color(173, 255, 47));
		tfCPF.setBounds(457, 8, 132, 20);
		panel_1.add(tfCPF);
		
		tfCNPJ = new JFormattedTextField();
		tfCNPJ.setBounds(457, 176, 132, 20);
		panel_1.add(tfCNPJ);
		
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
		tfTelefoneFixo.setBounds(103, 232, 166, 20);
		panel_1.add(tfTelefoneFixo);
		
		tfTelefoneCelular = new JFormattedTextField(mascaraTelefone);
		tfTelefoneCelular.setBounds(104, 260, 165, 20);
		panel_1.add(tfTelefoneCelular);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Comerciais", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label_18 = new JLabel("Endere\u00E7o Comercial:");
		label_18.setBounds(10, 17, 128, 14);
		panel_2.add(label_18);

		tfEnderecoComercial = new JTextField();
		tfEnderecoComercial.setColumns(10);
		tfEnderecoComercial.setBounds(156, 11, 257, 20);
		panel_2.add(tfEnderecoComercial);

		JLabel label_19 = new JLabel("N\u00FAmero Comercial:");
		label_19.setBounds(10, 42, 115, 14);
		panel_2.add(label_19);

		tfNumeroComercial = new JTextField();
		tfNumeroComercial.setColumns(10);
		tfNumeroComercial.setBounds(156, 36, 43, 20);
		panel_2.add(tfNumeroComercial);

		JLabel label_20 = new JLabel("Complemento Comercial:");
		label_20.setBounds(10, 67, 153, 14);
		panel_2.add(label_20);

		tfComplementoComercial = new JTextField();
		tfComplementoComercial.setColumns(10);
		tfComplementoComercial.setBounds(156, 61, 188, 20);
		panel_2.add(tfComplementoComercial);

		JLabel label_21 = new JLabel("Bairro Comercial:");
		label_21.setBounds(10, 92, 115, 14);
		panel_2.add(label_21);

		tfBairroComercial = new JTextField();
		tfBairroComercial.setColumns(10);
		tfBairroComercial.setBounds(156, 86, 188, 20);
		panel_2.add(tfBairroComercial);

		JLabel label_22 = new JLabel("Empresa:");
		label_22.setBounds(10, 117, 115, 14);
		panel_2.add(label_22);

		tfEmpresa = new JTextField();
		tfEmpresa.setColumns(10);
		tfEmpresa.setBounds(156, 111, 188, 20);
		panel_2.add(tfEmpresa);

		JLabel label_23 = new JLabel("Telefone Comercial:");
		label_23.setBounds(10, 142, 115, 14);
		panel_2.add(label_23);

		tfTelefoneComercial = new JTextField();
		tfTelefoneComercial.setColumns(10);
		tfTelefoneComercial.setBounds(156, 136, 98, 20);
		panel_2.add(tfTelefoneComercial);

		panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Cônjuge", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel label_24 = new JLabel("Nome:");
		label_24.setBounds(10, 17, 46, 14);
		panel_3.add(label_24);

		tfNomeConjuge = new JTextField();
		tfNomeConjuge.setColumns(10);
		tfNomeConjuge.setBounds(139, 11, 245, 20);
		panel_3.add(tfNomeConjuge);

		JLabel label_25 = new JLabel("Profiss\u00E3o:");
		label_25.setBounds(10, 42, 79, 14);
		panel_3.add(label_25);

		tfProfissaoConjuge = new JTextField();
		tfProfissaoConjuge.setColumns(10);
		tfProfissaoConjuge.setBounds(139, 36, 190, 20);
		panel_3.add(tfProfissaoConjuge);

		JLabel label_26 = new JLabel("Regime de Bens:");
		label_26.setBounds(10, 67, 96, 14);
		panel_3.add(label_26);

		JLabel label_27 = new JLabel("RG:");
		label_27.setBounds(10, 92, 46, 14);
		panel_3.add(label_27);

		tfRGConjuge = new JTextField();
		tfRGConjuge.setColumns(10);
		tfRGConjuge.setBounds(139, 86, 135, 20);
		panel_3.add(tfRGConjuge);

		JLabel label_28 = new JLabel("CPF:");
		label_28.setBounds(10, 117, 46, 14);
		panel_3.add(label_28);

		JLabel label_29 = new JLabel("Data de Nascimento:");
		label_29.setBounds(10, 142, 120, 14);
		panel_3.add(label_29);

		cbRegimeDeBens = new JComboBox();
		cbRegimeDeBens.setModel(new DefaultComboBoxModel(new String[] {"Comunh\u00E3o Parcial", "Comunh\u00E3o Total", "Separa\u00E7\u00E3o Total"}));
		cbRegimeDeBens.setBounds(139, 61, 135, 20);
		panel_3.add(cbRegimeDeBens);
		
		tfDataNascimentoConjuge = new JFormattedTextField();
		tfDataNascimentoConjuge.setBounds(139, 137, 69, 20);
		panel_3.add(tfDataNascimentoConjuge);
		
		tfCPFConjuge = new JFormattedTextField();
		tfCPFConjuge.setBounds(139, 111, 135, 20);
		panel_3.add(tfCPFConjuge);


		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str, str2, str3 = null;
				DateFormat formatDate;
				str = tfDataNascimento.getText();
				str2 = tfDataExpedicao.getText();
				str3 = tfDataNascimentoConjuge.getText();
				formatDate = new SimpleDateFormat("dd/MM/yyyy");
				if (!tfDataNascimento.getText().isEmpty()) {
				try {
					data = formatDate.parse(str);
				} catch (ParseException p) {
					// TODO Auto-generated catch block
					p.printStackTrace();
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
					} catch (ParseException p) {
						// TODO Auto-generated catch block
						p.printStackTrace();
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
					} catch (ParseException p) {
						// TODO Auto-generated catch block
						p.printStackTrace();
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
								if (ver == ValidarCNPJ(true)) {
					if (tfId.getText().isEmpty()) {
					if (tfNumeroComercial.getText().isEmpty()){
						if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								numeroC = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
						LocatarioDAO.Inserir(locatario);
						LimparDados();
							} else {
								numeroC = null;
								dataNula = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
								LocatarioDAO.Inserir(locatario);
								LimparDados();
							}
						} else {
							numeroC = null;
							dataNula = null;
							locatario = new Locatario(0, tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(),
									tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, Integer.parseInt(tfRenda
											.getText()), dataNula,
									((String) cbEstado.getSelectedItem()),
									(String) cbTipo.getSelectedItem(), tfNomeConjuge
											.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
											.getSelectedItem());
							LocatarioDAO.Inserir(locatario);
							LimparDados();
						}
					}
					
					else if (!tfNumeroComercial.getText().isEmpty()) {
							if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
						LocatarioDAO.Inserir(locatario);
						LimparDados();
					} else {
						dataNula = null;
						locatario = new Locatario(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(),
								tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, Integer.parseInt(tfRenda
										.getText()), data,
								((String) cbEstado.getSelectedItem()),
								(String) cbTipo.getSelectedItem(), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
						LocatarioDAO.Inserir(locatario);
						LimparDados();
					}
					} else {
						numeroC = null;
						dataNula = null;
						locatario = new Locatario(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(),
								tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), dataNula, Integer.parseInt(tfRenda
										.getText()), dataNula,
								((String) cbEstado.getSelectedItem()),
								(String) cbTipo.getSelectedItem(), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
						LocatarioDAO.Inserir(locatario);
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
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());	
							int aux = Integer.parseInt(tfId.getText());
							LocatarioDAO.Atualizar(locatario, aux);
							LimparDados();
							} else {
								numeroC = null;
								dataNula = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
								int aux = Integer.parseInt(tfId.getText());
						LocatarioDAO.Atualizar(locatario, aux);
						LimparDados();
							}
							} else {
								numeroC = null;
								dataNula = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), numeroC, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), dataNula, Integer.parseInt(tfRenda
												.getText()), dataNula,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
								int aux = Integer.parseInt(tfId.getText());
						LocatarioDAO.Atualizar(locatario, aux);
						LimparDados();	
							}
						}
						
							if (!tfNumeroComercial.getText().isEmpty()){
							if (!tfId.getText().isEmpty()) {
								if (cbTipo.getSelectedItem().equals("Física")) {
									if (cbEstado.getSelectedItem().equals("Casado(a)")) {
										locatario = new Locatario(0, tfNome.getText(), tfEndereco
												.getText(), Integer.parseInt(tfNumero.getText()),
												tfComplemento.getText(), tfBairro.getText(),
												tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
												tfEmail.getText(), tfProfissao.getText(),
												tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
												tfBairroComercial.getText(), tfEmpresa.getText(),
												tfTelefoneComercial.getText(), tfCNPJ.getText(),
												tfRazaoSocial.getText(), tfRG.getText(), tfCPF
														.getText(), data2, Integer.parseInt(tfRenda
														.getText()), data,
												((String) cbEstado.getSelectedItem()),
												(String) cbTipo.getSelectedItem(), tfNomeConjuge
														.getText(), tfCPFConjuge.getText(), tfRGConjuge
														.getText(), data3,
												tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
														.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
							LocatarioDAO.Atualizar(locatario, aux);
							LimparDados();
							} else {
								dataNula = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
										int aux = Integer.parseInt(tfId.getText());
								LocatarioDAO.Atualizar(locatario, aux);
								LimparDados();
							}
							} else {
								dataNula = null;
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), dataNula, Integer.parseInt(tfRenda
												.getText()), dataNula,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), dataNula,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
										int aux = Integer.parseInt(tfId.getText());
								LocatarioDAO.Atualizar(locatario, aux);
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
			catch (Exception p) {
				p.printStackTrace();
			}
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadLocatario.class
				.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		panel.add(btnSalvar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDados();
			}
		});
		btnCancelar.setIcon(new ImageIcon(CadLocatario.class
				.getResource("/Imagens/Button-Close-icon.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(240, 240, 241));
		panel.add(btnCancelar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (tfNumeroComercial.getText().equals("") || (tfNumeroComercial.getText().equals(null))) {
						final Integer aux1 = null;
						if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), aux1, tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						LocatarioDAO.Remover(locatario, aux);
						LimparDados();
					} else {
						dataNula = null;
						locatario = new Locatario(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(), aux1, tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(),
								tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, Integer.parseInt(tfRenda
										.getText()), data,
								((String) cbEstado.getSelectedItem()),
								(String) cbTipo.getSelectedItem(), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						LocatarioDAO.Remover(locatario, aux);
						LimparDados();
					}
						} else {
							dataNula = null;
							locatario = new Locatario(0, tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(), aux1, tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(),
									tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, Integer.parseInt(tfRenda
											.getText()), dataNula,
									((String) cbEstado.getSelectedItem()),
									(String) cbTipo.getSelectedItem(), tfNomeConjuge
											.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
											.getSelectedItem());
							int aux = Integer.parseInt(tfId.getText());
							LocatarioDAO.Remover(locatario, aux);
							LimparDados();
						}
					}
					else {
							if (cbTipo.getSelectedItem().equals("Física")) {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								locatario = new Locatario(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfCNPJ.getText(),
										tfRazaoSocial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, Integer.parseInt(tfRenda
												.getText()), data,
										((String) cbEstado.getSelectedItem()),
										(String) cbTipo.getSelectedItem(), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
					int aux = Integer.parseInt(tfId.getText());
					LocatarioDAO.Remover(locatario, aux);
					LimparDados();
					} else {
						dataNula = null;
						locatario = new Locatario(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfCNPJ.getText(),
								tfRazaoSocial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, Integer.parseInt(tfRenda
										.getText()), data,
								((String) cbEstado.getSelectedItem()),
								(String) cbTipo.getSelectedItem(), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						LocatarioDAO.Remover(locatario, aux);
						LimparDados();
					}
						} else {
							dataNula = null;
							locatario = new Locatario(0, tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(), Integer.parseInt(tfNumeroComercial.getText()), tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfCNPJ.getText(),
									tfRazaoSocial.getText(), tfRG.getText(), tfCPF
											.getText(), dataNula, Integer.parseInt(tfRenda
											.getText()), dataNula,
									((String) cbEstado.getSelectedItem()),
									(String) cbTipo.getSelectedItem(), tfNomeConjuge
											.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
											.getSelectedItem());
							int aux = Integer.parseInt(tfId.getText());
							LocatarioDAO.Remover(locatario, aux);
							LimparDados();
						}
					}
				}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}		
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon(CadLocatario.class
				.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel.add(btnExcluir);

		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuPrincipal().setVisible(true);;
				CadLocatario.this.dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(CadLocatario.class
				.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
		panel.add(btnSair);

		Color color = new Color(240, 240, 241);
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
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		HabilitarCamposTipoPessoa();
		HabilitarConjuge();
		
		//DEIXAR POR ULTIMO NO CÓDIGO
				addWindowListener(new WindowAdapter()  
			    {  
			      public void windowOpened(WindowEvent e)  
			      {tfNome.requestFocus();}  
			    });
			}
	
	
	boolean VerificarCampos(boolean b){
		
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
		 if (tfNome.getText().isEmpty()) {
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
			else if (tfRenda.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Renda deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfRenda.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && tfRG.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo RG deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfRG.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && tfCPF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo CPF deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfCPF.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && tfDataExpedicao.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Data de Expedição deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfDataExpedicao.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && tfDataNascimento.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Data Nascimento deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfDataNascimento.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Juridica") && tfCNPJ.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo CNPJ deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfCNPJ.requestFocus();
				return false;
			}
		 
			else if (cbTipo.getSelectedItem().toString().equals("Juridica") && tfRazaoSocial.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O Campo Razão Social deve ser preenchido!");
				tabbedPane.setSelectedIndex(0);
				tfRazaoSocial.requestFocus();
				return false;
			}
		 	
			else if (cbTipo.getSelectedItem().toString().equals("Física") && cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfNomeConjuge.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Nome do Cônjuge deve ser preenchido!");
					tabbedPane.setSelectedIndex(2);
					tfNomeConjuge.requestFocus();
					return false;
				} 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfProfissaoConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo Profissão do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfProfissao.requestFocus();
				return false;
			} 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfRGConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo RG do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfRGConjuge.requestFocus();
				return false;
			} 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfCPFConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo CPF do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfCPFConjuge.requestFocus();
				return false;
			} 
			else if (cbTipo.getSelectedItem().toString().equals("Física") && cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfDataNascimentoConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo Data de Nascimento do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfDataNascimentoConjuge.requestFocus();
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
		public static void SetarDados(Locatario locatario){
			String aux5;
			String aux = Integer.toString(locatario.getId());
			String aux2 = Integer.toString(locatario.getNumero());
			String aux4 = Integer.toString(locatario.getRenda());
			
			if (locatario.getNumeroComercial().equals(0)) {
				aux5 = null;
			}
			else {
			aux5 = Integer.toString(locatario.getNumeroComercial());
			}
			
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				if ((locatario.getDataExpedicao() != null)) {
					result2 = out.format(in.parse(locatario.getDataExpedicao().toString()));
				} else {
					result2 = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				if ((locatario.getDataNascimento() != null)) {
					result = out.format(in.parse(locatario.getDataNascimento().toString()));
				} else {
					result = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				if ((locatario.getDataNascimentoConjuge() != null)) {
					result3 = out.format(in.parse(locatario.getDataNascimentoConjuge().toString()));
				} else {
					result3 = "";
				}
					
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			tfId.setText(aux);
			tfNome.setText(locatario.getNome());
			tfEndereco.setText(locatario.getEndereco());
			tfNumero.setText(aux2);
			tfComplemento.setText(locatario.getComplemento());
			tfBairro.setText(locatario.getBairro());
			tfEmail.setText(locatario.getEmail());
			tfTelefoneFixo.setText(locatario.getTelefoneFixo());
			tfTelefoneCelular.setText(locatario.getTelefoneCelular());
			tfProfissao.setText(locatario.getProfissao());
			cbTipo.setSelectedItem(locatario.getTipoPessoa());
			tfCNPJ.setText(locatario.getCNPJ());
			tfRazaoSocial.setText(locatario.getRazaoSocial());
			tfCPF.setText(locatario.getCPF());
			tfRG.setText(locatario.getRG());
			tfDataExpedicao.setText(result2);
			tfDataNascimento.setText(result);
			cbEstado.setSelectedItem(locatario.getEstadoCivil());
			tfRenda.setText(aux4);
			tfEnderecoComercial.setText(locatario.getEnderecoComercial());
			tfNumeroComercial.setText(aux5);
			tfComplementoComercial.setText(locatario.getComplementoComercial());
			tfBairroComercial.setText(locatario.getBairroComercial());
			tfEmpresa.setText(locatario.getEmpresa());
			tfTelefoneComercial.setText(locatario.getTelefoneComercial());
			tfNomeConjuge.setText(locatario.getNomeConjuge());
			tfProfissaoConjuge.setText(locatario.getProfissaoConjuge());
			cbRegimeDeBens.setSelectedItem(locatario.getRegimeDeBens());
			tfRGConjuge.setText(locatario.getRGConjuge());
			tfCPFConjuge.setText(locatario.getCPFConjuge());
			tfDataNascimentoConjuge.setText(result3);
			btnExcluir.setEnabled(true);
		}
		
	public void HabilitarConjuge(){
		
		if (fis.equals("Física")) {
			fis = cbTipo.getSelectedItem().toString();
			casado = cbEstado.getSelectedItem().toString();
			if (casado.equals("Casado(a)")) {
			tfNomeConjuge.setEditable(true);
			tfProfissaoConjuge.setEditable(true);
			cbRegimeDeBens.setEnabled(true);
			cbRegimeDeBens.setSelectedIndex(0);
			tfRGConjuge.setEditable(true);
			tfCPFConjuge.setEditable(true);
			tfDataNascimentoConjuge.setEditable(true);
			
			tfDataNascimentoConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
			tfCPFConjuge.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
		}
		else {
			tfNomeConjuge.setEditable(false);
			tfProfissaoConjuge.setEditable(false);
			cbRegimeDeBens.setEnabled(false);
			cbRegimeDeBens.setSelectedItem(null);
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
			cbRegimeDeBens.setEnabled(false);
			cbRegimeDeBens.setSelectedItem(null);
			
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
			cbRegimeDeBens.setEnabled(false);
			cbRegimeDeBens.setSelectedItem(null);
			
			tfCNPJ.setEditable(true);
			tfRazaoSocial.setEditable(true);
			
			tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
			tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraVazia));
		}
	}
	
	public void LimparDados(){
		tfId.setText("");
		tfNome.setText("");
		tfEndereco.setText("");
		tfNumero.setText("");
		tfBairro.setText("");
		tfComplemento.setText("");
		tfEmail.setText("");
		tfTelefoneFixo.setText("");
		tfTelefoneCelular.setText("");
		tfProfissao.setText("");
		tfRenda.setText("");
		tfCPF.setText("");
		tfRG.setText("");
		tfDataExpedicao.setText("");
		tfDataNascimento.setText("");
		tfCNPJ.setText("");
		tfRazaoSocial.setText("");
		tfRenda.setText("");
		tfEnderecoComercial.setText("");
		tfNumeroComercial.setText("");
		tfComplementoComercial.setText("");
		tfBairroComercial.setText("");
		tfEmpresa.setText("");
		tfTelefoneComercial.setText("");
		tfNomeConjuge.setText("");
		tfProfissaoConjuge.setText("");
		tfRGConjuge.setText("");
		tfCPFConjuge.setText("");
		tfDataNascimentoConjuge.setText("");
		tfNome.requestFocus();
		cbTipo.setSelectedIndex(0);
		cbEstado.setSelectedIndex(0);
		cbRegimeDeBens.setSelectedIndex(0);
		tabbedPane.setSelectedIndex(0);
		btnExcluir.setEnabled(false);
		tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfTelefoneCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
		
		
	}
}

		
