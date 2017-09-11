package imovel;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tipoimovel.TipoImovel;
import tipoimovel.TipoImovelDAO;

public class ImovelTableModel extends AbstractTableModel {
	private static JTable table;
	ArrayList<ImovelConsulta> list;
	ImovelConsulta aux;

public ImovelTableModel() {
	list = ImovelDAO.ListarImovel();
}

public ImovelConsulta getImovel(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 18;
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
		return aux.getTipoImovel();
	case 2:
		return aux.getProprietario();
	case 3:
		return aux.getEndereco();
	case 4:
		return aux.getComplemento();
	case 5:
		return aux.getNumero();
	case 6:
		return aux.getBairro();
	case 7:
		return aux.getCep();
	case 8:
		return aux.getDescricao();
	case 9:
		return aux.getTaxaAdm();
	case 10:
		return aux.getValorImovel();
	case 11:
		return aux.getAreaTe();
	case 12:
		return aux.getAreaCons();
	case 13:
		return aux.getObservacoes();
	case 14:
		return aux.getEstrutura();
	case 15:
		return aux.getProximidades();
	case 16:
		return aux.getDataEntrada();
	case 17:
		return aux.getEstado();
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
		return "Tipo Imóvel";
	case 2:
		return "Proprietário";
	case 3:
		return "Endereço";
	case 4:
		return "Complemento";
	case 5:
		return "Número";
	case 6:
		return "Bairro";
	case 7:
		return "CEP";
	case 8:
		return "Descrição";
	case 9:
		return "Taxa Adm";
	case 10:
		return "Valor Imóvel";
	case 11:
		return "Área Terreno";
	case 12:
		return "Área Construção";
	case 13:
		return "Observações";
	case 14:
		return "Estrutura";
	case 15:
		return "Proximidades";
	case 16:
		return "Data de Entrada";
	case 17:
		return "Estado";
	default:
		return "X";
	}
}

@Override
public void fireTableDataChanged() {
	list = ImovelDAO.ListarImovel();
	super.fireTableDataChanged();
}


}
