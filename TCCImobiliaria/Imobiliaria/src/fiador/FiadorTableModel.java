package fiador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class FiadorTableModel extends AbstractTableModel
{
	
private static JTable table;
	ArrayList<Fiador> list;
	Fiador aux;

public FiadorTableModel() {
	list = FiadorDAO.ListarFiador();
}

public Fiador getFiador(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 27;
}


@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return list.size();
}

@Override
public Object getValueAt(int row, int column) {
	aux = list.get(row);
	
	String numeroC = Integer.toString(aux.getNumeroComercial());
	int numeroC2 = aux.getNumeroComercial();
	if (numeroC == null) {
		numeroC = "";
	}
	if (numeroC2 == 0) {
		numeroC = "";
	}
	
	switch (column){
	case 0:
		return aux.getId();
	case 1:
		return aux.getNome();
	case 2:
		return aux.getEndereco();
	case 3:
		return aux.getNumero();
	case 4:
		return aux.getComplemento();
	case 5:
		return aux.getBairro();
	case 6:
		return aux.getTelefoneFixo();
	case 7:
		return aux.getTelefoneCelular();
	case 8:
		return aux.getEmail();
	case 9:
		return aux.getProfissao();
	case 10:
		return aux.getEnderecoComercial();
	case 11:
		return numeroC;
	case 12:
		return aux.getComplementoComercial();
	case 13:
		return aux.getBairroComercial();
	case 14:
		return aux.getEmpresa();
	case 15:
		return aux.getTelefoneComercial();
	case 16:
		return aux.getRG();
	case 17:
		return aux.getCPF();
	case 18:
		return aux.getDataExpedicao();
	case 19:
		return aux.getDataNascimento();
	case 20:
		return aux.getEstadoCivil();
	case 21:
		return aux.getNomeConjuge();
	case 22:
		return aux.getCPFConjuge();
	case 23:
		return aux.getRGConjuge();
	case 24:
		return aux.getDataNascimentoConjuge();
	case 25:
		return aux.getProfissaoConjuge();
	case 26:
		return aux.getRegimeDeBens();
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
		return "Endereço";
	case 3:
		return "Número";
	case 4:
		return "Complemento";
	case 5:
		return "Bairro";
	case 6:
		return "Telefone Fixo";
	case 7:
		return "Telefone Celular";
	case 8:
		return "Email";
	case 9:
		return "Profissão";
	case 10:
		return "Endereço Comercial";
	case 11:
		return "Número Comercial";
	case 12:
		return "Complemento Comercial";
	case 13:
		return "Bairro Comercial";
	case 14:
		return "Empresa";
	case 15:
		return "Telefone Comercial";
	case 16:
		return "RG";
	case 17:
		return "CPF";
	case 18:
		return "Data Expedição";
	case 19:
		return "Data Nascimento";
	case 20:
		return "Estado Cívil";
	case 21:
		return "Nome Cônjuge";
	case 22:
		return "CPF Cônjuge";
	case 23:
		return "RG Cônjuge";
	case 24:
		return "Data Nasc Cônjuge";
	case 25:
		return "Profissão Cônjuge";
	case 26:
		return "Regime de Bens";
	default:
		return "X";
	}
}



@Override
public void fireTableDataChanged() {
	list = FiadorDAO.ListarFiador();
	super.fireTableDataChanged();
	
}
}
