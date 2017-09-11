package imovel;

import java.util.Date;

public class ImovelConsulta {
	
	private int id;
	private Integer idTipoImovel;
	private Integer idProprietario;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String descricao;
	private Double taxaAdm;
	private Double valorImovel;
	private Double areaTe;
	private Double areaCons;
	private String observacoes;
	private String estrutura;
	private String proximidades;
	private Date dataEntrada;
	private String estado;
	private String tipoImovel;
	private String proprietario;
	
	public ImovelConsulta(int id, Integer idTipoImovel, String tipoImovel, Integer idProprietario, String proprietario, String endereco, int numero, String complemento, String bairro, String cep, String descricao, Double taxaAdm, Double valorImovel, Double areaTe,
			Double areaCons, String observacoes, String estrutura, String proximidades, Date dataEntrada, String estado) {
		
		this.setId(id);
		this.setIdTipoImovel(idTipoImovel);
		this.setIdProprietario(idProprietario);
		this.setEndereco(endereco);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setDescricao(descricao);
		this.setTaxaAdm(taxaAdm);
		this.setValorImovel(valorImovel);
		this.setAreaTe(areaTe);
		this.setAreaCons(areaCons);
		this.setObservacoes(observacoes);
		this.setEstrutura(estrutura);
		this.setProximidades(proximidades);
		this.setDataEntrada(dataEntrada);
		this.setEstado(estado);
		this.setTipoImovel(tipoImovel);
		this.setProprietario(proprietario);
	}

	public String getTipoImovel() {
		return tipoImovel;
	}
	
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	
	public String getProprietario(){
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Integer idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}
	
	public Integer getidProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getTaxaAdm() {
		return taxaAdm;
	}

	public void setTaxaAdm(Double taxaAdm) {
		this.taxaAdm = taxaAdm;
	}

	public Double getValorImovel() {
		return valorImovel;
	}

	public void setValorImovel(Double valorImovel) {
		this.valorImovel = valorImovel;
	}
	
	public Double getAreaTe() {
		return areaTe;
	}

	public void setAreaTe(Double areaTe) {
		this.areaTe = areaTe;
	}

	public Double getAreaCons() {
		return areaCons;
	}

	public void setAreaCons(Double areaCons) {
		this.areaCons = areaCons;
	}
	
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}
	
	public String getProximidades() {
		return proximidades;
	}

	public void setProximidades(String proximidades) {
		this.proximidades = proximidades;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
