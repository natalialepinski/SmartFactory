package br.com.portal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.portal.bo.ClienteBO;
import br.com.portal.to.Cliente;

/**
 * Servlet implementation class AdicionaClienteServlet
 */
@WebServlet("/AdicionaClienteServlet")
public class AdicionaClienteServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCompleto = request.getParameter("nomeCompleto");
		String razaoSocial = request.getParameter("razaoSocial");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cep = request.getParameter("cep");
		String senha = request.getParameter("confirmaSenha");
		
		Cliente cliente = new Cliente();
		cliente.setNomeCompleto(nomeCompleto);
		cliente.setRazaoSocial(razaoSocial);
		cliente.setNomeFantasia(nomeFantasia);
		cliente.setCnpj(cnpj);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setCidade(cidade);
		cliente.setEstado(estado);
		cliente.setCep(cep);
		cliente.setSenha(senha);
		
		ClienteBO clienteBO = new ClienteBO();
		try {
			clienteBO.inserirCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("cadastroConcluido.jsp").forward(request, response);
		
		
		
	}

}
