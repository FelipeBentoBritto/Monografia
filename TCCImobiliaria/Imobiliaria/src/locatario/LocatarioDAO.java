package locatario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fabricaconexao.ConexaoSingleton;
import fiador.Fiador;





public class LocatarioDAO {
	
	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Locatario locatario;
	
	public static void Inserir(Locatario locatario){
		try {
			sql = "INSERT INTO locatario (idLocatario, nomeLocatario, enderecoLocatario, numeroLocatario, complementoLocatario, bairroLocatario, telefoneFixoLocatario, telefoneCelularLocatario, emailLocatario, profissaoLocatario, enderecoComercialLocatario, numeroComercialLocatario, complementoComercialLocatario, bairroComercialLocatario, empresaLocatario, telefoneComercialLocatario, CNPJLocatario, razaoSocialLocatario, RGLocatario, CPFLocatario, dataExpedicaoLocatario, rendaLocatario, dataNascimentoLocatario, estadoCivilLocatario, tipoPessoaLocatario, nomeConjugeLocatario, CPFConjugeLocatario, RGConjugeLocatario, dataNascimentoConjugeLocatario, profissaoConjugeLocatario, regimeDeBensConjugeLocatario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, locatario.getId());
			pst.setString(2, locatario.getNome());
			pst.setString(3, locatario.getEndereco());
			pst.setInt(4, locatario.getNumero());
			pst.setString(5, locatario.getComplemento());
			pst.setString(6, locatario.getBairro());
			pst.setString(7, locatario.getTelefoneFixo());
			pst.setString(8, locatario.getTelefoneCelular());
			pst.setString(9, locatario.getEmail());
			pst.setString(10, locatario.getProfissao());
			pst.setString(11, locatario.getEnderecoComercial());
//			pst.setInt(12, locatario.getNumeroComercial());
			if (locatario.getNumeroComercial() != null) {
				pst.setInt(12, locatario.getNumeroComercial());
			} else {
				pst.setNull(12, 0);
			}
			pst.setString(13, locatario.getComplementoComercial());
			pst.setString(14, locatario.getBairroComercial());
			pst.setString(15, locatario.getEmpresa());
			pst.setString(16, locatario.getTelefoneComercial());
			pst.setString(17, locatario.getCNPJ());
			pst.setString(18, locatario.getRazaoSocial());
			pst.setString(19, locatario.getRG());
			pst.setString(20, locatario.getCPF());
			if (locatario.getDataExpedicao() != null) {
				pst.setDate(21, new java.sql.Date(locatario.getDataExpedicao().getTime()));
				} else {
					pst.setDate(21, null);
				}
//			pst.setString(21, locatario.getDataExpedicao());
			pst.setInt(22, locatario.getRenda());
			if (locatario.getDataNascimento() != null) {
				pst.setDate(23, new java.sql.Date(locatario.getDataNascimento().getTime()));
				} else {
					pst.setDate(23, null);
				}
//			pst.setString(23, locatario.getDataNascimento());
			pst.setString(24, locatario.getEstadoCivil());
			pst.setString(25, locatario.getTipoPessoa());
			pst.setString(26, locatario.getNomeConjuge());
			pst.setString(27, locatario.getCPFConjuge());
			pst.setString(28, locatario.getRGConjuge());
			if (locatario.getDataNascimentoConjuge() != null) {
				pst.setDate(29, new java.sql.Date(locatario.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(29, null);
				}
//			pst.setString(29, locatario.getDataNascimentoConjuge());
			pst.setString(30, locatario.getProfissaoConjuge());
			pst.setString(31, locatario.getRegimeDeBens());
			
			
			
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Locatário cadastrado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Atualizar(Locatario locatario, int id){
		try {
			String sql = "UPDATE locatario SET  nomeLocatario = ?, enderecoLocatario = ?, numeroLocatario = ?, complementoLocatario = ?, bairroLocatario = ?, telefoneFixoLocatario = ?, telefoneCelularLocatario = ?, emailLocatario = ?, profissaoLocatario = ?, enderecoComercialLocatario = ?, numeroComercialLocatario = ?, complementoComercialLocatario = ?, bairroComercialLocatario = ?, empresaLocatario = ?, telefoneComercialLocatario = ?, CNPJLocatario = ?, razaoSocialLocatario = ?, RGLocatario = ?, CPFLocatario = ?, dataExpedicaoLocatario = ?, rendaLocatario = ?, dataNascimentoLocatario = ?, estadoCivilLocatario = ?, tipoPessoaLocatario = ?, nomeConjugeLocatario = ?, CPFConjugeLocatario = ?, RGConjugeLocatario = ?, dataNascimentoConjugeLocatario = ?, profissaoConjugeLocatario = ?, regimeDeBensConjugeLocatario = ? where idLocatario = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, locatario.getNome());
			pst.setString(2, locatario.getEndereco());
			pst.setInt(3, locatario.getNumero());
			pst.setString(4, locatario.getComplemento());
			pst.setString(5, locatario.getBairro());
			pst.setString(6, locatario.getTelefoneFixo());
			pst.setString(7, locatario.getTelefoneCelular());
			pst.setString(8, locatario.getEmail());
			pst.setString(9, locatario.getProfissao());
			pst.setString(10, locatario.getEnderecoComercial());
//			pst.setString(11, locatario.getNumeroComercial());
			if (locatario.getNumeroComercial() != null) {
				pst.setInt(11, locatario.getNumeroComercial());
			} else {
				pst.setNull(11, 0);
			}
			pst.setString(12, locatario.getComplementoComercial());
			pst.setString(13, locatario.getBairroComercial());
			pst.setString(14, locatario.getEmpresa());
			pst.setString(15, locatario.getTelefoneComercial());
			pst.setString(16, locatario.getCNPJ());
			pst.setString(17, locatario.getRazaoSocial());
			pst.setString(18, locatario.getRG());
			pst.setString(19, locatario.getCPF());
//			pst.setString(20, locatario.getDataExpedicao());
			if (locatario.getDataExpedicao() != null) {
				pst.setDate(20, new java.sql.Date(locatario.getDataExpedicao().getTime()));
				} else {
					pst.setDate(20, null);
				}
			pst.setInt(21, locatario.getRenda());
			if (locatario.getDataNascimento() != null) {
				pst.setDate(22, new java.sql.Date(locatario.getDataNascimento().getTime()));
				} else {
					pst.setDate(22, null);
				}
//			pst.setString(22, locatario.getDataNascimento());
			pst.setString(23, locatario.getEstadoCivil());
			pst.setString(24, locatario.getTipoPessoa());
			pst.setString(25, locatario.getNomeConjuge());
			pst.setString(26, locatario.getCPFConjuge());
			pst.setString(27, locatario.getRGConjuge());
			if (locatario.getDataNascimentoConjuge() != null) {
				pst.setDate(28, new java.sql.Date(locatario.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(28, null);
				}
//			pst.setString(28, locatario.getDataNascimentoConjuge());
			pst.setString(29, locatario.getProfissaoConjuge());
			pst.setString(30, locatario.getRegimeDeBens());
			pst.setInt(31, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Locatário atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Locatario> ListarLocatario(){
		ArrayList<Locatario> list = new ArrayList<>();
		try{
			sql = "SELECT * FROM locatario";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()){
				Locatario locatario = new Locatario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getDate(21), rs.getInt(22), rs.getDate(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getDate(29), rs.getString(30), rs.getString(31));
				list.add(locatario);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void Remover(Locatario locatario, int id){
		try {
			String sql = "DELETE FROM locatario where idLocatario = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Locatário removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	
