package imovel;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ImovelProcTableModel extends AbstractTableModel {
	private static JTable table;
	ArrayList<ImovelProcConsulta> list;
	ImovelProcConsulta aux;

public ImovelProcTableModel() {
	list = ImovelDAO.ListarImovelProc();
}

public ImovelProcConsulta getImovel(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 20;
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
		return aux.getNomeTipoImovel();
	case 2:
		return aux.getNomeProprietario();
	case 3:
		return aux.getRazaoSocialProprietario();
	case 4:
		return aux.getNomeCidade();
	case 5:
		return aux.getUfCidade();
	case 6:
		return aux.getEnderecoImovel();
	case 7:
		return aux.getNumeroImovel();
	case 8:
		return aux.getComplementoImovel();
	case 9:
		return aux.getBairroImovel();
	case 10:
		return aux.getEnderecoProprietario();
	case 11:
		return aux.getNumeroProprietario();
	case 12:
		return aux.getComplementoProprietario();
	case 13:
		return aux.getBairroProprietario();
	case 14:
		return aux.getCpfProprietario();
	case 15:
		return aux.getCnpjProprietario();
	case 16:
		return aux.getTipoPessoaProprietario();
	case 17:
		return aux.getEstadoCivilProprietario();
	case 18:
		return aux.getNomeConjuge();
	case 19:
		return aux.getCpfConjuge();
	case 20:
		return aux.getAtivo();
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
		return "Tipo Im�vel";
	case 2:
		return "Propriet�rio";
	case 3:
		return "Raz�o Social";
	case 4:
		return "Cidade";
	case 5:
		return "UF";
	case 6:
		return "Endere�o Im�vel";
	case 7:
		return "N�mero Im�vel";
	case 8:
		return "Complemento Im�vel";
	case 9:
		return "Bairro Im�vel";
	case 10:
		return "Endere�o Propriet�rio";
	case 11:
		return "N�mero Propriet�rio";
	case 12:
		return "Complemento Propriet�rio";
	case 13:
		return "Bairro Propriet�rio";
	case 14:
		return "CPF Propriet�rio";
	case 15:
		return "CNPJ Propriet�rio";
	case 16:
		return "Tipo de Pessoa";
	case 17:
		return "Estado C�vil";
	case 18:
		return "Nome C�njuge";
	case 19:
		return "CPF C�njuge";
	case 20:
		return "Atividade";
	default:
		return "X";
	}
}

@Override
public void fireTableDataChanged() {
	list = ImovelDAO.ListarImovelProc();
	super.fireTableDataChanged();
}


}