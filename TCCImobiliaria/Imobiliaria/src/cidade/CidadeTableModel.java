package cidade;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import tipoimovel.TipoImovel;
import tipoimovel.TipoImovelDAO;

public class CidadeTableModel extends AbstractTableModel
{

	ArrayList<Cidade> list;
	Cidade aux;

public CidadeTableModel() {
	list = CidadeDAO.ListarCidade();
}

public Cidade getCidade(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 3;
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
		return aux.getNome();
	case 2:
		return aux.getUf();
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
		return "Nome";
	case 2:
		return "UF";
	default:
		return "X";
	}
}

@Override
public void fireTableDataChanged() {
	list = CidadeDAO.ListarCidade();
	super.fireTableDataChanged();
}
	
}
