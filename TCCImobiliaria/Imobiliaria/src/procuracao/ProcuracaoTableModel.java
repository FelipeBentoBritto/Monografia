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
		return "ID Im�vel";
	case 2:
		return "Tipo Im�vel";
	case 3:
		return "Propriet�rio";
	case 4:
		return "Raz�o Social";
	case 5:
		return "Cidade";
	case 6:
		return "UF";
	case 7:
		return "Endere�o Im�vel";
	case 8:
		return "N�mero Im�vel";
	case 9:
		return "Complemento Im�vel";
	case 10:
		return "Bairro Im�vel";
	case 11:
		return "Endere�o Propriet�rio";
	case 12:
		return "N�mero Propriet�rio";
	case 13:
		return "Complemento Propriet�rio";
	case 14:
		return "Bairro Propriet�rio";
	case 15:
		return "CPF Propriet�rio";
	case 16:
		return "CNPJ Propriet�rio";
	case 17:
		return "Tipo de Pessoa";
	case 18:
		return "Estado C�vil";
	case 19:
		return "Nome C�njuge";
	case 20:
		return "CPF C�njuge";
	case 21:
		return "Situa��o";
	case 22:
		return "Data de Assinatura";
	case 23:
		return "Cl�usulas";
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
