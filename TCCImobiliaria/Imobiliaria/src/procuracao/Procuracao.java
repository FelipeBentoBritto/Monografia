package procuracao;

import java.util.Date;

public class Procuracao {

	private int id;
	private int idImovel;
	private int idProprietario;
	private String clausulas;
	private String situacao;
	private Date dataAssinaturaProcuracao;
	
	public Procuracao(int id, int idImovel, int idProprietario, String clausulas, String situacao, Date dataAssinaturaProcuracao) {
		this.setId(id);
		this.setIdImovel(idImovel);
		this.setIdProprietario(idProprietario);
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

	public int getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	public int getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(int idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getClausulas() {
		return clausulas;
	}

	public void setClausulas(String clausulas) {
		this.clausulas = clausulas;
	}

	public String getSituacao() {
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
	
}
