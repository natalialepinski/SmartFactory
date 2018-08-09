package br.com.portal.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.ProdutoBO;
import br.com.portal.to.ItemVenda;
import br.com.portal.to.Produto;

/**
 * Servlet implementation class Controle
 */
@WebServlet(urlPatterns = "/ControleCarrinho", initParams = { @WebInitParam(name = "paramInit", value = "8"),
		@WebInitParam(name = "paramFim", value = "13") })

public class ControleCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Produto> l = new ArrayList<Produto>();

	private int a;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleCarrinho() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		a = Integer.parseInt(config.getInitParameter("paramInit"));

	}

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opt = request.getParameter("opt");
		int id = Integer.parseInt(request.getParameter("codigoProduto"));

		if (request.getSession().getAttribute("usuario") != null) {
			switch (opt) {
			case "1":

				double valor = Double.parseDouble(request.getParameter("valor"));
				String descricao = request.getParameter("descricao");
				String imagem = request.getParameter("imagem");
				String nome = request.getParameter("nome");
				String cor = request.getParameter("cor");
				Produto p = null;
				try {
					p = new ProdutoBO().consultaPorId(id);

				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("id", id);
				request.setAttribute("valor", valor);
				request.setAttribute("descricao", descricao);
				request.setAttribute("imagem", imagem);
				request.setAttribute("produto", p);
				request.setAttribute("nome", nome);
				request.setAttribute("cor", cor);
				RequestDispatcher fw = request.getRequestDispatcher(p.getUrlPagina());
				fw.forward(request, response);

				break;
			case "2":

				try {
					ItemVenda item = new ItemVenda();
					item.setId(id);
					item.setProduto(new ProdutoBO().consultaPorId(id));
					item.setQuantidade(Integer.parseInt(request.getParameter("quantity")));
					item.setTotal(item.getQuantidade() * item.getProduto().getValorProduto());
					item.setCor(item.getProduto().getCor());
					item.setValorProduto(item.getProduto().getValorProduto());
					item.setNomeProduto(item.getProduto().getNomeProduto());
					item.setUrlImg(item.getProduto().getUrlImg());

					HashMap<Integer, ItemVenda> listaCarrinho = (HashMap<Integer, ItemVenda>) request.getSession().getAttribute("carrinhoUsuario");
					listaCarrinho.put(item.getId(), item);

					request.getSession().setAttribute("carrinhoUsuario", listaCarrinho);
					fw = request.getRequestDispatcher("cart.jsp");
					fw.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			default:
				break;
			}
		}else{
			RequestDispatcher fw = request.getRequestDispatcher("login-registration.jsp");
			fw.forward(request, response);
		}
	}

}
