package br.com.portal.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.to.ItemVenda;

/**
 * Servlet implementation class RemoveProdutoServlet
 */
@WebServlet("/RemoveProdutoServlet")
public class RemoveProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		@SuppressWarnings("unchecked")
		HashMap<Integer, ItemVenda> listaCarrinho = (HashMap<Integer, ItemVenda>) request.getSession().getAttribute("carrinhoUsuario");
		
		listaCarrinho.remove(id);
		for (ItemVenda item : listaCarrinho.values()) {
			System.out.println(item.getId());
		}
		RequestDispatcher fw = request.getRequestDispatcher("cart.jsp");
		fw.forward(request, response);
	}

}
