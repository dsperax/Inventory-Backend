package br.com.lojacar8.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.lojacar8.Produto;
import br.com.lojacar8.factory.ConnectionFactory;

public class ProdutoDao {
	
	public void cadastro(Produto produto){
		String sql = "INSERT INTO TB_PRODUTO(NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_PRODUTO, ID_CATEGORIA) VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			pstm.setString(1, produto.getNome());//valores para query
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.setInt(4, produto.getCategoria());
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
