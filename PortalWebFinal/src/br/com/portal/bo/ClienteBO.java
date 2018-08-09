package br.com.portal.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.dao.ClienteDAO;
import br.com.portal.to.Cliente;

public class ClienteBO {

	public void inserirCliente(Cliente cliente) throws Exception {

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.adiciona(cliente);
	}

	public void alteraCliente(Cliente cliente) throws Exception {

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.altera(cliente);
	}

	public ArrayList<Cliente> buscarTodosClientes() throws Exception {
		return (new ClienteDAO()).getLista();
	}

	public void removerCliente(Cliente cliente) throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.remove(cliente);
	}

	public Cliente validaLogin(String email, String senha) throws SQLException {
		return new ClienteDAO().validaLogin(email, senha);
	}
	
	public Cliente consultaPorId(int id) throws Exception{
		return new ClienteDAO().consultarPorId(id);
	}
}
