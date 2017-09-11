package procuracao;

import imovel.ImovelDAO;
import imovel.ImovelProcConsulta;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ProcuracaoTableModel extends AbstractTableModel {
	private static JTable table;
	ArrayList<ProcuracaoConsulta> list;
	ProcuracaoConsulta aux;

public ProcuracaoTableModel() {
	list = ProcuracaoDAO.ListarProcuracao();
}

public ProcuracaoConsulta getImovel(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 24;
}

@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return list.size();
}

@Override
public Object getValueAt(int row, int column) {
	aux = list.get(row);
	
	switch (column){
	case 0:
		return aux.getId();
	case 1:
		return aux.getIdImovel();
	case 2:
		return aux.getNomeTipoImovel();
	case 3:
		return aux.getNomeProprietario();
	case 4:
		return aux.getRazaoSocialProprietario();
	case 5:
		return aux.getNomeCidade();
	case 6:
		return aux.getUfCidade();
	case 7:
		return aux.getEnderecoImovel();
	case 8:
		return aux.getNumeroImovel();
	case 9:
		return aux.getComplementoImovel();
	case 10:
		return aux.getBairroImovel();
	case 11:
		return aux.getEnderecoProprietario();
	case 12:
		return aux.getNumeroProprietario();
	case 13:
		return aux.getComplementoProprietario();
	case 14:
		return aux.getBairroProprietario();
	case 15:
		return aux.getCpfProprietario();
	case 16:
		return aux.getCnpjProprietario();
	case 17:
		return aux.getTipoPessoaProprietario();
	case 18:
		return aux.getEstadoCivilProprietario();
	case 19:
		return aux.getNomeConjuge();
	case 20:
		return aux.getCpfConjuge();
	case 21:
		return aux.getSituacao();
	case 22:
		return aux.getDataAssinaturaProcuracao();
	case 23:
		return aux.getClausulas();
	default:
		return "X";
	}
}

@Override
public String getColumnName(int column) {
	switch (column) {
	case 0:
		return "ID";
	case 1:
		return "ID Imóvel";
	case 2:
		return "Tipo Imóvel";
	case 3:
		return "Proprietário";
	case 4:
		return "Razão Social";
	case 5:
		return "Cidade";
	case 6:
		return "UF";
	case 7:
		return "Endereço Imóvel";
	case 8:
		return "Número Imóvel";
	case 9:
		return "Complemento Imóvel";
	case 10:
		return "Bairro Imóvel";
	case 11:
		return "Endereço Proprietário";
	case 12:
		return "Número Proprietário";
	case 13:
		return "Complemento Proprietário";
	case 14:
		return "Bairro Proprietário";
	case 15:
		return "CPF Proprietário";
	case 16:
		return "CNPJ Proprietário";
	case 17:
		return "Tipo de Pessoa";
	case 18:
		return "Estado Cívil";
	case 19:
		return "Nome Cônjuge";
	case 20:
		return "CPF Cônjuge";
	case 21:
		return "Situação";
	case 22:
		return "Data de Assinatura";
	case 23:
		return "Cláusulas";
	default:
		return "X";
	}
}

@Override
public void fireTableDataChanged() {
	
	list = ProcuracaoDAO.ListarProcuracao();
	super.fireTableDataChanged();
}
}
