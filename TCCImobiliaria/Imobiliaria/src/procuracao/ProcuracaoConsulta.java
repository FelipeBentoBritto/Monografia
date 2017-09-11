package procuracao;

import java.util.Date;

public class ProcuracaoConsulta {
	private int id;
	private Integer idImovel;
	private Integer idTipoImovel;
	private Integer idProprietario;
	private Integer idCidade;
	private String nomeCidade;
	private String ufCidade;
	private String nomeTipoImovel;
	private String nomeProprietario;
	private String enderecoImovel;
	private int numeroImovel;
	private String complementoImovel;
	private String bairroImovel;
	private String enderecoProprietario;
	private int numeroProprietario;
	private String complementoProprietario;
	private String bairroProprietario;
	private String cpfProprietario;
	private String cnpjProprietario;
	private String tipoPessoaProprietario;
	private String estadoCivilProprietario;
	private String nomeConjuge;
	private String cpfConjuge;
	private String razaoSocialProprietario;

	private String clausulas;
	private String situacao;
	private Date dataAssinaturaProcuracao;
	
	private static String validacaoAssinatura;
	public static String validar;

	public ProcuracaoConsulta(int id, Integer idImovel, Integer idTipoImovel,
			String nomeTipoImovel, Integer idProprietario,
			String nomeProprietario, String razaoSocialProprietaro,
			Integer idCidade, String nomeCidade, String ufCidade,
			String enderecoProprietario, int numeroProprietario,
			String complementoProprietario, String bairroProprietario,
			String cpfProprietario, String cnpjProprietario,
			String tipoPessoaProprietario, String estadoCivilProprietario,
			String nomeConjuge, String cpfConjuge, String enderecoImovel,
			int numeroImovel, String complementoImovel, String bairroImovel,
			String situacao, Date dataAssinaturaProcuracao, String clausulas) {

		this.setId(id);
		this.setIdImovel(idImovel);
		this.setIdTipoImovel(idTipoImovel);
		this.setNomeTipoImovel(nomeTipoImovel);
		this.setIdProprietario(idProprietario);
		this.setNomeProprietario(nomeProprietario);
		this.setIdCidade(idCidade);
		this.setNomeCidade(nomeCidade);
		this.setUfCidade(ufCidade);
		this.setEnderecoImovel(enderecoImovel);
		this.setNumeroImovel(numeroImovel);
		this.setComplementoImovel(complementoImovel);
		this.setBairroImovel(bairroImovel);
		this.setEnderecoProprietario(enderecoProprietario);
		this.setNumeroProprietario(numeroProprietario);
		this.setComplementoProprietario(complementoProprietario);
		this.setBairroProprietario(bairroProprietario);
		this.setCpfProprietario(cpfProprietario);
		this.setCnpjProprietario(cnpjProprietario);
		this.setTipoPessoaProprietario(tipoPessoaProprietario);
		this.setEstadoCivilProprietario(estadoCivilProprietario);
		this.setNomeConjuge(nomeConjuge);
		this.setCpfConjuge(cpfConjuge);
		this.setRazaoSocialProprietario(razaoSocialProprietaro);
		this.setClausulas(clausulas);
		this.setSituacao(situacao);
		this.setDataAssinaturaProcuracao(dataAssinaturaProcuracao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public Integer getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Integer idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}

	public String getNomeTipoImovel() {
		return nomeTipoImovel;
	}

	public void setNomeTipoImovel(String nomeTipoImovel) {
		this.nomeTipoImovel = nomeTipoImovel;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getEnderecoImovel() {
		return enderecoImovel;
	}

	public void setEnderecoImovel(String enderecoImovel) {
		this.enderecoImovel = enderecoImovel;
	}

	public int getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(int numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public String getComplementoImovel() {
		return complementoImovel;
	}

	public void setComplementoImovel(String complementoImovel) {
		this.complementoImovel = complementoImovel;
	}

	public String getBairroImovel() {
		return bairroImovel;
	}

	public void setBairroImovel(String bairroImovel) {
		this.bairroImovel = bairroImovel;
	}

	public String getEnderecoProprietario() {
		return enderecoProprietario;
	}

	public void setEnderecoProprietario(String enderecoProprietario) {
		this.enderecoProprietario = enderecoProprietario;
	}

	public int getNumeroProprietario() {
		return numeroProprietario;
	}

	public void setNumeroProprietario(int numeroProprietario) {
		this.numeroProprietario = numeroProprietario;
	}

	public String getComplementoProprietario() {
		return complementoProprietario;
	}

	public void setComplementoProprietario(String complementoProprietario) {
		this.complementoProprietario = complementoProprietario;
	}

	public String getBairroProprietario() {
		return bairroProprietario;
	}

	public void setBairroProprietario(String bairroProprietario) {
		this.bairroProprietario = bairroProprietario;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public String getCnpjProprietario() {
		return cnpjProprietario;
	}

	public void setCnpjProprietario(String cnpjProprietario) {
		this.cnpjProprietario = cnpjProprietario;
	}

	public String getTipoPessoaProprietario() {
		return tipoPessoaProprietario;
	}

	public void setTipoPessoaProprietario(String tipoPessoaProprietario) {
		this.tipoPessoaProprietario = tipoPessoaProprietario;
	}

	public String getEstadoCivilProprietario() {
		return estadoCivilProprietario;
	}

	public void setEstadoCivilProprietario(String estadoCivilProprietario) {
		this.estadoCivilProprietario = estadoCivilProprietario;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getCpfConjuge() {
		return cpfConjuge;
	}

	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}

	public String getRazaoSocialProprietario() {
		return razaoSocialProprietario;
	}

	public void setRazaoSocialProprietario(String razaoSocialProprietario) {
		this.razaoSocialProprietario = razaoSocialProprietario;
	}

	public String getClausulas() {
		return clausulas;
	}

	public void setClausulas(String clausulas) {
		this.clausulas = clausulas;
	}

	public String getSituacao() {
		validar = situacao;
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataAssinaturaProcuracao() {
		return dataAssinaturaProcuracao;
	}

	public void setDataAssinaturaProcuracao(Date dataAssinaturaProcuracao) {
		this.dataAssinaturaProcuracao = dataAssinaturaProcuracao;
	}
	public static String getValidacaoAssinatura() {
		return validar;
	}
}