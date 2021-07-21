package br.com.lojacar8.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Categoria> getCategorias(){
		String sql = "SELECT * FROM TB_CATEGORIA";
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null; //SELECT
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			rset = pstm.executeQuery(); //executa query
			
			while (rset.next()){
				Categoria categoria = new Categoria(rset.getString("NOME_CATEGORIA"));
				
				categoria.setID_CATEGORIA(rset.getInt("ID_CATEGORIA"));//recupera id
				//categoria.setNome(rset.getString("NOME_CATEGORIA"));//recupera nome
				
				categorias.add(categoria);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null){
					pstm.close();
				}
				
				if (conn!=null){
					conn.close();
				}
				
				if (rset!=null){
					rset.close();
				}
				
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
		
		return categorias;
	}
	
	public void update(Categoria categoria){
		String sql = "UPDATE tb_categoria SET NOME_CATEGORIA = ?" + "WHERE ID_CATEGORIA = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			pstm.setString(1, categoria.getNome());
			
			pstm.setInt(2, categoria.getID_CATEGORIA());
			
			pstm.execute();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null){
					pstm.close();
				}
				
				if (conn!=null){
					conn.close();
				}

			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id){
		
		String sql = "DELETE FROM tb_categoria WHERE ID_CATEGORIA= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			pstm.setInt(1, id);
					
			pstm.execute();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null){
					pstm.close();
				}
				
				if (conn!=null){
					conn.close();
				}

			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
		
	}
}
