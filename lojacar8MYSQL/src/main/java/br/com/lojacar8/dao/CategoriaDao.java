package br.com.lojacar8.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.lojacar8.Categoria;
import br.com.lojacar8.factory.ConnectionFactory;

public class CategoriaDao {

	public void cadastro(Categoria categoria){
		String sql = "INSERT INTO TB_CATEGORIA(NOME_CATEGORIA) VALUES(?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			pstm.setString(1, categoria.getNome());//valores para query
			pstm.execute(); //executa query
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //fechar conexão
			try {
				if(pstm!=null){
					pstm.close();
				}
				
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
