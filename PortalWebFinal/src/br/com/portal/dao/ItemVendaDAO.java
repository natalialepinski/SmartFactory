package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.portal.to.ItemVenda;
import br.com.portal.to.Produto;

public class ItemVendaDAO {

	private Connection connection;

	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conexão com o banco de dados";


	public void adiciona(ItemVenda itemVenda) throws SQLException {

		Connection conn = null;

		String sql = "INSERT INTO T_SYS_VENDA_PRODUTO" + ("cd_venda_produto, qt_produto, cd_produto, vl_total") + "values (seq_cd_item_venda.nextval, ?, ?, ?)";

		try {

			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new ItemVendaDAO().connection.prepareStatement(sql);

			statement.setInt(1, itemVenda.getQuantidade());
			statement.setInt(2, itemVenda.getProduto().getCodigoProduto());
			statement.setDouble(3, itemVenda.getTotal());

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

	public void altera(ItemVenda itemVenda) throws SQLException{

		Connection conn = null;

		String sql = "UPDATE T_SYS_VENDA_PRODUTO SET qt_produto=?, cd_produto=?, vl_total=? WHERE cd_venda_produto=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new ItemVendaDAO().connection.prepareStatement(sql);
			statement.setInt(1, itemVenda.getQuantidade());
			statement.setInt(2, itemVenda.getProduto().getCodigoProduto());
			statement.setDouble(3, itemVenda.getTotal());

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

	public ArrayList<ItemVenda> getLista() throws SQLException{
		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();

			ArrayList<ItemVenda> itemVendas = new ArrayList<ItemVenda>();
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM T_SYS_VENDA_PRODUTO");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				ItemVenda itemVenda = new ItemVenda();
				itemVenda.setId(rs.getInt("cd_venda_produto"));
				itemVenda.setQuantidade(rs.getInt("qt_produto"));
				itemVenda.setTotal(rs.getDouble("vl_total"));
				itemVenda.setProduto((Produto) rs.getObject("cd_produto"));
				
				itemVendas.add(itemVenda);

			}
			rs.close();
			statement.close();
			return itemVendas;
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

	public void remove(ItemVenda itemVenda) throws SQLException{
		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_VENDA_PRODUTO WHERE cd_itemVenda=?");
			statement.setInt(1, itemVenda.getId());
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
