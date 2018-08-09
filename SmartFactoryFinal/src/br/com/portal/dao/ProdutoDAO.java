package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.to.Producao;
import br.com.portal.to.Produto;
import br.com.portal.to.Venda;

public class ProdutoDAO {

	private Connection connection;

	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conexão com o banco de dados";
	
	public ProdutoDAO() {
		this.connection = new ConnectionManager().getConnection();
	}


	public void adiciona(Produto produto) throws SQLException{
		Connection conn = null;

		String sql = "INSERT INTO T_SYS_PRODUTO" + ("cd_produto, nm_produto, ds_cor, vl_produto, ds_url, ds_produto, ds_pag") + "values (seq_cd_produto.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = new ProdutoDAO().connection.prepareStatement(sql);

			statement.setString(1, produto.getNomeProduto());
			statement.setString(2, produto.getCor());
			statement.setDouble(3, produto.getValorProduto());
			statement.setString(4, produto.getUrlImg());
			statement.setString(5, produto.getDescricao());
			statement.setString(6, produto.getUrlPagina());

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

	public void altera(Produto produto) throws SQLException{
		Connection conn = null;
		String sql = "UPDATE T_SYS_PRODUTO SET cd_produto=?, nm_produto=?, ds_cor=?, vl_produto=?, ds_url=?, ds_produto=?, ds_pagina=? WHERE cd_produto=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new ProdutoDAO().connection.prepareStatement(sql);
			statement.setString(1, produto.getNomeProduto());
			statement.setString(2, produto.getCor());
			statement.setDouble(3, produto.getValorProduto());
			statement.setString(4, produto.getUrlImg());
			statement.setString(5, produto.getDescricao());
			statement.setString(6, produto.getUrlPagina());
			statement.setInt(7, produto.getCodigoProduto());

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

	public ArrayList<Produto> listar() throws SQLException{
		Connection conn = null;
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM T_SYS_PRODUTO");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();
				produto.setCodigoProduto(rs.getInt("cd_produto"));
				produto.setCor(rs.getString("ds_cor"));
				produto.setDescricao(rs.getString("ds_produto"));
				produto.setNomeProduto(rs.getString("nm_produto"));
				produto.setUrlImg(rs.getString("ds_url"));
				produto.setValorProduto(rs.getDouble("vl_produto"));
				produto.setUrlPagina(rs.getString("ds_pagina"));
				produto.setQuantidade(rs.getInt("qt_produto"));
				
				produtos.add(produto);
			}
			rs.close();
			statement.close();

			return produtos;

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

	public void remove(Produto produto) throws SQLException{
		Connection conn = null;
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_PRODUTO WHERE cd_produto=?");
			statement.setInt(1, produto.getCodigoProduto());
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

	public Produto consultarPorId(int id) {
		Connection conn = null;
		Produto produto = new Produto();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_SYS_PRODUTO WHERE cd_produto=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				produto.setCodigoProduto(rs.getInt("cd_produto"));
				produto.setCor(rs.getString("ds_cor"));
				produto.setDescricao(rs.getString("ds_produto"));
				produto.setNomeProduto(rs.getString("nm_produto"));
				produto.setUrlImg(rs.getString("ds_url"));
				produto.setValorProduto(rs.getDouble("vl_produto"));
				produto.setUrlPagina(rs.getString("ds_pagina"));
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
		return produto;
	}
	public void producao(Produto produto) throws SQLException{

		Connection conn = null;

		String sql = "UPDATE T_SYS_PRODUTO SET qt_produto = ? WHERE cd_produto = ?";

		try {
			conn = new ConnectionManager().getConnection();
			
			PreparedStatement statement = new ProdutoDAO().connection.prepareStatement(sql);
			statement.setInt(1, produto.getQuantidade());
			statement.setInt(2, produto.getCodigoProduto());
			
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


