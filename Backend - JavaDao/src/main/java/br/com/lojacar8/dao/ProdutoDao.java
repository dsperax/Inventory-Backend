package main.java.br.com.lojacar8.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import main.java.br.com.lojacar8.Produto;
import main.java.br.com.lojacar8.ProdutoInfo;
import main.java.br.com.lojacar8.factory.ConnectionFactory;

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
	
	public List<ProdutoInfo> getProdutos() {
		String sql = "SELECT * FROM tb_produto p INNER JOIN tb_categoria c ON p.ID_CATEGORIA = c.ID_CATEGORIA";
		
		List<ProdutoInfo> produtos = new ArrayList<ProdutoInfo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null; //SELECT
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			rset = pstm.executeQuery(); //executa query

			while (rset.next()){
				//recupera informações
				ProdutoInfo produto = new ProdutoInfo();
				produto.setNome(rset.getString("NOME_PRODUTO"));
				produto.setID_PRODUTO(rset.getInt("ID_PRODUTO"));
				produto.setDescricao(rset.getString("DESCRICAO_PRODUTO"));
				produto.setPreco(rset.getDouble("PRECO_PRODUTO"));
				produto.setCategoria(rset.getString("NOME_CATEGORIA"));
				
				produtos.add(produto);
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
		
		return produtos;
	}
	
	public void update(Produto produto){
		String sql = "UPDATE tb_produto SET NOME_PRODUTO = ?, DESCRICAO_PRODUTO = ?, PRECO_PRODUTO = ?, ID_CATEGORIA = ? WHERE ID_PRODUTO = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.setInt(4, produto.getCategoria());
			
			pstm.setInt(5, produto.getID_PRODUTO());
			
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
		
		String sql = "DELETE FROM tb_produto WHERE ID_PRODUTO = ?";
		
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
	
	public String getProdutoById(int id){
		
		String sql = "SELECT * FROM TB_PRODUTO c WHERE c.ID_PRODUTO= ?";
		
		Produto produto = new Produto();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null; //SELECT
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery(); //executa query
			
			while (rset.next()){
				produto.setID_PRODUTO(rset.getInt("ID_PRODUTO"));//recupera id
				produto.setNome(rset.getString("NOME_PRODUTO"));//recupera nome
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
		
		return produto.getNome();
	}

	public String getProdutoByName(String name){
		
		String sql = "SELECT * FROM TB_PRODUTO c WHERE c.NOME_PRODUTO= ?";
		
		Produto produto = new Produto();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null; //SELECT
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //conexão com o banco
			
			pstm = (PreparedStatement) conn.prepareStatement(sql); //prepared statement para executar a query
			
			pstm.setString(1, name.toUpperCase());
			
			rset = pstm.executeQuery(); //executa query
			
			while (rset.next()){
				produto.setID_PRODUTO(rset.getInt("ID_PRODUTO"));//recupera id
				produto.setNome(rset.getString("NOME_PRODUTO"));//recupera nome
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
		
		return produto.getNome();
	}
}
