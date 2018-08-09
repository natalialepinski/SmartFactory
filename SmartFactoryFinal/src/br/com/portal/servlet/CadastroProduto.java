package br.com.portal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ClienteBO;
import br.com.portal.bo.ProdutoBO;
import br.com.portal.to.Cliente;
import br.com.portal.to.Produto;

/**
 * Servlet implementation class CadastroProduto
 */
@WebServlet("/cadProduto")
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProduto = request.getParameter("iNome");
		String valor = request.getParameter("iValor");
		String cor = request.getParameter("sCor");
		String quant = request.getParameter("iQuant");
		
		double valorProduto = Double.parseDouble(valor);
		int quantidade = Integer.parseInt(quant);
		Produto p = new Produto();
		p.setCor(cor);
		p.setDescricao(nomeProduto);
		p.setNomeProduto(nomeProduto);
		p.setValorProduto(valorProduto);
		p.setQuantidade(quantidade);
		
		ProdutoBO produtoBO = new ProdutoBO();
		try {
			produtoBO.inserirProduto(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("produto").forward(request, response);
		
		
	}

}
