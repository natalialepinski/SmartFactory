package br.com.portal.bo;

import java.util.ArrayList;
import br.com.portal.dao.MateriaDAO;
import br.com.portal.to.Materia;

public class MateriaBO {

	public void inserirProduto(Materia materia) throws Exception{
		
		MateriaDAO materiaDAO = new MateriaDAO();
		materiaDAO.adiciona(materia);
	}
	
	public void alteraProduto(Materia materia) throws Exception{
		
		MateriaDAO materiaDAO = new MateriaDAO();
		materiaDAO.altera(materia);
	}
	
	public ArrayList<Materia> buscarMateria() throws Exception{
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.listar();
	}
	
	public void removerMateria(Materia materia) throws Exception{
		MateriaDAO materiaDAO = new MateriaDAO();
		materiaDAO.remove(materia);
	}
	
	public Materia consultaPorId(int id) throws Exception{
		return new MateriaDAO().consultarPorId(id);
	}
}
