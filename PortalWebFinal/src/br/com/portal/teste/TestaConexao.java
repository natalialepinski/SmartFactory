package br.com.portal.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.portal.dao.ConnectionManager;

public class TestaConexao {

	public static void main(String[] args) throws SQLException{
		Connection connection = new ConnectionManager().getConnection();
		System.out.println("Conexão Aberta!");
		connection.close();
	}

}
