package main.java.br.com.lojacar8;

public class ProdutoInfo {

	private int ID_PRODUTO;
	private String NOME_PRODUTO;
	private String DESCRICAO_PRODUTO;
	private Double PRECO_PRODUTO;
	private String categoria;

	public int getID_PRODUTO() {
		return ID_PRODUTO;
	}
	
	public void setID_PRODUTO(int iD_PRODUTO) {
		ID_PRODUTO = iD_PRODUTO;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DESCRICAO_PRODUTO == null) ? 0 : DESCRICAO_PRODUTO.hashCode());
		result = prime * result + ID_PRODUTO;
		result = prime * result + ((NOME_PRODUTO == null) ? 0 : NOME_PRODUTO.hashCode());
		result = prime * result + ((PRECO_PRODUTO == null) ? 0 : PRECO_PRODUTO.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoInfo other = (ProdutoInfo) obj;
		if (DESCRICAO_PRODUTO == null) {
			if (other.DESCRICAO_PRODUTO != null)
				return false;
		} else if (!DESCRICAO_PRODUTO.equals(other.DESCRICAO_PRODUTO))
			return false;
		if (ID_PRODUTO != other.ID_PRODUTO)
			return false;
		if (NOME_PRODUTO == null) {
			if (other.NOME_PRODUTO != null)
				return false;
		} else if (!NOME_PRODUTO.equals(other.NOME_PRODUTO))
			return false;
		if (PRECO_PRODUTO == null) {
			if (other.PRECO_PRODUTO != null)
				return false;
		} else if (!PRECO_PRODUTO.equals(other.PRECO_PRODUTO))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n [Produto = " + NOME_PRODUTO + " ,ID do produto = " + ID_PRODUTO +  ", Descrição = "
				+ DESCRICAO_PRODUTO + ", Preço = " + PRECO_PRODUTO + ", Categoria=" + categoria +"]";
	}

	public String getNome() {
		return NOME_PRODUTO;
	}

	public void setNome(String nome) {
		this.NOME_PRODUTO = nome;
	}

	public String getDescricao() {
		return DESCRICAO_PRODUTO;
	}

	public void setDescricao(String descricao) {
		this.DESCRICAO_PRODUTO = descricao;
	}

	public Double getPreco() {
		return PRECO_PRODUTO;
	}

	public void setPreco(Double preco) {
		this.PRECO_PRODUTO = preco;
	}


}