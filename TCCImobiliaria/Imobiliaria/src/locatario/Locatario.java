package locatario;

import java.util.Date;

public class Locatario {

	private int id;
	private String nome;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;
	private String profissao;
	private String enderecoComercial;
	public Integer numeroComercial;
	private String complementoComercial;
	private String bairroComercial;
	private String empresa;
	private String telefoneComercial;
	private String CNPJ;
	private String razaoSocial;
	private String RG;
	private String CPF;
	private Date dataExpedicao;
	private int renda;
	private Date dataNascimento;
	private String estadoCivil;
	private String tipoPessoa;
	private String nomeConjuge;
	private String CPFConjuge;
	private String RGConjuge;
	private Date dataNascimentoConjuge;
	private String profissaoConjuge;
	private String regimeDeBens;
	
		public Locatario(int id, String nome, String endereco, int numero,
			String complemento, String bairro, String telefoneFixo, String telefoneCelular,
			String email, String profissao, String enderecoComercial, Integer numeroComercial,
			String complementoComercial, String bairroComercial, String empresa, String telefoneComercial,
			String CNPJ, String razaoSocial, String RG, String CPF,
			Date dataExpedicao, int renda, Date dataNascimento,
			String estadoCivil,  String tipoPessoa, String nomeConjuge, String CPFConjuge, String RGConjuge,
			Date dataNascimentoConjuge, String profissaoConjuge, String regimeDeBens) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setTelefoneFixo(telefoneFixo);
		this.setTelefoneCelular(telefoneCelular);
		this.setEmail(email);
		this.setProfissao(profissao);
		this.setEnderecoComercial(enderecoComercial);
		this.setNumeroComercial(numeroComercial);
		this.setComplementoComercial(complementoComercial);
		this.setBairroComercial(bairroComercial);
		this.setEmpresa(empresa);
		this.setTelefoneComercial(telefoneComercial);
		this.setCNPJ(CNPJ);
		this.setRazaoSocial(razaoSocial);
		this.setRG(RG);
		this.setCPF(CPF);
		this.setDataExpedicao(dataExpedicao);
		this.setRenda(renda);
		this.setDataNascimento(dataNascimento);
		this.setTipoPessoa(tipoPessoa);
		this.setEstadoCivil(estadoCivil);
		this.setNomeConjuge(nomeConjuge);
		this.setCPFConjuge(CPFConjuge);
		this.setRGConjuge(RGConjuge);
		this.setDataNascimentoConjuge(dataNascimentoConjuge);
		this.setProfissaoConjuge(profissaoConjuge);
		this.setRegimeDeBens(regimeDeBens);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(String enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}
	
	public Integer getNumeroComercial() {
		return numeroComercial;
	}

	public void setNumeroComercial(Integer numeroComercial) {
		this.numeroComercial = numeroComercial;
	}

	public String getComplementoComercial() {
		return complementoComercial;
	}

	public void setComplementoComercial(String complementoComercial) {
		this.complementoComercial = complementoComercial;
	}

	public String getBairroComercial() {
		return bairroComercial;
	}

	public void setBairroComercial(String bairroComercial) {
		this.bairroComercial = bairroComercial;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao2) {
		this.dataExpedicao = dataExpedicao2;
	}

	public int getRenda() {
		return renda;
	}

	public void setRenda(int renda) {
		this.renda = renda;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return (String) estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTipoPessoa() {
		return (String) tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getCPFConjuge() {
		return CPFConjuge;
	}

	public void setCPFConjuge(String CPFConjuge) {
		this.CPFConjuge = CPFConjuge;
	}

	public String getRGConjuge() {
		return RGConjuge;
	}

	public void setRGConjuge(String RGConjuge) {
		this.RGConjuge = RGConjuge;
	}

	public Date getDataNascimentoConjuge() {
		return dataNascimentoConjuge;
	}

	public void setDataNascimentoConjuge(Date dataNascimentoConjuge) {
		this.dataNascimentoConjuge = dataNascimentoConjuge;
	}

	public String getProfissaoConjuge() {
		return profissaoConjuge;
	}

	public void setProfissaoConjuge(String profissaoConjuge) {
		this.profissaoConjuge = profissaoConjuge;
	}

	public String getRegimeDeBens() {
		return (String) regimeDeBens;
	}

	public void setRegimeDeBens(String regimeDeBens) {
		this.regimeDeBens = regimeDeBens;
	}
	
}
