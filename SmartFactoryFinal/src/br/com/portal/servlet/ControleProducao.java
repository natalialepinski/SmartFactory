package br.com.portal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ProdutoBO;
import br.com.portal.to.Producao;
import br.com.portal.to.Produto;

/**
 * Servlet implementation class ControleProducao
 */
@WebServlet("/producao")
public class ControleProducao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleProducao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cor = request.getParameter("cor");
		String quant = request.getParameter("iQuant");
		int descCor = 0;
		switch (cor) {
		case "1":
			descCor = 1060;
			break;
		case "2":
			descCor = 1070;
			break;
		case "3":
			descCor = 1080;
			break;

		default:
			break;
		}
		
		int quantidade = Integer.parseInt(quant);
		
		Produto p = new Produto();
		p.setCodigoProduto(descCor);
		p.setQuantidade(quantidade);
		
		ProdutoBO produtoBO = new ProdutoBO();
		try {
			produtoBO.producao(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("produto").forward(request, response);
	}


}
