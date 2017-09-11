package procuracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import fabricaconexao.ConexaoSingleton;

public class ProcuracaoDAO {

	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Procuracao procuracao;
	private static ProcuracaoConsulta procuracaoConsulta;
	
	public static void Inserir(Procuracao procuracao) {
		try {
			sql = "INSERT INTO procuracao (idProcuracao, Imovel_idImovel, idProprietario, clausulasProcuracao, situacaoProcuracao, dataAssinaturaProcuracao) values (?, ?, ?, ?, ?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, procuracao.getId());
			pst.setInt(2, procuracao.getIdImovel());
			pst.setInt(3, procuracao.getIdProprietario());
			pst.setString(4, procuracao.getClausulas());
			pst.setString(5, procuracao.getSituacao());
			if (procuracao.getDataAssinaturaProcuracao() != null) {
			pst.setDate(6, new java.sql.Date(procuracao.getDataAssinaturaProcuracao().getTime()));
			} else {
				pst.setDate(6, null);
			}
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Procuração cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ProcuracaoConsulta> ListarProcuracao() {
		ArrayList<ProcuracaoConsulta> list = new ArrayList<>();
		try {
			sql = "SELECT R.idProcuracao, I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, "
					+ "P.razaoSocialProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.enderecoProprietario, P.numeroProprietario, "
					+ "P.complementoProprietario, P.bairroProprietario, P.CPFProprietario, P.CNPJProprietario, P.tipoPessoaProprietario, "
					+ "P.estadoCivilProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, I.enderecoImovel, I.numeroImovel, "
					+ "I.complementoImovel, I.bairroImovel, R.situacaoProcuracao, R.dataAssinaturaProcuracao, R.clausulasProcuracao FROM procuracao R JOIN imovel I ON R.Imovel_idImovel = I.idImovel "
					+ "JOIN tipoimovel T ON I.TipoImovel_idTipoImovel = T.idTipoImovel "
					+ "JOIN proprietario P ON I.Proprietario_idProprietario = P.idProprietario JOIN cidade C ON P.Cidade_idCidade = C.idCidade";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				procuracaoConsulta = new ProcuracaoConsulta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), 
						rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getDate(26), rs.getString(27));
				list.add(procuracaoConsulta);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void Atualizar(Procuracao procuracao, int id){
		try {
			String sql = "UPDATE procuracao set Imovel_idImovel = ?, idProprietario = ?, clausulasProcuracao = ?, situacaoProcuracao = ?, dataAssinaturaProcuracao = ? where idProcuracao = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, procuracao.getIdImovel());
			pst.setInt(2, procuracao.getIdProprietario());
			pst.setString(3, procuracao.getClausulas());
			pst.setString(4, procuracao.getSituacao());
			if (procuracao.getDataAssinaturaProcuracao() != null) {
			pst.setDate(5, new java.sql.Date(procuracao.getDataAssinaturaProcuracao().getTime()));
			} else {
				pst.setDate(5, null);
			}
			pst.setInt(6, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Procuração atualizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void GerarContratoFisicaCompleto() throws ParseException {
		
		try {
			
			String sql = "SELECT R.idProcuracao, I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, P.razaoSocialProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.enderecoProprietario, P.numeroProprietario, P.complementoProprietario, P.bairroProprietario, P.CPFProprietario, P.RGProprietario, P.profissaoProprietario, P.CNPJProprietario, P.tipoPessoaProprietario, P.estadoCivilProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, P.RGConjugeProprietario, P.profissaoConjugeProprietario, I.enderecoImovel, I.numeroImovel, I.complementoImovel, I.bairroImovel, R.situacaoProcuracao, R.clausulasProcuracao, R.dataAssinaturaProcuracao FROM procuracao R JOIN imovel I ON R.Imovel_idImovel = I.idImovel JOIN tipoimovel T ON I.TipoImovel_idTipoImovel = T.idTipoImovel	JOIN proprietario P ON I.Proprietario_idProprietario = P.idProprietario JOIN cidade C ON P.Cidade_idCidade = C.idCidade where R.idProcuracao = ? AND R.dataAssinaturaProcuracao = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			Integer aux = Integer.parseInt(MovProcuracao.tfId.getText());
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			
			String result = in.format(out.parse(MovProcuracao.tfDataAssinatura.getText()));
					
			pst.setInt(1, aux);
			pst.setString(2, result);
			
			rs = pst.executeQuery();
			JasperReport jasperReport = JasperCompileManager.compileReport("C:/TCCImobiliaria/Imobiliaria/src/MyReports/ProcuracaoPessoaFisica.jrxml");
			JRResultSetDataSource contratoResul = new JRResultSetDataSource(rs);
			JasperPrint jpPrint = JasperFillManager.fillReport(jasperReport, null, contratoResul);
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void GerarContratoFisicaSolteiro() throws ParseException {
		
		try {
			
			String sql = "SELECT R.idProcuracao, I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, P.razaoSocialProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.enderecoProprietario, P.numeroProprietario, P.complementoProprietario, P.bairroProprietario, P.CPFProprietario, P.RGProprietario, P.profissaoProprietario, P.CNPJProprietario, P.tipoPessoaProprietario, P.estadoCivilProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, P.RGConjugeProprietario, P.profissaoConjugeProprietario, I.enderecoImovel, I.numeroImovel, I.complementoImovel, I.bairroImovel, R.situacaoProcuracao, R.clausulasProcuracao, R.dataAssinaturaProcuracao FROM procuracao R JOIN imovel I ON R.Imovel_idImovel = I.idImovel JOIN tipoimovel T ON I.TipoImovel_idTipoImovel = T.idTipoImovel	JOIN proprietario P ON I.Proprietario_idProprietario = P.idProprietario JOIN cidade C ON P.Cidade_idCidade = C.idCidade where R.idProcuracao = ? AND R.dataAssinaturaProcuracao = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			Integer aux = Integer.parseInt(MovProcuracao.tfId.getText());
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			
			String result = in.format(out.parse(MovProcuracao.tfDataAssinatura.getText()));
					
			pst.setInt(1, aux);
			pst.setString(2, result);
			
			rs = pst.executeQuery();
			JasperReport jasperReport = JasperCompileManager.compileReport("C:/TCCImobiliaria/Imobiliaria/src/MyReports/ProcuracaoPessoaFisicaSolteira.jrxml");
			JRResultSetDataSource contratoResul = new JRResultSetDataSource(rs);
			JasperPrint jpPrint = JasperFillManager.fillReport(jasperReport, null, contratoResul);
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void GerarContratoJuridica() throws ParseException {
		try {
			String sql = "SELECT R.idProcuracao, I.idImovel, I.TipoImovel_idTipoImovel, T.descricaoTipoImovel, I.Proprietario_idProprietario, P.nomeProprietario, P.razaoSocialProprietario, P.Cidade_idCidade, C.nomeCidade, C.ufCidade, P.enderecoProprietario, P.numeroProprietario, P.complementoProprietario, P.bairroProprietario, P.CPFProprietario, P.RGProprietario, P.profissaoProprietario, P.CNPJProprietario, P.tipoPessoaProprietario, P.estadoCivilProprietario, P.nomeConjugeProprietario, P.CPFConjugeProprietario, P.RGConjugeProprietario, P.profissaoConjugeProprietario, I.enderecoImovel, I.numeroImovel, I.complementoImovel, I.bairroImovel, R.situacaoProcuracao, R.clausulasProcuracao, R.dataAssinaturaProcuracao FROM procuracao R JOIN imovel I ON R.Imovel_idImovel = I.idImovel JOIN tipoimovel T ON I.TipoImovel_idTipoImovel = T.idTipoImovel	JOIN proprietario P ON I.Proprietario_idProprietario = P.idProprietario JOIN cidade C ON P.Cidade_idCidade = C.idCidade where R.idProcuracao = ? AND R.dataAssinaturaProcuracao = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			Integer aux = Integer.parseInt(MovProcuracao.tfId.getText());
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			
			String result = in.format(out.parse(MovProcuracao.tfDataAssinatura.getText()));
					
			pst.setInt(1, aux);
			pst.setString(2, result);
			
			rs = pst.executeQuery();
			JasperReport jasperReport = JasperCompileManager.compileReport("C:/TCCImobiliaria/Imobiliaria/src/MyReports/ProcuracaoPessoaJuridica.jrxml");
			JRResultSetDataSource contratoResul = new JRResultSetDataSource(rs);
			JasperPrint jpPrint = JasperFillManager.fillReport(jasperReport, null, contratoResul);
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
