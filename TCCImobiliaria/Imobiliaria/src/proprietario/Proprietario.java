package proprietario;

import java.util.Date;

public class Proprietario {
	private int id;
	private int idCidade;
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
	private Integer numeroComercial;
	private String complementoComercial;
	private String bairroComercial;
	private String empresa;
	private String telefoneComercial;
	private String CNPJ;
	private String razaoSocial;
	private String RG;
	private String CPF;
	private Date dataExpedicao;
	private String banco;
	private String contaBancaria;
	private String agenciaBancaria;
	private Date dataNascimento;
	private String estadoCivil;
	private String chequeFavorecido;
	private String chequeCPF;
	private String tipoPessoa;
	private String tipoConta;
	private String nomeConjuge;
	private String CPFConjuge;
	private String RGConjuge;
	private Date dataNascimentoConjuge;
	private String profissaoConjuge;
	private String regimeDeBens;

public Proprietario(int id, int idCidade, String nome, String endereco, int numero, String complemento, String bairro, String telefoneFixo, String telefoneCelular, String email, String profissao,
		String enderecoComercial, Integer numeroComercial, String complementoComercial, String bairroComercial, String empresa, String telefoneComercial, String CNPJ, String razaoSocial, String RG, String CPF,
		Date dataExpedicao, String banco, String contaBancaria, String agenciaBancaria, Date dataNascimento, String estadoCivil, String chequeFavorecido, String chequeCPF, String tipoPessoa, String tipoConta, 
		String nomeConjuge, String CPFConjuge, String RGConjuge, Date dataNascimentoConjuge, String profissaoConjuge, String regimeDeBens) {
	
	this.setId(id);
	this.setIdCidade(idCidade);
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
	this.setBanco(banco);
	this.setContaBancaria(contaBancaria);
	this.setAgenciaBancaria(agenciaBancaria);
	this.setDataNascimento(dataNascimento);
	this.setEstadoCivil(estadoCivil);
	this.setChequeFavorecido(chequeFavorecido);
	this.setChequeCPF(chequeCPF);
	this.setTipoPessoa(tipoPessoa);
	this.setTipoConta(tipoConta);
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

public int getIdCidade() {
	return idCidade;
}

public void setIdCidade(int idCidade) {
	this.idCidade = idCidade;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
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

public String getTelefoneFixo() {
	return telefoneFixo;
}

public void setTelefoneFixo(String telefoneFixo) {
	this.telefoneFixo = telefoneFixo;
}

public String getTelefoneCelular() {
	return telefoneCelular;
}

public void setTelefoneCelular(String telefoneCelular) {
	this.telefoneCelular = telefoneCelular;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

public String getRazaoSocial() {
	return razaoSocial;
}

public void setRazaoSocial(String razaoSocial) {
	this.razaoSocial = razaoSocial;
}

public String getRG() {
	return RG;
}

public void setRG(String rG) {
	RG = rG;
}

public String getCPF() {
	return CPF;
}

public void setCPF(String cPF) {
	CPF = cPF;
}

public Date getDataExpedicao() {
	return dataExpedicao;
}

public void setDataExpedicao(Date dataExpedicao) {
	this.dataExpedicao = dataExpedicao;
}

public String getBanco() {
	return banco;
}

public void setBanco(String banco) {
	this.banco = banco;
}

public String getContaBancaria() {
	return contaBancaria;
}

public void setContaBancaria(String contaBancaria) {
	this.contaBancaria = contaBancaria;
}

public String getAgenciaBancaria() {
	return agenciaBancaria;
}

public void setAgenciaBancaria(String agenciaBancaria) {
	this.agenciaBancaria = agenciaBancaria;
}

public Date getDataNascimento() {
	return dataNascimento;
}

public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public String getEstadoCivil() {
	return estadoCivil;
}

public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
}

public String getChequeFavorecido() {
	return chequeFavorecido;
}

public void setChequeFavorecido(String chequeFavorecido) {
	this.chequeFavorecido = chequeFavorecido;
}

public String getChequeCPF() {
	return chequeCPF;
}

public void setChequeCPF(String chequeCPF) {
	this.chequeCPF = chequeCPF;
}

public String getTipoPessoa() {
	return tipoPessoa;
}

public void setTipoPessoa(String tipoPessoa) {
	this.tipoPessoa = tipoPessoa;
}

public String getTipoConta() {
	return tipoConta;
}

public void setTipoConta(String tipoConta) {
	this.tipoConta = tipoConta;
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

public void setCPFConjuge(String cPFConjuge) {
	CPFConjuge = cPFConjuge;
}

public String getRGConjuge() {
	return RGConjuge;
}

public void setRGConjuge(String rGConjuge) {
	RGConjuge = rGConjuge;
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
	return regimeDeBens;
}

public void setRegimeDeBens(String regimeDeBens) {
	this.regimeDeBens = regimeDeBens;
}
}
