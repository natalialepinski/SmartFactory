package br.com.portal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.VendaBO;
import br.com.portal.to.Venda;

/**
 * Servlet implementation class ControleStatus
 */
@WebServlet("/status")
public class ControleStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("opt");
		String cod = request.getParameter("codigoProduto");
		int codigo = Integer.parseInt(cod);
		switch (acao) {
		case "1":
			Venda venda = new Venda();
			venda.setCodigoVenda(codigo);
			venda.setStatus("entregue");
			try {
				VendaBO vendaBO = new VendaBO();
				vendaBO.alteraStatus(venda);
				
				RequestDispatcher fw = request.getRequestDispatcher("home");
				fw.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "2":
			Venda venda1 = new Venda();
			venda1.setCodigoVenda(codigo);
			venda1.setStatus("cancelado");
			try {
				VendaBO vendaBO = new VendaBO();
				vendaBO.alteraStatus(venda1);
				
				RequestDispatcher fw = request.getRequestDispatcher("home");
				fw.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		default:
			break;
		}
	}

}
