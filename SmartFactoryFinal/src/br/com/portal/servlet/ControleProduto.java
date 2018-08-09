package br.com.portal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ProdutoBO;

/**
 * Servlet implementation class ControleProduto
 */
@WebServlet("/produto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setAttribute("listaProduto", new ProdutoBO().buscarProduto());

			RequestDispatcher fw = request.getRequestDispatcher("estoque.jsp");
			fw.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			System.out.println(e.getMessage());
			e.printStackTrace();



		}	

	}

}
