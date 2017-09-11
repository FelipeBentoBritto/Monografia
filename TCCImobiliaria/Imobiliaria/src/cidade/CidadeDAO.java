package cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tipoimovel.TipoImovel;
import fabricaconexao.ConexaoSingleton;



public class CidadeDAO {
	
	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Cidade cidade;
	
	public static void Inserir(Cidade cidade) {
		try {
		sql = "INSERT INTO cidade (idCidade, nomeCidade, ufCidade) values (?, ?, ?)";
		conn = ConexaoSingleton.getConnection();
		pst = conn.prepareStatement(sql);
		pst.setInt(1, cidade.getId());
		pst.setString(2, cidade.getNome());
		pst.setString(3, cidade.getUf());
		
		pst.executeUpdate();
		pst.close();
		JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void Atualizar(Cidade cidade, int id){
		try {
			String sql = "UPDATE cidade SET nomeCidade = ?, ufCidade = ? where idCidade = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, cidade.getNome());
			pst.setString(2, cidade.getUf());
			pst.setInt(3, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Cidade atualizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Cidade> ListarCidade(){
		ArrayList<Cidade> list = new ArrayList<>();
		try{
			sql = "SELECT * FROM cidade";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()){
				Cidade cidade = new Cidade(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(cidade);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void Remover(Cidade cidade, int id){
		try {
			String sql = "DELETE FROM cidade where idCidade = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Cidade removida com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
