package br.com.portal.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.VendaBO;
import br.com.portal.to.Cliente;
import br.com.portal.to.ItemVenda;
import br.com.portal.to.Venda;

/**
 * Servlet implementation class FinalizaController
 */
@WebServlet("/finaliza")
public class FinalizaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		HashMap<Integer, ItemVenda> mapItens = (HashMap<Integer, ItemVenda>)request.getSession().getAttribute("carrinhoUsuario");
		
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	    
		double totalVenda = 0.0;
		Venda venda = new Venda();
		
		for (ItemVenda v : mapItens.values()) {
			totalVenda += v.getTotal();
		}
		venda.setItens(mapItens);
		venda.setCodigoCliente((Cliente) request.getSession().getAttribute("usuario"));
		venda.setDataEmissao(formatador.format(data));
		venda.setTotal(totalVenda);
		
		VendaBO vendaBO = new VendaBO();
		try {
			
			vendaBO.inserirVenda(venda);
			mapItens.clear();
			RequestDispatcher fw = request.getRequestDispatcher("compraRealizada.jsp");
			fw.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
