package proprietario;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class ProprietarioTableModel extends AbstractTableModel
{
private static JTable table;
	ArrayList<ProprietarioCidade> list;
	ProprietarioCidade aux;

public ProprietarioTableModel() {
	list = ProprietarioDAO.ListarProprietario();
}

public ProprietarioCidade getProprietario(int indiceLinha) {
    return list.get(indiceLinha);
}

@Override
public int getColumnCount() {
	return 38;
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
		return aux.getNomeCidade();
	case 2:
		return aux.getUfCidade();
	case 3:
		return aux.getNome();
	case 4:
		return aux.getEndereco();
	case 5:
		return aux.getNumero();
	case 6:
		return aux.getComplemento();
	case 7:
		return aux.getBairro();
	case 8:
		return aux.getTelefoneFixo();
	case 9:
		return aux.getTelefoneCelular();
	case 10:
		return aux.getEmail();
	case 11:
		return aux.getProfissao();
	case 12:
		return aux.getCNPJ();
	case 13:
		return aux.getRazaoSocial();
	case 14:
		return aux.getRG();
	case 15:
		return aux.getCPF();
	case 16:
		return aux.getDataExpedicao();
	case 17:
		return aux.getDataNascimento();
	case 18:
		return aux.getTipoPessoa();
	case 19:
		return aux.getBanco();
	case 20:
		return aux.getTipoConta();
	case 21:
		return aux.getAgenciaBancaria();
	case 22:
		return aux.getContaBancaria();
	case 23:
		return aux.getChequeFavorecido();
	case 24:
		return aux.getChequeCPF();
	case 25:
		return aux.getEnderecoComercial();
	case 26:
		return aux.getNumeroComercial();
	case 27:
		return aux.getComplementoComercial();
	case 28:
		return aux.getBairroComercial();
	case 29:
		return aux.getEmpresa();
	case 30:
		return aux.getTelefoneComercial();
	case 31:
		return aux.getEstadoCivil();
	case 32:
		return aux.getNomeConjuge();
	case 33:
		return aux.getCPFConjuge();
	case 34:
		return aux.getRGConjuge();
	case 35:
		return aux.getDataNascimentoConjuge();
	case 36:
		return aux.getProfissaoConjuge();
	case 37:
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
		return "Cidade";
	case 2:
		return "UF";
	case 3:
		return "Nome";
	case 4:
		return "Endereço";
	case 5:
		return "Número";
	case 6:
		return "Complemento";
	case 7:
		return "Bairro";
	case 8:
		return "Telefone Fixo";
	case 9:
		return "Telefone Cel";
	case 10:
		return "Email";
	case 11:
		return "Profissão";
	case 12:
		return "CNPJ";
	case 13:
		return "Razão Social";
	case 14:
		return "RG";
	case 15:
		return "CPF";
	case 16:
		return "Data de Expedição";
	case 17:
		return "Data de Nascimento";
	case 18:
		return "Tipo de Pessoa";
	case 19:
		return "Banco";
	case 20:
		return "Tipo de Conta";
	case 21:
		return "Agência Bancária";
	case 22:
		return "Conta Bancária";
	case 23:
		return "Favorecido do Cheque";
	case 24:
		return "CPF do Favorecido";
	case 25:
		return "Endereço Comercial";
	case 26:
		return "Número Comercial";
	case 27:
		return "Complemento Comercial";
	case 28:
		return "Bairro Comercial";
	case 29:
		return "Empresa";
	case 30:
		return "Telefone Comercial";
	case 31:
		return "Estado Cívil";
	case 32:
		return "Nome Cônjuge";
	case 33:
		return "CPF Cônjuge";
	case 34:
		return "RG Cônjuge";
	case 35:
		return "Data Nasc Cônjuge";
	case 36:
		return "Profissão Cônjuge";
	case 37:
		return "Regime de Bens";
	default:
		return "X";	}
}



@Override
public void fireTableDataChanged() {
	list = ProprietarioDAO.ListarProprietario();
	super.fireTableDataChanged();
	
}
}