package main.java.br.com.lojacar8.factory;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lojacar8";
	
	public static Connection createConnectionToMySQL() throws Exception {
//		try{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//			System.out.println("Driver não encontrado ! "+e);
//		}
		
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null){
			System.out.println("Conectado!");
			con.close();
		}
	}
}
