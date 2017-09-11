package tipoimovel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TipoImovelTableModel extends AbstractTableModel {
		
		ArrayList<TipoImovel> list;
		TipoImovel aux;
	
	public TipoImovelTableModel() {
		list = TipoImovelDAO.ListarPessoa();
	}
	
	public TipoImovel getTipoImovel(int indiceLinha) {
	    return list.get(indiceLinha);
	}
	
	@Override
	public int getColumnCount() {
		return 2;
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
			return aux.getDescricao();
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
			return "Descrição";
		default:
			return "X";
		}
	}

	@Override
	public void fireTableDataChanged() {
		list = TipoImovelDAO.ListarPessoa();
		super.fireTableDataChanged();
	}
	
	
}