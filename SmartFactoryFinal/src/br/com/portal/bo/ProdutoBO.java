package br.com.portal.bo;

import java.util.ArrayList;
import br.com.portal.dao.ProdutoDAO;
import br.com.portal.to.Producao;
import br.com.portal.to.Produto;

public class ProdutoBO {

	public void inserirProduto(Produto produto) throws Exception{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.adiciona(produto);
	}
	
	public void alteraProduto(Produto produto) throws Exception{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.altera(produto);
	}
	
	public ArrayList<Produto> buscarProduto() throws Exception{
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listar();
	}
	
	public void removerProduto(Produto produto) throws Exception{
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.remove(produto);
	}
	
	public Produto consultaPorId(int id) throws Exception{
		return new ProdutoDAO().consultarPorId(id);
	}
	
	public void producao(Produto produto) throws Exception{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.producao(produto);
	}
}
