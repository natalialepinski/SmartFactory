package br.com.portal.bo;

import java.util.ArrayList;
import br.com.portal.dao.FornecedorDAO;
import br.com.portal.to.Fornecedor;

public class FornecedorBO {


	public void inserirFornecedor(Fornecedor fornecedor) throws Exception{
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.adiciona(fornecedor);
	}
	
	public void alteraFornecedor(Fornecedor fornecedor) throws Exception{
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.altera(fornecedor);
	}
	
	public ArrayList<Fornecedor> buscarFornecedor() throws Exception{
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		return fornecedorDAO.listar();
	}
	
	public void removerFornecedor(Fornecedor fornecedor) throws Exception{
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.remove(fornecedor);
	}
	
	public Fornecedor consultaPorId(int id) throws Exception{
		return new FornecedorDAO().consultarPorId(id);
	}
}
