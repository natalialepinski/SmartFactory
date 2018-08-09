package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.to.Materia;

public class MateriaDAO {

	private Connection connection;

	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conex�o com o banco de dados";

	public void adiciona(Materia materia) throws SQLException{
		Connection conn = null;

		String sql = "INSERT INTO T_SYS_MATERIA_PRIMA" + ("cd_materia, ds_materia, ds_cor, vl_materia, qt_materia") + "values (seq_cd_produto.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = new MateriaDAO().connection.prepareStatement(sql);

			statement.setInt(1, materia.getCodigoMateria());
			statement.setString(2, materia.getNomeMateria());
			statement.setString(3, materia.getCor());
			statement.setDouble(4, materia.getValorMateria());
			statement.setInt(5, materia.getQuantidade());

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(mensagemErroAbrirConexao, e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(mensagemErroFecharConexao, e);
				}
			}
		}
	}

	public void altera(Materia materia) throws SQLException{
		Connection conn = null;
		String sql = "UPDATE T_SYS_MATERIA_PRIMA SET cd_materia=?, ds_materia=?, ds_cor=?, vl_materia=?, qt_materia =? WHERE cd_materia=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new MateriaDAO().connection.prepareStatement(sql);
			statement.setInt(1, materia.getCodigoMateria());
			statement.setString(2, materia.getNomeMateria());
			statement.setString(3, materia.getCor());
			statement.setDouble(4, materia.getValorMateria());
			statement.setInt(5, materia.getQuantidade());

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(mensagemErroAbrirConexao, e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(mensagemErroFecharConexao, e);
				}
			}
		}
	}

	public ArrayList<Materia> listar() throws SQLException{
		Connection conn = null;
		ArrayList<Materia> materias = new ArrayList<Materia>();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM T_SYS_MATERIA_PRIMA");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Materia materia = new Materia();
				materia.setCodigoMateria(rs.getInt("cd_materia"));
				materia.setNomeMateria(rs.getString("ds_materia"));
				materia.setCor(rs.getString("ds_cor"));
				materia.setValorMateria(rs.getDouble("vl_materia"));
				materia.setQuantidade(rs.getInt("qt_materia"));
				
				materias.add(materia);
			}
			rs.close();
			statement.close();

			return materias;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new SQLException(mensagemErroAbrirConexao, e);

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(mensagemErroFecharConexao, e);
				}
			}
		}
	}

	public void remove(Materia materia) throws SQLException{
		Connection conn = null;
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_MATERIA_PRIMA WHERE cd_materia=?");
			statement.setInt(1, materia.getCodigoMateria());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(mensagemErroAbrirConexao, e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(mensagemErroFecharConexao, e);
				}
			}
		}
	}

	public Materia consultarPorId(int id) {
		Connection conn = null;
		Materia materia = new Materia();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_SYS_MATERIA_PRIMA WHERE cd_materia=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				materia.setCodigoMateria(rs.getInt("cd_materia"));
				materia.setNomeMateria(rs.getString("ds_materia"));
				materia.setCor(rs.getString("ds_cor"));
				materia.setValorMateria(rs.getDouble("vl_materia"));
				materia.setQuantidade(rs.getInt("qt_materia"));
			}
		} catch (SQLException ex1) {
			throw new RuntimeException(ex1);
		} finally {
			try{
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				throw new RuntimeException(e);
			}

		}
		return materia;
	}
}


