package fiador;

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

import menu.MenuPrincipal;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

import com.mysql.jdbc.Connection;

import javax.swing.JFormattedTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadFiador extends JFrame {

	private JPanel contentPane;
	private static JTextField tfNome;
	private static JTextField tfEndereco;
	private static JTextField tfNumero;
	private static JTextField tfComplemento;
	private static JTextField tfBairro;
	private static JTextField tfProfissao;
	private static JTextField tfRG;
	private static JTextField tfEmail;
	private static JTextField tfId;
	private static JTextField tfEnderecoComercial;
	private static JTextField tfNumeroComercial;
	private static JTextField tfComplementoComercial;
	private static JTextField tfBairroComercial;
	private static JTextField tfEmpresa;
	private static JTextField tfTelefoneComercial;
	private static JTextField tfNomeConjuge;
	private static JTextField tfProfissaoConjuge;
	private static JFormattedTextField tfCPFConjuge;
	private static JFormattedTextField tfDataNascimentoConjuge;
	private static JFormattedTextField tfDataNascimento;
	private static JFormattedTextField tfDataExpedicao;
	private static JFormattedTextField tfCPF;
	private static JFormattedTextField tfTelefoneCelular;
	private static JFormattedTextField tfTelefoneFixo;
	
	private static Date dataNasc, dataExp, dataNascConj;
	private static Date dataNula;
	private Date dataAtual, dataAtual2, dataAtual3;
	private static String result, result2, result3;
	private Date data = null, data2 = null, data3 = null;
	private MaskFormatter mascaraData;
	private static MaskFormatter mascaraVazia;
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraDataNova;
	
	static JButton btnExcluir;
	private Connection conn;
	private Fiador fiador;
	private static JComboBox cbRegimeDeBens;
	private static JComboBox cbEstado;
	private boolean ver;
	private JTabbedPane tabbedPane;
	private String casado;
	private static JTextField tfRGConjuge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFiador frame = new CadFiador();
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
	
	
	public CadFiador() {
		
		try {
			mascaraVazia = new MaskFormatter("");
			mascaraDataNova = new MaskFormatter("##/##/####");
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraTelefone = new MaskFormatter("(##) ####-####");
			mascaraData.setPlaceholderCharacter('_');
			mascaraTelefone.setPlaceholderCharacter('_');
			mascaraCPF.setPlaceholderCharacter('_');
			mascaraDataNova.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		setTitle("Cadastro de Fiador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 345, 694, 51);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 694, 345);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Informações Pessoais", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 17, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(10, 42, 46, 14);
		panel_1.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(104, 36, 226, 20);
		panel_1.add(tfNome);
		
		JLabel label_2 = new JLabel("Endere\u00E7o:");
		label_2.setBounds(10, 67, 62, 14);
		panel_1.add(label_2);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(104, 61, 226, 20);
		panel_1.add(tfEndereco);
		
		JLabel label_3 = new JLabel("N\u00FAmero:");
		label_3.setBounds(10, 92, 86, 14);
		panel_1.add(label_3);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(104, 86, 54, 20);
		panel_1.add(tfNumero);
		
		JLabel label_4 = new JLabel("Complemento:");
		label_4.setBounds(10, 117, 86, 14);
		panel_1.add(label_4);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(104, 111, 226, 20);
		panel_1.add(tfComplemento);
		
		JLabel label_5 = new JLabel("Telefone Fixo:");
		label_5.setBounds(10, 201, 86, 14);
		panel_1.add(label_5);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(104, 136, 226, 20);
		panel_1.add(tfBairro);
		
		JLabel label_6 = new JLabel("Celular:");
		label_6.setBounds(10, 232, 46, 14);
		panel_1.add(label_6);
		
		tfProfissao = new JTextField();
		tfProfissao.setColumns(10);
		tfProfissao.setBounds(104, 257, 165, 20);
		panel_1.add(tfProfissao);
		
		JLabel label_7 = new JLabel("Bairro:");
		label_7.setBounds(10, 142, 46, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Profiss\u00E3o:");
		label_8.setBounds(10, 263, 62, 14);
		panel_1.add(label_8);
		
		JLabel label_10 = new JLabel("CPF:");
		label_10.setBounds(350, 17, 46, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("RG:");
		label_11.setBounds(350, 42, 46, 14);
		panel_1.add(label_11);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		tfRG.setBounds(457, 36, 132, 20);
		panel_1.add(tfRG);
		
		JLabel label_12 = new JLabel("Data Nascimento:");
		label_12.setBounds(350, 67, 106, 14);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Data Expedi\u00E7\u00E3o:");
		label_13.setBounds(350, 92, 97, 14);
		panel_1.add(label_13);
		
		JLabel label_16 = new JLabel("Estado C\u00EDvil:");
		label_16.setBounds(350, 117, 86, 14);
		panel_1.add(label_16);
		
		cbEstado = new JComboBox();
		cbEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HabilitarConjuge();
			}
		});
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"Solteiro(a)", "Casado(a)", "Divorciado(a)", "V\u00EDuvo(a)"}));
		cbEstado.setBounds(456, 114, 133, 20);
		panel_1.add(cbEstado);
		
		JLabel label_17 = new JLabel("Email:");
		label_17.setBounds(10, 170, 46, 14);
		panel_1.add(label_17);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(104, 164, 226, 20);
		panel_1.add(tfEmail);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(104, 11, 86, 20);
		panel_1.add(tfId);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConFiador().setVisible(true);
				CadFiador.this.dispose();;
			}
		});
		button.setIcon(new ImageIcon(CadFiador.class.getResource("/Imagens/Zoom-icon.png")));
		button.setToolTipText("Pesquisar");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBackground(new Color(240, 240, 241));
		button.setBounds(198, 11, 29, 20);
		panel_1.add(button);
		
		tfDataNascimento = new JFormattedTextField();
		tfDataNascimento.setBounds(457, 61, 86, 20);
		panel_1.add(tfDataNascimento);
		
		tfDataExpedicao = new JFormattedTextField();
		tfDataExpedicao.setBounds(457, 86, 86, 20);
		panel_1.add(tfDataExpedicao);
		
		tfCPF = new JFormattedTextField();
		tfCPF.setBounds(457, 12, 132, 20);
		panel_1.add(tfCPF);
		
		tfTelefoneCelular = new JFormattedTextField();
		tfTelefoneCelular.setBounds(104, 226, 165, 20);
		panel_1.add(tfTelefoneCelular);
		
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
		tfTelefoneFixo.setBounds(104, 195, 165, 20);
		panel_1.add(tfTelefoneFixo);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Informações Comerciais", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfEnderecoComercial = new JTextField();
		tfEnderecoComercial.setColumns(10);
		tfEnderecoComercial.setBounds(156, 11, 257, 20);
		panel_2.add(tfEnderecoComercial);
		
		tfNumeroComercial = new JTextField();
		tfNumeroComercial.setColumns(10);
		tfNumeroComercial.setBounds(156, 36, 43, 20);
		panel_2.add(tfNumeroComercial);
		
		tfComplementoComercial = new JTextField();
		tfComplementoComercial.setColumns(10);
		tfComplementoComercial.setBounds(156, 61, 188, 20);
		panel_2.add(tfComplementoComercial);
		
		tfBairroComercial = new JTextField();
		tfBairroComercial.setColumns(10);
		tfBairroComercial.setBounds(156, 86, 188, 20);
		panel_2.add(tfBairroComercial);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setColumns(10);
		tfEmpresa.setBounds(156, 111, 188, 20);
		panel_2.add(tfEmpresa);
		
		tfTelefoneComercial = new JTextField();
		tfTelefoneComercial.setColumns(10);
		tfTelefoneComercial.setBounds(156, 136, 98, 20);
		panel_2.add(tfTelefoneComercial);
		
		JLabel label_9 = new JLabel("N\u00FAmero Comercial:");
		label_9.setBounds(10, 42, 115, 14);
		panel_2.add(label_9);
		
		JLabel label_14 = new JLabel("Bairro Comercial:");
		label_14.setBounds(10, 92, 115, 14);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("Empresa:");
		label_15.setBounds(10, 117, 115, 14);
		panel_2.add(label_15);
		
		JLabel label_18 = new JLabel("Telefone Comercial:");
		label_18.setBounds(10, 142, 115, 14);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel("Complemento Comercial:");
		label_19.setBounds(10, 67, 153, 14);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("Endere\u00E7o Comercial:");
		label_20.setBounds(10, 17, 128, 14);
		panel_2.add(label_20);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Informações do Cônjuge", null, panel_3, null);
		panel_3.setLayout(null);
		
		tfNomeConjuge = new JTextField();
		tfNomeConjuge.setColumns(10);
		tfNomeConjuge.setBounds(139, 11, 245, 20);
		panel_3.add(tfNomeConjuge);
		
		tfProfissaoConjuge = new JTextField();
		tfProfissaoConjuge.setColumns(10);
		tfProfissaoConjuge.setBounds(139, 36, 190, 20);
		panel_3.add(tfProfissaoConjuge);
		
		JLabel label_21 = new JLabel("Nome:");
		label_21.setBounds(10, 17, 46, 14);
		panel_3.add(label_21);
		
		JLabel label_22 = new JLabel("Profiss\u00E3o:");
		label_22.setBounds(10, 42, 79, 14);
		panel_3.add(label_22);
		
		JLabel label_23 = new JLabel("RG:");
		label_23.setBounds(10, 92, 46, 14);
		panel_3.add(label_23);
		
		JLabel label_24 = new JLabel("CPF:");
		label_24.setBounds(10, 117, 46, 14);
		panel_3.add(label_24);
		
		JLabel label_25 = new JLabel("Regime de Bens:");
		label_25.setBounds(10, 67, 96, 14);
		panel_3.add(label_25);
		
		JLabel label_26 = new JLabel("Data de Nascimento:");
		label_26.setBounds(10, 142, 120, 14);
		panel_3.add(label_26);
		
		cbRegimeDeBens = new JComboBox();
		cbRegimeDeBens.setModel(new DefaultComboBoxModel(new String[] {"Comunh\u00E3o Parcial", "Comunh\u00E3o Total", "Separa\u00E7\u00E3o Total"}));
		cbRegimeDeBens.setBounds(139, 61, 135, 20);
		panel_3.add(cbRegimeDeBens);
		
		tfCPFConjuge = new JFormattedTextField();
		tfCPFConjuge.setBounds(139, 111, 135, 20);
		panel_3.add(tfCPFConjuge);
		
		tfDataNascimentoConjuge = new JFormattedTextField();
		tfDataNascimentoConjuge.setBounds(139, 136, 135, 20);
		panel_3.add(tfDataNascimentoConjuge);
		
		tfRGConjuge = new JTextField();
		tfRGConjuge.setBounds(139, 87, 135, 20);
		panel_3.add(tfRGConjuge);
		tfRGConjuge.setColumns(10);
		
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

				try {
					final Integer numeroC;
					if (ver = VerificarCampos(true)) {
						if (ver == ValidarCPF(true)) {
							if (ver == ValidarCPFConjuge(true)) { 
						if (tfId.getText().isEmpty()) {
						if (tfNumeroComercial.getText().isEmpty()){
								if (cbEstado.getSelectedItem().equals("Casado(a)")) {
									numeroC = null;
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											numeroC,
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), data3,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									FiadorDAO.Inserir(fiador);
									LimparDados();
								} else {
									numeroC = null;
									dataNula = null;
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											numeroC,
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), dataNula,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									FiadorDAO.Inserir(fiador);
									LimparDados();
								}
							}
						}
						
						else if (!tfNumeroComercial.getText().isEmpty()) {
								if (cbEstado.getSelectedItem().equals("Casado(a)")) {
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											Integer.parseInt(tfNumeroComercial.getText()),
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), data3,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									FiadorDAO.Inserir(fiador);
									LimparDados();
						} else {
							dataNula = null;
							fiador = new Fiador(0, tfNome.getText(), tfEndereco
									.getText(), Integer.parseInt(tfNumero.getText()),
									tfComplemento.getText(), tfBairro.getText(),
									tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
									tfEmail.getText(), tfProfissao.getText(),
									tfEnderecoComercial.getText(),
									Integer.parseInt(tfNumeroComercial.getText()),
									tfComplementoComercial.getText(),
									tfBairroComercial.getText(), tfEmpresa.getText(),
									tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
											.getText(), data2, data,
									((String) cbEstado.getSelectedItem()), tfNomeConjuge
											.getText(), tfCPFConjuge.getText(), tfRGConjuge
											.getText(), dataNula,
									tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
											.getSelectedItem());
							FiadorDAO.Inserir(fiador);
							LimparDados();
						}
						}
						}
						}
					else {
							if (!tfId.getText().isEmpty()) {
							if (tfNumeroComercial.getText().isEmpty()){
									if (cbEstado.getSelectedItem().equals("Casado(a)")) {
									numeroC = null;
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											numeroC,
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), data3,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
									FiadorDAO.Atualizar(fiador, aux);
									LimparDados();
								} else {
									numeroC = null;
									dataNula = null;
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											numeroC,
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), dataNula,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
									FiadorDAO.Atualizar(fiador, aux);
									LimparDados();
								}
							}
							
								if (!tfNumeroComercial.getText().isEmpty()){
								if (!tfId.getText().isEmpty()) {
										if (cbEstado.getSelectedItem().equals("Casado(a)")) {
											fiador = new Fiador(0, tfNome.getText(), tfEndereco
													.getText(), Integer.parseInt(tfNumero.getText()),
													tfComplemento.getText(), tfBairro.getText(),
													tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
													tfEmail.getText(), tfProfissao.getText(),
													tfEnderecoComercial.getText(),
													Integer.parseInt(tfNumeroComercial.getText()),
													tfComplementoComercial.getText(),
													tfBairroComercial.getText(), tfEmpresa.getText(),
													tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
															.getText(), data2, data,
													((String) cbEstado.getSelectedItem()), tfNomeConjuge
															.getText(), tfCPFConjuge.getText(), tfRGConjuge
															.getText(), data3,
													tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
															.getSelectedItem());
											int aux = Integer.parseInt(tfId.getText());
											FiadorDAO.Atualizar(fiador, aux);
											LimparDados();
								} else {
									dataNula = null;
									fiador = new Fiador(0, tfNome.getText(), tfEndereco
											.getText(), Integer.parseInt(tfNumero.getText()),
											tfComplemento.getText(), tfBairro.getText(),
											tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
											tfEmail.getText(), tfProfissao.getText(),
											tfEnderecoComercial.getText(),
											Integer.parseInt(tfNumeroComercial.getText()),
											tfComplementoComercial.getText(),
											tfBairroComercial.getText(), tfEmpresa.getText(),
											tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
													.getText(), data2, data,
											((String) cbEstado.getSelectedItem()), tfNomeConjuge
													.getText(), tfCPFConjuge.getText(), tfRGConjuge
													.getText(), dataNula,
											tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
													.getSelectedItem());
									int aux = Integer.parseInt(tfId.getText());
									FiadorDAO.Atualizar(fiador, aux);
									LimparDados();
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
				
		

		btnSalvar.setIcon(new ImageIcon(CadFiador.class.getResource("/Imagens/Button-Add-icon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setOpaque(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(240, 240, 241));
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDados();
			}
		});
		btnCancelar.setIcon(new ImageIcon(CadFiador.class.getResource("/Imagens/Button-Close-icon.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(240, 240, 241));
		panel.add(btnCancelar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfNumeroComercial.getText().equals("") || (tfNumeroComercial.getText().equals(null))) {
						final Integer aux1 = null;
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								fiador = new Fiador(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(),
										aux1,
										tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, data,
										((String) cbEstado.getSelectedItem()), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						FiadorDAO.Remover(fiador, aux);
						LimparDados();
					} else {
						dataNula = null;
						fiador = new Fiador(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								aux1,
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, data,
								((String) cbEstado.getSelectedItem()), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
				int aux = Integer.parseInt(tfId.getText());
				FiadorDAO.Remover(fiador, aux);
					}
						 
					}
					else {
							if (cbEstado.getSelectedItem().equals("Casado(a)")) {
								fiador = new Fiador(0, tfNome.getText(), tfEndereco
										.getText(), Integer.parseInt(tfNumero.getText()),
										tfComplemento.getText(), tfBairro.getText(),
										tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
										tfEmail.getText(), tfProfissao.getText(),
										tfEnderecoComercial.getText(),
										Integer.parseInt(tfNumeroComercial.getText()),
										tfComplementoComercial.getText(),
										tfBairroComercial.getText(), tfEmpresa.getText(),
										tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
												.getText(), data2, data,
										((String) cbEstado.getSelectedItem()), tfNomeConjuge
												.getText(), tfCPFConjuge.getText(), tfRGConjuge
												.getText(), data3,
										tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
												.getSelectedItem());
						int aux = Integer.parseInt(tfId.getText());
						FiadorDAO.Remover(fiador, aux);
					} else {
						dataNula = null;
						fiador = new Fiador(0, tfNome.getText(), tfEndereco
								.getText(), Integer.parseInt(tfNumero.getText()),
								tfComplemento.getText(), tfBairro.getText(),
								tfTelefoneFixo.getText(), tfTelefoneCelular.getText(),
								tfEmail.getText(), tfProfissao.getText(),
								tfEnderecoComercial.getText(),
								Integer.parseInt(tfNumeroComercial.getText()),
								tfComplementoComercial.getText(),
								tfBairroComercial.getText(), tfEmpresa.getText(),
								tfTelefoneComercial.getText(), tfRG.getText(), tfCPF
										.getText(), data2, data,
								((String) cbEstado.getSelectedItem()), tfNomeConjuge
										.getText(), tfCPFConjuge.getText(), tfRGConjuge
										.getText(), dataNula,
								tfProfissaoConjuge.getText(), (String) cbRegimeDeBens
										.getSelectedItem());
				int aux = Integer.parseInt(tfId.getText());
				FiadorDAO.Remover(fiador, aux);
					}
					}
				}
				 catch (Exception p) {
					p.printStackTrace();
				}
			}
		});
		btnExcluir.setEnabled(false);

		btnExcluir.setIcon(new ImageIcon(CadFiador.class.getResource("/Imagens/Button-Delete-icon.png")));
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setOpaque(false);
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(240, 240, 241));
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPrincipal().setVisible(true);;
				CadFiador.this.dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(CadFiador.class.getResource("/Imagens/logout-icon.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setOpaque(false);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 241));
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
		
		
		setResizable(false);
		setLocationRelativeTo(null);
		HabilitarConjuge();

		//DEIXAR POR ULTIMO NO CÓDIGO
				addWindowListener(new WindowAdapter()  
			    {  
			      public void windowOpened(WindowEvent e)  
			      {tfNome.requestFocus();
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
				else if (tfRG.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo RG deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfRG.requestFocus();
					return false;
				}
			 
				else if (tfCPF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo CPF deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfCPF.requestFocus();
					return false;
				}
			 
				else if (tfDataExpedicao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Data de Expedição deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfDataExpedicao.requestFocus();
					return false;
				}
			 
				else if (tfDataNascimento.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo Data Nascimento deve ser preenchido!");
					tabbedPane.setSelectedIndex(0);
					tfDataNascimento.requestFocus();
					return false;
				}
				else if (cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfNomeConjuge.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "O Campo Nome do Cônjuge deve ser preenchido!");
					tabbedPane.setSelectedIndex(2);
					tfNomeConjuge.requestFocus();
					return false;
				} 
				else if (cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfProfissaoConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo Profissão do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfProfissao.requestFocus();
				return false;
			} 
				else if (cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfRGConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo RG do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfRGConjuge.requestFocus();
				return false;
			} 
				else if (cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfCPFConjuge.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "O Campo CPF do Cônjuge deve ser preenchido!");
				tabbedPane.setSelectedIndex(2);
				tfCPFConjuge.requestFocus();
				return false;
			} 
				else if (cbEstado.getSelectedItem().toString().equals("Casado(a)") && (tfDataNascimentoConjuge.getText().isEmpty())){
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
	public void MudarMascara() {
		
		tfDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNova));
		tfCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
		tfDataExpedicao.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
		tfTelefoneCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
		
	}
	public void LimparDados() {
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
		tfCPF.setText("");
		tfRG.setText("");
		tfDataExpedicao.setText("");
//		tfDataNascimento.setText("");
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
		cbEstado.setSelectedIndex(0);
		cbRegimeDeBens.setSelectedIndex(0);
		tabbedPane.setSelectedIndex(0);
		tfNome.requestFocus();
		btnExcluir.setEnabled(false);
		
		MudarMascara();
		
		HabilitarConjuge();
	}
	
	public void HabilitarConjuge() {
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
	
	public static void SetarDados(Fiador fiador) {
		String aux = Integer.toString(fiador.getId());
		String aux2 = Integer.toString(fiador.getNumero());
		String aux3 = Integer.toString(fiador.getNumeroComercial());
		int aux4 = fiador.getNumeroComercial();
		if (aux3 == null) {
			aux3 = "";
		}
		if (aux4 == 0) {
			aux3 = "";
		}
		if (fiador.getNumeroComercial().equals(0)) {
			aux3 = null;
		}
		else {
		aux3 = Integer.toString(fiador.getNumeroComercial());
		}
		
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if ((fiador.getDataExpedicao() != null)) {
				result2 = out.format(in.parse(fiador.getDataExpedicao().toString()));
			} else {
				result2 = "";
			}
				
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			if ((fiador.getDataNascimento() != null)) {
				result = out.format(in.parse(fiador.getDataNascimento().toString()));
			} else {
				result = "";
			}
				
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			if ((fiador.getDataNascimentoConjuge() != null)) {
				result3 = out.format(in.parse(fiador.getDataNascimentoConjuge().toString()));
			} else {
				result3 = "";
			}
				
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		tfId.setText(aux);
		tfNome.setText(fiador.getNome());
		tfEndereco.setText(fiador.getEndereco());
		tfNumero.setText(aux2);
		tfComplemento.setText(fiador.getComplemento());
		tfBairro.setText(fiador.getBairro());
		tfEmail.setText(fiador.getEmail());
		tfTelefoneFixo.setText(fiador.getTelefoneFixo());
		tfTelefoneCelular.setText(fiador.getTelefoneCelular());
		tfProfissao.setText(fiador.getProfissao());
		tfCPF.setText(fiador.getCPF());
		tfRG.setText(fiador.getRG());
		tfDataExpedicao.setText(result2);
		tfDataNascimento.setText(result);
		cbEstado.setSelectedItem(fiador.getEstadoCivil());
		tfEnderecoComercial.setText(fiador.getEnderecoComercial());
		tfNumeroComercial.setText(aux3);
		tfComplementoComercial.setText(fiador.getComplementoComercial());
		tfBairroComercial.setText(fiador.getBairroComercial());
		tfEmpresa.setText(fiador.getEmpresa());
		tfTelefoneComercial.setText(fiador.getTelefoneComercial());
		tfNomeConjuge.setText(fiador.getNomeConjuge());
		tfProfissaoConjuge.setText(fiador.getProfissaoConjuge());
		cbRegimeDeBens.setSelectedItem(fiador.getRegimeDeBens());
		tfRGConjuge.setText(fiador.getRGConjuge());
		tfCPFConjuge.setText(fiador.getCPFConjuge());
		tfDataNascimentoConjuge.setText(result3);
		btnExcluir.setEnabled(true);
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
}
