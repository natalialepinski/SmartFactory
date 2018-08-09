package br.com.portal.bo;

import java.util.ArrayList;
import br.com.portal.dao.ItemVendaDAO;
import br.com.portal.to.ItemVenda;

public class ItemVendaBO {

	public void inserirItemVenda(ItemVenda itemVenda, int codigo) throws Exception{
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.adiciona(itemVenda, codigo);
	}
	
	public void alteraItemVenda(ItemVenda itemVenda) throws Exception{
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.altera(itemVenda);
	}
	
	public ArrayList<ItemVenda> buscarTodosItemVendas() throws Exception{
		return (new ItemVendaDAO()).getLista();
	}
	
	public void removerItemVenda(ItemVenda itemVenda) throws Exception{
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.remove(itemVenda);
	}
	
	
}
