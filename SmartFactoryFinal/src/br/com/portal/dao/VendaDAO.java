package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.bo.ItemVendaBO;
import br.com.portal.to.ItemVenda;
import br.com.portal.to.Venda;

public class VendaDAO {

	private Connection connection;

	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conex�o com o banco de dados";

	public VendaDAO() {
		this.connection = new ConnectionManager().getConnection();
	}


	public int retornaCodigo() throws SQLException{

		Connection conn = null;


		try {

			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM T_SYS_VENDA WHERE ROWID = (SELECT MAX(ROWID) FROM T_SYS_VENDA)");
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				int teste = rs.getInt("cd_venda");
				System.out.println(teste);
				return teste;
			}else{

				return 0;
			}

		} catch (Exception e) {
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
	public void adiciona(Venda venda) throws SQLException {

		Connection conn = null;

		String sql = "INSERT INTO T_SYS_VENDA" + "(cd_venda, cd_cliente, dt_emissao, vl_total,st_venda)" + "VALUES (seq_cd_venda.nextval, ?, ?, ?, ?)";

		try {

			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new VendaDAO().connection.prepareStatement(sql);

			statement.setInt(1, venda.getCodigoCliente().getCodigo());
			statement.setString(2, venda.getDataEmissao());
			statement.setDouble(3, venda.getTotal());
			statement.setString(4, "em andamento");

			statement.executeUpdate();

			int codigo = retornaCodigo();

			ItemVendaBO itemBO = new ItemVendaBO();

			try {
				for (ItemVenda v : venda.getItens().values()) {
					itemBO.inserirItemVenda(v, codigo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


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

	public void altera(Venda venda) throws SQLException{

		Connection conn = null;

		String sql = "UPDATE T_SYS_VENDA SET dt_emissao=?, cd_cliente=?, vl_total=?, st_venda=? WHERE cd_venda=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new VendaDAO().connection.prepareStatement(sql);
			statement.setString(1, venda.getDataEmissao());
			statement.setObject(2, venda.getCodigoCliente());
			statement.setDouble(3, venda.getTotal());
			statement.setString(4, venda.getStatus());
			statement.setInt(5, venda.getCodigoVenda());

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

	public void alteraStatus(Venda venda) throws SQLException{

		Connection conn = null;

		String sql = "UPDATE T_SYS_VENDA SET st_venda=? WHERE cd_venda=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new VendaDAO().connection.prepareStatement(sql);
			statement.setString(1, venda.getStatus());
			statement.setInt(2, venda.getCodigoVenda());

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
	
	public ArrayList<Venda> getLista() throws SQLException{
		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();

			ArrayList<Venda> vendas = new ArrayList<Venda>();
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM T_SYS_VENDA ORDER BY 1 ASC");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Venda venda = new Venda();
				venda.setCodigoVenda(rs.getInt("cd_venda"));
				venda.setDataEmissao(rs.getString("dt_emissao"));
				//venda.setCodigoCliente((Cliente) rs.getObject("cd_cliente"));
				venda.setTotal(rs.getDouble("vl_total"));
				venda.setStatus(rs.getString("st_venda"));

				vendas.add(venda);

			}
			rs.close();
			statement.close();
			return vendas;
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

	public void remove(Venda venda) throws SQLException{
		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_VENDA WHERE cd_venda=?");
			statement.setInt(1, venda.getCodigoVenda());
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
}
