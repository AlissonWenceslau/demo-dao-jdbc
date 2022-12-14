package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	//2#Objeto para conectar ao banco do jdbc
	private static Connection conn = null;
	
	//3#Método que conecta com banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//4#Método para fechar a conexão com banco de dados
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	//1#Método que carrega as propriedades do arquivo 'db.properties'
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			
			return props;
		}catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	//5# fecha statment (evita fazer try-catch trocentas vezes no programa principal)
	public static void closeStatment(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//6# fecha o ResultSet
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
