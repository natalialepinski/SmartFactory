package br.com.portal.servlet;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.VendaBO;
//import br.com.portal.to.Venda;

/**
 * Servlet implementation class ControlePedido
 */
@WebServlet("/home")
public class ControlePedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlePedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			//ArrayList<Venda> listaVendas = new VendaBO().buscarTodosVendas();
			request.setAttribute("listaVenda", new VendaBO().buscarTodosVendas());
			
			RequestDispatcher fw = request.getRequestDispatcher("pedidos.jsp");
			fw.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			
			
		}	
	}

}
