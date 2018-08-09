package br.com.portal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portal.bo.MateriaBO;
import br.com.portal.to.Materia;

/**
 * Servlet implementation class ControleMateriaPrima
 */
@WebServlet("/materia")
public class ControleMateriaPrima extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleMateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			ArrayList<Materia> listaMaterias = new MateriaBO().buscarMateria();
			request.setAttribute("listaMateria", new MateriaBO().buscarMateria());
			
			for (Materia materia : listaMaterias) {
				System.out.println(materia.getNomeMateria());
			}

			RequestDispatcher fw = request.getRequestDispatcher("materia.jsp");
			fw.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			System.out.println(e.getMessage());
			e.printStackTrace();



		}		}

}
