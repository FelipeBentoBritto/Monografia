package proprietario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fabricaconexao.ConexaoSingleton;
import fiador.Fiador;
import locatario.Locatario;

public class ProprietarioDAO {

	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Proprietario proprietario;
	private static ProprietarioCidade proprietarioCidade;

	public static void Inserir(Proprietario proprietario) {
		try {
			sql = "INSERT INTO proprietario (idProprietario, Cidade_idCidade, nomeProprietario, enderecoProprietario, numeroProprietario, complementoProprietario, bairroProprietario, telefoneFixoProprietario, telefoneCelularProprietario, emailProprietario, profissaoProprietario, enderecoComercialProprietario, numeroComercialProprietario, complementoComercialProprietario, bairroComercialProprietario, empresaProprietario, telefoneComercialProprietario, CNPJProprietario, razaoSocialProprietario, RGProprietario, CPFProprietario, dataExpedicaoProprietario, bancoProprietario, contaBancariaProprietario, agenciaBancariaProprietario, dataNascimentoProprietario, estadoCivilProprietario, chequeFavorecidoProprietario, chequeCPFFavorecido, tipoPessoaProprietario, tipoContaProprietario, nomeConjugeProprietario, CPFConjugeProprietario, RGConjugeProprietario, dataNascimentoConjugeProprietario, profissaoConjugeProprietario, regimeDeBensConjugeProprietario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, proprietario.getId());
			pst.setInt(2, proprietario.getIdCidade());
			pst.setString(3, proprietario.getNome());
			pst.setString(4, proprietario.getEndereco());
			pst.setInt(5, proprietario.getNumero());
			pst.setString(6, proprietario.getComplemento());
			pst.setString(7, proprietario.getBairro());
			pst.setString(8, proprietario.getTelefoneFixo());
			pst.setString(9, proprietario.getTelefoneCelular());
			pst.setString(10, proprietario.getEmail());
			pst.setString(11, proprietario.getProfissao());
			pst.setString(12, proprietario.getEnderecoComercial());
			if (proprietario.getNumeroComercial() != null) {
				pst.setInt(13, proprietario.getNumeroComercial());
			} else {
				pst.setNull(13, 0);
			}
			// pst.setInt(13, fiador.getNumeroComercial());
			pst.setString(14, proprietario.getComplementoComercial());
			pst.setString(15, proprietario.getBairroComercial());
			pst.setString(16, proprietario.getEmpresa());
			pst.setString(17, proprietario.getTelefoneComercial());
			pst.setString(18, proprietario.getCNPJ());
			pst.setString(19, proprietario.getRazaoSocial());
			pst.setString(20, proprietario.getRG());
			pst.setString(21, proprietario.getCPF());
			if (proprietario.getDataExpedicao() != null) {
				pst.setDate(22, new java.sql.Date(proprietario.getDataExpedicao().getTime()));
				} else {
					pst.setDate(22, null);
				}
//			pst.setDate(22, proprietario.getDataExpedicao());
			pst.setString(23, proprietario.getBanco());
			pst.setString(24, proprietario.getContaBancaria());
			pst.setString(25, proprietario.getAgenciaBancaria());
			if (proprietario.getDataNascimento() != null) {
				pst.setDate(26, new java.sql.Date(proprietario.getDataNascimento().getTime()));
				} else {
					pst.setDate(26, null);
				}
//			pst.setDate(26, proprietario.getDataNascimento());
			pst.setString(27, proprietario.getEstadoCivil());
			pst.setString(28, proprietario.getChequeFavorecido());
			pst.setString(29, proprietario.getChequeCPF());
			pst.setString(30, proprietario.getTipoPessoa());
			pst.setString(31, proprietario.getTipoConta());
			pst.setString(32, proprietario.getNomeConjuge());
			pst.setString(33, proprietario.getCPFConjuge());
			pst.setString(34, proprietario.getRGConjuge());
			if (proprietario.getDataNascimentoConjuge() != null) {
				pst.setDate(35, new java.sql.Date(proprietario.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(35, null);
				}
//			pst.setDate(35, proprietario.getDataNascimentoConjuge());
			pst.setString(36, proprietario.getProfissaoConjuge());
			pst.setString(37, proprietario.getRegimeDeBens());

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Proprietário cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ProprietarioCidade> ListarProprietario() {
		ArrayList<ProprietarioCidade> list = new ArrayList<>();
		try {
			sql = "SELECT P.idProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.nomeProprietario, P.enderecoProprietario, P.numeroProprietario, P.complementoProprietario, P.bairroProprietario, "
					+ "P.telefoneFixoProprietario,P.telefoneCelularProprietario, P.emailProprietario, P.profissaoProprietario, P.enderecoComercialProprietario, P.numeroComercialProprietario, "
					+ "P.complementoComercialProprietario, P.bairroComercialProprietario, P.empresaProprietario, P.telefoneComercialProprietario, P.CNPJProprietario, P.razaoSocialProprietario, "
					+ "P.RGProprietario, P.CPFProprietario, P.dataExpedicaoProprietario, P.bancoProprietario, P.contaBancariaProprietario, P.agenciaBancariaProprietario, P.dataNascimentoProprietario, "
					+ "P.estadoCivilProprietario, P.chequeFavorecidoProprietario, P.chequeCPFFavorecido, P.tipoPessoaProprietario, P.tipoContaProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, "
					+ "P.RGConjugeProprietario, P.dataNascimentoConjugeProprietario, P.profissaoConjugeProprietario,P.regimeDeBensConjugeProprietario FROM proprietario P "
					+ "LEFT JOIN cidade C ON P.Cidade_idCidade = C.idCidade where P.Cidade_idCidade = C.idCidade order by P.idProprietario";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				ProprietarioCidade proprietarioCidade = new ProprietarioCidade(
						rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getInt(15),
						rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21),
						rs.getString(22), rs.getString(23), rs.getDate(24),
						rs.getString(25), rs.getString(26), rs.getString(27),
						rs.getDate(28), rs.getString(29), rs.getString(30),
						rs.getString(31), rs.getString(32), rs.getString(33),
						rs.getString(34), rs.getString(35), rs.getString(36),
						rs.getDate(37), rs.getString(38), rs.getString(39));
				list.add(proprietarioCidade);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void Atualizar(Proprietario proprietario, int id) {
		try {
			sql = "UPDATE proprietario SET Cidade_idCidade = ?, nomeProprietario = ?, enderecoProprietario = ?, numeroProprietario = ?, complementoProprietario = ?, bairroProprietario = ?, telefoneFixoProprietario = ?, telefoneCelularProprietario = ?, emailProprietario = ?, profissaoProprietario = ?, enderecoComercialProprietario = ?, numeroComercialProprietario = ?, complementoComercialProprietario = ?, bairroComercialProprietario = ?, empresaProprietario = ?, telefoneComercialProprietario = ?, CNPJProprietario = ?, razaoSocialProprietario = ?, RGProprietario = ?, CPFProprietario = ?, dataExpedicaoProprietario = ?, bancoProprietario = ?, contaBancariaProprietario = ?, agenciaBancariaProprietario = ?, dataNascimentoProprietario = ?, estadoCivilProprietario = ?, chequeFavorecidoProprietario = ?, chequeCPFFavorecido = ?, tipoPessoaProprietario = ?, tipoContaProprietario = ?, nomeConjugeProprietario = ?, CPFConjugeProprietario = ?, RGConjugeProprietario = ?, dataNascimentoConjugeProprietario = ?, profissaoConjugeProprietario = ?, regimeDeBensConjugeProprietario = ? where idProprietario = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, proprietario.getIdCidade());
			pst.setString(2, proprietario.getNome());
			pst.setString(3, proprietario.getEndereco());
			pst.setInt(4, proprietario.getNumero());
			pst.setString(5, proprietario.getComplemento());
			pst.setString(6, proprietario.getBairro());
			pst.setString(7, proprietario.getTelefoneFixo());
			pst.setString(8, proprietario.getTelefoneCelular());
			pst.setString(9, proprietario.getEmail());
			pst.setString(10, proprietario.getProfissao());
			pst.setString(11, proprietario.getEnderecoComercial());
			if (proprietario.getNumeroComercial() != null) {
				pst.setInt(12, proprietario.getNumeroComercial());
			} else {
				pst.setNull(12, 0);
			}
			// pst.setInt(13, fiador.getNumeroComercial());
			pst.setString(13, proprietario.getComplementoComercial());
			pst.setString(14, proprietario.getBairroComercial());
			pst.setString(15, proprietario.getEmpresa());
			pst.setString(16, proprietario.getTelefoneComercial());
			pst.setString(17, proprietario.getCNPJ());
			pst.setString(18, proprietario.getRazaoSocial());
			pst.setString(19, proprietario.getRG());
			pst.setString(20, proprietario.getCPF());
//			pst.setString(21, proprietario.getDataExpedicao());
			if (proprietario.getDataExpedicao() != null) {
				pst.setDate(21, new java.sql.Date(proprietario.getDataExpedicao().getTime()));
				} else {
					pst.setDate(21, null);
				}
			pst.setString(22, proprietario.getBanco());
			pst.setString(23, proprietario.getContaBancaria());
			pst.setString(24, proprietario.getAgenciaBancaria());
//			pst.setString(25, proprietario.getDataNascimento());
			if (proprietario.getDataExpedicao() != null) {
				pst.setDate(25, new java.sql.Date(proprietario.getDataNascimento().getTime()));
				} else {
					pst.setDate(25, null);
				}
			pst.setString(26, proprietario.getEstadoCivil());
			pst.setString(27, proprietario.getChequeFavorecido());
			pst.setString(28, proprietario.getChequeCPF());
			pst.setString(29, proprietario.getTipoPessoa());
			pst.setString(30, proprietario.getTipoConta());
			pst.setString(31, proprietario.getNomeConjuge());
			pst.setString(32, proprietario.getCPFConjuge());
			pst.setString(33, proprietario.getRGConjuge());
//			pst.setString(34, proprietario.getDataNascimentoConjuge());
			if (proprietario.getDataExpedicao() != null) {
				pst.setDate(34, new java.sql.Date(proprietario.getDataNascimentoConjuge().getTime()));
				} else {
					pst.setDate(34, null);
				}
			pst.setString(35, proprietario.getProfissaoConjuge());
			pst.setString(36, proprietario.getRegimeDeBens());
			pst.setInt(37, id);

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Proprietário atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Remover(Proprietario proprietario, int id){
		try {
			String sql = "DELETE FROM proprietario where idProprietario = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Proprietário removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
