package imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tipoimovel.TipoImovel;
import fabricaconexao.ConexaoSingleton;
import fiador.Fiador;

public class ImovelDAO {
	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static ImovelConsulta imovelConsulta;
	private static ImovelProcConsulta imovelProcConsulta;

	public static void Inserir(Imovel imovel) {
		try {
			sql = "INSERT INTO imovel (idImovel, Proprietario_idProprietario, TipoImovel_idTipoImovel, enderecoImovel, numeroImovel, complementoImovel, bairroImovel, cepImovel, descricaoImovel, "
					+ "txAdmImovel, valorImovel, areaTerrenoImovel, areaConstrucaoImovel, observacaoImovel, estruturaImovel, proximidadesImovel, dataEntradaImovel, estadoImovel, ativoImovel) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, imovel.getId());
			pst.setInt(2, imovel.getidProprietario());
			pst.setInt(3, imovel.getIdTipoImovel());
			pst.setString(4, imovel.getEndereco());
			pst.setInt(5, imovel.getNumero());
			pst.setString(6, imovel.getComplemento());
			pst.setString(7, imovel.getBairro());
			pst.setString(8, imovel.getCep());
			pst.setString(9, imovel.getDescricao());
			pst.setDouble(10, imovel.getTaxaAdm());
			pst.setDouble(11, imovel.getValorImovel());
			if (imovel.getAreaTe() != null) {
				pst.setDouble(12, imovel.getAreaTe());
			} else {
				pst.setNull(12, 0);
			}
			// pst.setDouble(12, imovel.getAreaTe());
			if (imovel.getAreaCons() != null) {
				pst.setDouble(13, imovel.getAreaCons());
			} else {
				pst.setNull(13, 0);
			}
			// pst.setDouble(13, imovel.getAreaCons());
			pst.setString(14, imovel.getObservacoes());
			pst.setString(15, imovel.getEstrutura());
			pst.setString(16, imovel.getProximidades());
			if (imovel.getDataEntrada() != null) {
				pst.setDate(17, new java.sql.Date(imovel.getDataEntrada().getTime()));
				} else {
					pst.setDate(17, null);
				}
//			pst.setString(17, imovel.getDataEntrada());
			pst.setString(18, imovel.getEstado());
			pst.setString(19, "Inativo");

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Imóvel cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ImovelConsulta> ListarImovel() {
		ArrayList<ImovelConsulta> list = new ArrayList<>();
		try {
			/*
			 * sql =
			 * "SELECT I.idImovel, T.descricaoTipoImovel, P.nomeProprietario, I.enderecoImovel, I.cepImovel, I.numeroImovel, I.bairroImovel,"
			 * +
			 * " I.complementoImovel, I.descricaoImovel, I.txAdmImovel, I.valorImovel, I.areaTerrenoImovel, I.areaConstrucaoImovel, "
			 * +
			 * "I.observacaoImovel, I.estruturaImovel, I.proximidadesImovel, I.dataEntradaImovel, I.estadoImovel FROM imovel I"
			 * +
			 * "LEFT JOIN TIPOIMOVEL T ON I.TipoImovel_idTipoImovel = T.idTipoImovel"
			 * +
			 * "LEFT JOIN PROPRIETARIO P ON I.Proprietario_idProprietario = P.idProprietario"
			 */;
			sql = "SELECT I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, I.enderecoImovel, I.numeroImovel, I.complementoImovel, I.bairroImovel, I.cepImovel, I.descricaoImovel, I.txAdmImovel, I.valorImovel, I.areaTerrenoImovel, I.areaConstrucaoImovel, I.observacaoImovel, I.estruturaImovel, I.proximidadesImovel, I.dataEntradaImovel, I.estadoImovel FROM imovel I JOIN TIPOIMOVEL T ON I.TipoImovel_idTipoImovel = T.idTipoImovel JOIN PROPRIETARIO P ON I.Proprietario_idProprietario = P.idProprietario";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				imovelConsulta = new ImovelConsulta(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getDouble(12), rs.getDouble(13), rs.getDouble(14),
						rs.getDouble(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getDate(19), rs.getString(20));
				list.add(imovelConsulta);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void Atualizar(Imovel imovel, int id) {
		try {
			String sql = "UPDATE imovel SET TipoImovel_idTipoImovel = ?, Proprietario_idProprietario = ?, enderecoImovel = ?, numeroImovel = ?, complementoImovel = ?, bairroImovel = ?, cepImovel = ?, descricaoImovel = ?, txAdmImovel = ?, valorImovel = ?, areaTerrenoImovel = ?, areaConstrucaoImovel = ?, observacaoImovel = ?, estruturaImovel = ?, proximidadesImovel = ?, dataEntradaImovel = ?, estadoImovel = ? where idImovel = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, imovel.getIdTipoImovel());
			pst.setInt(2, imovel.getidProprietario());
			pst.setString(3, imovel.getEndereco());
			pst.setInt(4, imovel.getNumero());
			pst.setString(5, imovel.getComplemento());
			pst.setString(6, imovel.getBairro());
			pst.setString(7, imovel.getCep());
			pst.setString(8, imovel.getDescricao());
			pst.setDouble(9, imovel.getTaxaAdm());
			pst.setDouble(10, imovel.getValorImovel());
			if (imovel.getAreaTe() != null) {
				pst.setDouble(11, imovel.getAreaTe());
			} else {
				pst.setNull(11, 0);
			}
			// pst.setDouble(12, imovel.getAreaTe());
			if (imovel.getAreaCons() != null) {
				pst.setDouble(12, imovel.getAreaCons());
			} else {
				pst.setNull(12, 0);
			}
			// pst.setDouble(12, imovel.getAreaCons());
			pst.setString(13, imovel.getObservacoes());
			pst.setString(14, imovel.getEstrutura());
			pst.setString(15, imovel.getProximidades());
//			pst.setString(16, imovel.getDataEntrada());
			if (imovel.getDataEntrada() != null) {
				pst.setDate(16, new java.sql.Date(imovel.getDataEntrada().getTime()));
				} else {
					pst.setDate(16, null);
				}
			pst.setString(17, imovel.getEstado());
			pst.setInt(18, id);

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Imóvel atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Remover(Imovel imovel, int id) {
		try {
			String sql = "DELETE FROM imovel where idImovel = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Imóvel removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ImovelProcConsulta> ListarImovelProc() {
		ArrayList<ImovelProcConsulta> list = new ArrayList<>();
		try {
			sql = "SELECT I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, "
					+ "P.razaoSocialProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.enderecoProprietario, P.numeroProprietario, "
					+ "P.complementoProprietario, P.bairroProprietario, P.CPFProprietario, P.CNPJProprietario, P.tipoPessoaProprietario, "
					+ "P.estadoCivilProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, I.enderecoImovel, I.numeroImovel, "
					+ "I.complementoImovel, I.bairroImovel, I.ativoImovel FROM imovel I JOIN tipoimovel T ON I.TipoImovel_idTipoImovel = T.idTipoImovel "
					+ "JOIN proprietario P ON I.Proprietario_idProprietario = P.idProprietario JOIN cidade C ON P.Cidade_idCidade = C.idCidade where I.ativoImovel <> 'Ativo' order by I.idImovel";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				imovelProcConsulta = new ImovelProcConsulta(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), 
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
						rs.getString(20), rs.getInt(21), rs.getString(22), rs.getString(23), rs.getString(24));
				list.add(imovelProcConsulta);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void AtualizarImovel(Imovel imovel, int id, String ativo) {
		try {
			String sql = "UPDATE imovel SET ativoImovel = ? where idImovel = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, ativo);
			pst.setInt(2, id);
			pst.executeUpdate();
			pst.close();
			
			System.out.println("Ativo, Inativo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
