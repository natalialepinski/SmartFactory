package br.com.portal.teste;

import br.com.portal.bo.VendaBO;
import br.com.portal.to.Cliente;
import br.com.portal.to.Venda;

public class TesteInsere {

	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente();
		cliente.setCodigo(13);
		Venda venda = new Venda();
		venda.setDataEmissao("26/09/2017");
		venda.setTotal(200);
		venda.setCodigoCliente(cliente);
		
		
		VendaBO vendaBO = new VendaBO();
		vendaBO.inserirVenda(venda);
		
		System.out.println("Gravado!");
		
	}
}
