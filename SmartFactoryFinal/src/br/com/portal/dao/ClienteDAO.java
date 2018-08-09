package br.com.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.portal.to.Cliente;

public class ClienteDAO {

	private Connection connection;
	private String mensagemErroAbrirConexao = "Erro ao conectar ou manipular o banco de dados";
	private String mensagemErroFecharConexao = "Erro ao fechar a conexão com o banco de dados";

	public ClienteDAO() {
		this.connection = new ConnectionManager().getConnection();
	}

	public void adiciona(Cliente cliente) throws SQLException {
		Connection conn = null;
		String sql = "INSERT INTO T_SYS_CLIENTE"
				+ "(cd_cliente, nm_contato, nm_fantasia, nm_razao, nr_cnpj, ds_email, cd_senha, ds_logradouro, nr_casa, ds_complemento, ds_cidade, ds_estado, ds_cep, nr_telefone)"
				+ "values (seq_cd_cliente.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new ClienteDAO().connection.prepareStatement(sql);

			statement.setString(1, cliente.getNomeCompleto());
			statement.setString(2, cliente.getNomeFantasia());
			statement.setString(3, cliente.getRazaoSocial());
			statement.setString(4, cliente.getCnpj());
			statement.setString(5, cliente.getEmail());
			statement.setString(6, cliente.getSenha());
			statement.setString(7, cliente.getLogradouro());
			statement.setInt(8, cliente.getNumero());
			statement.setString(9, cliente.getComplemento());
			statement.setString(10, cliente.getCidade());
			statement.setString(11, cliente.getEstado());
			statement.setString(12, cliente.getCep());
			statement.setString(13, cliente.getTelefone());

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

	public void altera(Cliente cliente) throws SQLException {
		Connection conn = null;

		String sql = "UPDATE T_SYS_CLIENTE SET nm_contato=?, nm_fantasia=?, nm_razao=?, nr_cnpj=?, ds_email=?,"
				+ "cd_senha=?, ds_logradouro=?, nr_casa=?, ds_complemento=?, ds_cidade=?, ds_estado=?, ds_cep=?, nr_telefone=?  WHERE cd_cliente=?";

		try {
			conn = new ConnectionManager().getConnection();

			PreparedStatement statement = new ClienteDAO().connection.prepareStatement(sql);
			statement.setString(1, cliente.getNomeCompleto());
			statement.setString(2, cliente.getNomeFantasia());
			statement.setString(3, cliente.getRazaoSocial());
			statement.setString(4, cliente.getCnpj());
			statement.setString(5, cliente.getEmail());
			statement.setString(6, cliente.getSenha());
			statement.setString(7, cliente.getLogradouro());
			statement.setInt(8, cliente.getNumero());
			statement.setString(9, cliente.getComplemento());
			statement.setString(10, cliente.getCidade());
			statement.setString(11, cliente.getEstado());
			statement.setString(12, cliente.getCep());
			statement.setString(13, cliente.getTelefone());
			statement.setInt(14, cliente.getCodigo());
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

	public ArrayList<Cliente> getLista() throws SQLException {
		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();

			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM T_SYS_CLIENTE");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("cd_cliente"));
				cliente.setNomeCompleto(rs.getString("nm_contato"));
				cliente.setNomeFantasia(rs.getString("nm_fantasia"));
				cliente.setRazaoSocial(rs.getString("nm_razao"));
				cliente.setCnpj(rs.getString("nr_cnpj"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setTelefone(rs.getString("nr_telefone"));
				cliente.setLogradouro(rs.getString("ds_logradouro"));
				cliente.setNumero(rs.getInt("nr_casa"));
				cliente.setComplemento(rs.getString("ds_complemento"));
				cliente.setCidade(rs.getString("ds_cidade"));
				cliente.setEstado(rs.getString("ds_estado"));
				cliente.setCep(rs.getString("ds_cep"));
				cliente.setSenha(rs.getString("cd_senha"));
			}
			rs.close();
			statement.close();
			return clientes;
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

	public void remove(Cliente cliente) throws SQLException {
		Connection conn = null;
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM T_SYS_CLIENTE WHERE cd_cliente=?");
			statement.setInt(1, cliente.getCodigo());
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

	public Cliente validaLogin(String email, String senha) throws SQLException {

		Connection conn = null;

		try {
			conn = new ConnectionManager().getConnection();
			String query = "SELECT * FROM T_SYS_CLIENTE WHERE ds_email = ? AND cd_senha = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, senha);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("cd_cliente"));
				cliente.setNomeCompleto(rs.getString("nm_contato"));
				cliente.setNomeFantasia(rs.getString("nm_fantasia"));
				cliente.setRazaoSocial(rs.getString("nm_razao"));
				cliente.setCnpj(rs.getString("nr_cnpj"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setSenha(rs.getString("cd_senha"));
				cliente.setLogradouro(rs.getString("ds_logradouro"));
				cliente.setNumero(rs.getInt("nr_casa"));
				cliente.setComplemento(rs.getString("ds_complemento"));
				cliente.setCidade(rs.getString("ds_cidade"));
				cliente.setEstado(rs.getString("ds_estado"));
				cliente.setCep(rs.getString("ds_cep"));
				cliente.setTelefone(rs.getString("nr_telefone"));
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar ou manipular o banco", e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Cliente consultarPorId(int id) {
		Connection conn = null;
		Cliente cliente = new Cliente();
		try {
			conn = new ConnectionManager().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_SYS_CLIENTE WHERE cd_cliente=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente.setCodigo(rs.getInt("cd_cliente"));
				cliente.setNomeCompleto(rs.getString("nm_contato"));
				cliente.setNomeFantasia(rs.getString("nm_fantasia"));
				cliente.setRazaoSocial(rs.getString("nm_razao"));
				cliente.setCnpj(rs.getString("nr_cnpj"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setSenha(rs.getString("cd_senha"));
				cliente.setLogradouro(rs.getString("ds_logradouro"));
				cliente.setNumero(rs.getInt("nr_casa"));
				cliente.setComplemento(rs.getString("ds_complemento"));
				cliente.setCidade(rs.getString("ds_cidade"));
				cliente.setEstado(rs.getString("ds_estado"));
				cliente.setCep(rs.getString("ds_cep"));
				cliente.setTelefone(rs.getString("nr_telefone"));
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
		return cliente;
	}

}
