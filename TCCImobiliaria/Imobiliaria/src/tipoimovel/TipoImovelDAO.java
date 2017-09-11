package tipoimovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fabricaconexao.ConexaoSingleton;


public class TipoImovelDAO {
	
	private static Connection conn;
	private static String sql;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static TipoImovel tipoimovel;

	public static void Inserir(TipoImovel tipoimovel){
		try {
			sql = "INSERT INTO tipoimovel (idTipoImovel, descricaoTipoImovel) values (?, ?)";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tipoimovel.getId());
			pst.setString(2, tipoimovel.getDescricao());
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Tipo de Imóvel cadastrado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Atualizar(TipoImovel tipoimovel, int id){
		try {
			String sql = "UPDATE tipoimovel SET descricaoTipoImovel = ? where idTipoImovel = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, tipoimovel.getDescricao());
			pst.setInt(2, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Tipo do Imóvel atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<TipoImovel> ListarPessoa(){
		ArrayList<TipoImovel> list = new ArrayList<>();
		try{
			sql = "SELECT * FROM tipoimovel";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()){
				TipoImovel tipoimovel = new TipoImovel(rs.getInt(1), rs.getString(2));
				list.add(tipoimovel);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public static void Remover(TipoImovel tipoimovel, int id){
		try {
			String sql = "DELETE FROM tipoimovel where idTipoImovel = ?";
			conn = ConexaoSingleton.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Tipo do Imóvel removido com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
