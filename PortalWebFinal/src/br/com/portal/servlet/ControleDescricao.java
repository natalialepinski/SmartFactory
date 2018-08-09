package br.com.portal.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ProdutoBO;
import br.com.portal.to.Produto;

@SuppressWarnings("serial")
public class ControleDescricao extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse
			response)
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String acao = request.getParameter("acao");
			if (acao.equals("produtos")) {
				//monta uma lista para exibição na pagina principal
				ArrayList<Produto> produtos = new ProdutoBO().buscarProduto();
				//armazena os produto na requisição
				request.setAttribute("produtos", produtos);
				//invia para index.jsp
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception erro) {
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
