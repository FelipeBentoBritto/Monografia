package fiador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cidade.Cidade;
import locatario.Locatario;
import fabricaconexao.ConexaoSingleton;

public class FiadorDAO {

	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Fiador fiador;

	public static void Inserir(Fiador fiador) {
		try {
			sql = "INSERT INTO fiador (idFiador, nomeFiador, enderecoFiador, numeroFiador, complementoFiador, bairroFiador, telefoneFixoFiador, telefoneCelularFiador, emailFiador, profissaoFiador, enderecoComercialFiador, numeroComercialFiador, complementoComercialFiador, bairroComercialFiador, empresaFiador, telefoneComercialFiador,  RGFiador, CPFFiador, dataExpedicaoFiador, dataNascimentoFiador, estadoCivilFiador, nomeConjugeFiador, CPFConjugeFiador, RGConjugeFiador, dataNascimentoConjugeFiador, profissaoConjugeFiador, regimeDeBensConjugeFiador) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fiador.getId());
			pst.setString(2, fiador.getNome());
			pst.setString(3, fiador.getEndereco());
			pst.setInt(4, fiador.getNumero());
			pst.setString(5, fiador.getComplemento());
			pst.setString(6, fiador.getBairro());
			pst.setString(7, fiador.getTelefoneFixo());
			pst.setString(8, fiador.getTelefoneCelular());
			pst.setString(9, fiador.getEmail());
			pst.setString(10, fiador.getProfissao());
			pst.setString(11, fiador.getEnderecoComercial());
			if(fiador.getNumeroComercial()!= null){  
			    pst.setInt(12, fiador.getNumeroComercial());   
			}else{  
			    pst.setNull(12, 0);     
			}      
			//pst.setInt(12, fiador.getNumeroComercial());
			pst.setString(13, fiador.getComplementoComercial());
			pst.setString(14, fiador.getBairroComercial());
			pst.setString(15, fiador.getEmpresa());
			pst.setString(16, fiador.getTelefoneComercial());
			pst.setString(17, fiador.getRG());
			pst.setString(18, fiador.getCPF());
//			pst.setString(19, fiador.getDataExpedicao());
			if (fiador.getDataExpedicao() != null) {
				pst.setDate(19, new java.sql.Date(fiador.getDataExpedicao().getTime()));
				} else {
					pst.setDate(19, null);
				}
//			pst.setString(20, fiador.getDataNascimento());
			if (fiador.getDataNascimento() != null) {
				pst.setDate(20, new java.sql.Date(fiador.getDataNascimento().getTime()));
				} else {
					pst.setDate(20, null);
				}
			pst.setString(21, fiador.getEstadoCivil());
			pst.setString(22, fiador.getNomeConjuge());
			pst.setString(23, fiador.getCPFConjuge());
			pst.setString(24, fiador.getRGConjuge());
//			pst.setString(25, fiador.getDataNascimentoConjuge());
			if (fiador.getDataNascimentoConjuge() != null) {
				pst.setDate(25, new java.sql.Date(fiador.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(25, null);
				}
			pst.setString(26, fiador.getProfissaoConjuge());
			pst.setString(27, fiador.getRegimeDeBens());
			
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Fiador cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public static void Atualizar(Fiador fiador, int id){
		try {
			String sql = "UPDATE fiador SET nomeFiador = ?, enderecoFiador = ?, numeroFiador = ?, complementoFiador = ?, bairroFiador = ?, telefoneFixoFiador = ?, telefoneCelularFiador = ?, emailFiador = ?, profissaoFiador = ?, enderecoComercialFiador = ?, numeroComercialFiador = ?, complementoComercialFiador = ?, bairroComercialFiador = ?, empresaFiador = ?, telefoneComercialFiador = ?, RGFiador = ?, CPFFiador = ?, dataExpedicaoFiador = ?, dataNascimentoFiador = ?, estadoCivilFiador = ?, CPFConjugeFiador = ?, RGConjugeFiador = ?, dataNascimentoConjugeFiador = ?, profissaoConjugeFiador = ?, regimeDeBensConjugeFiador = ? where idFiador = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, fiador.getNome());
			pst.setString(2, fiador.getEndereco());
			pst.setInt(3, fiador.getNumero());
			pst.setString(4, fiador.getComplemento());
			pst.setString(5, fiador.getBairro());
			pst.setString(6, fiador.getTelefoneFixo());
			pst.setString(7, fiador.getTelefoneCelular());
			pst.setString(8, fiador.getEmail());
			pst.setString(9, fiador.getProfissao());
			pst.setString(10, fiador.getEnderecoComercial());
			if(fiador.getNumeroComercial()!= null){  
			    pst.setInt(11, fiador.getNumeroComercial());   
			}else{  
			    pst.setNull(11, 0);     
			}      
			//pst.setInt(12, fiador.getNumeroComercial());
			pst.setString(12, fiador.getComplementoComercial());
			pst.setString(13, fiador.getBairroComercial());
			pst.setString(14, fiador.getEmpresa());
			pst.setString(15, fiador.getTelefoneComercial());
			pst.setString(16, fiador.getRG());
			pst.setString(17, fiador.getCPF());
//			pst.setString(18, fiador.getDataExpedicao());~
			if (fiador.getDataExpedicao() != null) {
				pst.setDate(18, new java.sql.Date(fiador.getDataExpedicao().getTime()));
				} else {
					pst.setDate(18, null);
				}
//			pst.setString(19, fiador.getDataNascimento());
			if (fiador.getDataNascimento() != null) {
				pst.setDate(19, new java.sql.Date(fiador.getDataNascimento().getTime()));
				} else {
					pst.setDate(19, null);
				}
			pst.setString(20, fiador.getEstadoCivil());
			pst.setString(21, fiador.getNomeConjuge());
			pst.setString(22, fiador.getCPFConjuge());
			pst.setString(23, fiador.getRGConjuge());
//			pst.setString(24, fiador.getDataNascimentoConjuge());
			if (fiador.getDataNascimentoConjuge() != null) {
				pst.setDate(24, new java.sql.Date(fiador.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(24, null);
				}
			pst.setString(25, fiador.getProfissaoConjuge());
			pst.setString(26, fiador.getRegimeDeBens());
			pst.setInt(27, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Fiador atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Fiador> ListarFiador(){
		ArrayList<Fiador> list = new ArrayList<>();
		try{
			sql = "SELECT * FROM fiador";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()){
				Fiador fiador = new Fiador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getDate(19), rs.getDate(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getDate(25), rs.getString(26), rs.getString(27));
				list.add(fiador);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void Remover(Fiador fiador, int id){
		try {
			String sql = "DELETE FROM fiador where idFiador = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Fiador removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
