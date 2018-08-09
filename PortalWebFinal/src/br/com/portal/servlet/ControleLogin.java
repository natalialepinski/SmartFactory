package br.com.portal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ClienteBO;
import br.com.portal.to.Cliente;
import br.com.portal.to.ItemVenda;

/**
 * Servlet implementation class ControleLogin
 */
@WebServlet("/login")
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher fw = null;
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String opt = request.getParameter("opt");
		
		
		switch (opt) {
		case "entrar":
			try {
				Cliente cliente = new ClienteBO().validaLogin(email, senha);
				if (cliente != null) {
					request.getSession().setAttribute("usuario", cliente);
					request.getSession().setAttribute("carrinhoUsuario", new HashMap<Integer, ItemVenda>());
					fw = request.getRequestDispatcher("home");
					fw.forward(request, response);
				} else {
					fw = request.getRequestDispatcher("login-registration.jsp");
					fw.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "sair":
			Cliente cliente = (Cliente)request.getSession().getAttribute("usuario");
			cliente = null;
			request.getSession().setAttribute("usuario", cliente);
			request.getSession().invalidate();
			fw = request.getRequestDispatcher("login-registration.jsp");
			fw.forward(request, response);
			
			break;

		default:
			break;
		}
	}

}
