package br.com.portal.bo;

import java.util.ArrayList;
import br.com.portal.dao.VendaDAO;
import br.com.portal.to.Venda;

public class VendaBO {

	public void inserirVenda(Venda venda) throws Exception{

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.adiciona(venda);
	}

	public void alteraVenda(Venda venda) throws Exception{

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.altera(venda);
	}

	public void alteraStatus(Venda venda) throws Exception{

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.alteraStatus(venda);
	}

	public ArrayList<Venda> buscarTodosVendas() throws Exception{
		return (new VendaDAO()).getLista();
	}

	public void removerVenda(Venda venda) throws Exception{
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.remove(venda);
	}


}
