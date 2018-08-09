package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.to.Fornecedor;

public class FornecedorDAO {

	private Connection connection;

	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conex�o com o banco de dados";

	public void adiciona(Fornecedor fornecedor) throws SQLException{
		Connection conn = null;

		String sql = "INSERT INTO T_SYS_FORNECEDOR" + ("cd_fornecedor, nm_fantasia, nm_razao, nr_cnpj, ds_email, nr_telefone, ds_logradouro, nr_casa, ds_complemento, ds_cidade, ds_estado, ds_cep, nm_contato") + "values (seq_cd_fornecedor.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = new FornecedorDAO().connection.prepareStatement(sql);

			statement.setInt(1, fornecedor.getCodigoFornecedor());
			statement.setString(2, fornecedor.getNomeFantasia());
			statement.setString(3, fornecedor.getNomeRazao());
			statement.setInt(4, fornecedor.getCnpj());
			statement.setString(5, fornecedor.getEmail());
			statement.setInt(6, fornecedor.getTelefone());
			statement.setString(7, fornecedor.getEndereco());
			statement.setInt(8, fornecedor.getNumeroCasa());
			statement.setString(9, fornecedor.getComplemento());
			statement.setString(10, fornecedor.getCidade());
			statement.setString(11, fornecedor.getEstado());
			statement.setInt(12, fornecedor.getCep());
			statement.setString(13, fornecedor.getNomeContato());
			
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

	public void altera(Fornecedor fornecedor) throws SQLException{
		Connection conn = null;
		String sql = "UPDATE T_SYS_FORNECEDOR SET cd_fornecedor=?, nm_fantasia=?, nm_razao=?, nr_cnpj=?, ds_email=?, nr_telefone=?, ds_logradouro=?, nr_casa=?, ds_complemento=?, ds_cidade=?, ds_estado=?, ds_cep=?, nm_contato=? WHERE cd_fornecedor=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new FornecedorDAO().connection.prepareStatement(sql);
			statement.setInt(1, fornecedor.getCodigoFornecedor());
			statement.setString(2, fornecedor.getNomeFantasia());
			statement.setString(3, fornecedor.getNomeRazao());
			statement.setInt(4, fornecedor.getCnpj());
			statement.setString(5, fornecedor.getEmail());
			statement.setInt(6, fornecedor.getTelefone());
			statement.setString(7, fornecedor.getEndereco());
			statement.setInt(8, fornecedor.getNumeroCasa());
			statement.setString(9, fornecedor.getComplemento());
			statement.setString(10, fornecedor.getCidade());
			statement.setString(11, fornecedor.getEstado());
			statement.setInt(12, fornecedor.getCep());
			statement.setString(13, fornecedor.getNomeContato());

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

	public ArrayList<Fornecedor> listar() throws SQLException{
		Connection conn = null;
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM T_SYS_FORNECEDOR");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCodigoFornecedor(rs.getInt("cd_fornecedor"));
				fornecedor.setNomeFantasia(rs.getString("nm_fantasia"));
				fornecedor.setNomeRazao(rs.getString("nm_razao"));
				fornecedor.setCnpj(rs.getInt("nr_cnpj"));
				fornecedor.setEmail(rs.getString("ds_email"));
				fornecedor.setTelefone(rs.getInt("nr_telefone"));
				fornecedor.setEndereco(rs.getString("ds_logradouro"));
				fornecedor.setNumeroCasa(rs.getInt("nr_casa"));
				fornecedor.setComplemento(rs.getString("ds_complemento"));
				fornecedor.setCidade(rs.getString("ds_cidade"));
				fornecedor.setEstado(rs.getString("ds_estado"));
				fornecedor.setCep(rs.getInt("ds_cep"));
				fornecedor.setNomeContato(rs.getString("nm_contato"));
				
				fornecedores.add(fornecedor);
			}
			rs.close();
			statement.close();

			return fornecedores;

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

	public void remove(Fornecedor fornecedor) throws SQLException{
		Connection conn = null;
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_FORNECEDOR WHERE cd_fornecedor=?");
			statement.setInt(1, fornecedor.getCodigoFornecedor());
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

	public Fornecedor consultarPorId(int id) {
		Connection conn = null;
		Fornecedor fornecedor = new Fornecedor();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_SYS_FORNECEDOR WHERE cd_fornecedor=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fornecedor.setCodigoFornecedor(rs.getInt("cd_fornecedor"));
				fornecedor.setNomeFantasia(rs.getString("nm_fantasia"));
				fornecedor.setNomeRazao(rs.getString("nm_razao"));
				fornecedor.setCnpj(rs.getInt("nr_cnpj"));
				fornecedor.setEmail(rs.getString("ds_email"));
				fornecedor.setTelefone(rs.getInt("nr_telefone"));
				fornecedor.setEndereco(rs.getString("ds_logradouro"));
				fornecedor.setNumeroCasa(rs.getInt("nr_casa"));
				fornecedor.setComplemento(rs.getString("ds_complemento"));
				fornecedor.setCidade(rs.getString("ds_cidade"));
				fornecedor.setEstado(rs.getString("ds_estado"));
				fornecedor.setCep(rs.getInt("ds_cep"));
				fornecedor.setNomeContato(rs.getString("nm_contato"));
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
		return fornecedor;
	}
}


