package fabricaconexao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;



public class ConexaoSingleton {
	
	public Statement stm;
	public ResultSet rs;
	
	public static void main(String[] args) {
		getConnection();
	}
	
	private static Connection conn = null;

	public ConexaoSingleton() {
	}

	public static Connection getConnection() {
		if (conn == null) {
			try {
				String userName = "root";
				String password = "";
				String url = "jdbc:mysql://localhost/dbimobiliaria";
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println("Conexão com o BD estabelecida!");
			} catch (Exception e) {
				e.printStackTrace();
				System.err
						.println("Não foi possível estabelecer conexão com o BD!");
			}
		}
		return conn;
	}
	
	public void executaSQL (String sql) {
		try {
			stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			
		}
	}

	@Override
	protected void finalize() throws Throwable {
		conn.close();
		super.finalize();
	}
}
