package br.com.portal.teste;

import br.com.portal.dao.ClienteDAO;
import br.com.portal.to.Cliente;

public class TesteRemove {

	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente();
		cliente.setCodigo(10);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.remove(cliente);
		
		System.out.println("Removido!");
	}
}
