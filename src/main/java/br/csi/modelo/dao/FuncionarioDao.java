package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.csi.modelo.Funcionario;
import br.csi.util.ConectaBanco;

public class FuncionarioDao {
	
	public boolean cadastraFuncionario(Funcionario f) throws SQLException{
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		
		String nome = f.getNome();
		String siape = f.getSiape();
		String ramal = f.getRamal();
		String celular = f.getCelular();
		String sala = f.getSala();
		String cpf = f.getCpf();
		String identidade = f.getIdentidade();
		String email = f.getEmail();
		
		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO funcionario (nome,siape,ramal,celular,sala,cpf,identidade,email) values(?,?,?,?,?,?,?,?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, siape);
			stmt.setString(3, ramal);
			stmt.setString(4, celular);
			stmt.setString(5, sala);
			stmt.setString(6, cpf);
			stmt.setString(7, identidade);
			stmt.setString(8, email);
			
			stmt.execute();
			stmt.close();
			retorno = true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}
	
	public boolean alteraFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
	    boolean retorno = false;
        Connection c = null;
		PreparedStatement stmt = null;

			c = ConectaBanco.getConexao();
			String sql="UPDATE funcionario SET nome=?, siape=?, ramal=?, celular=?, sala=?, cpf=?, identidade=?, email=? WHERE id=?";
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSiape());
			stmt.setString(3, f.getRamal());
			stmt.setString(4, f.getCelular());
			stmt.setString(5, f.getSala());
			stmt.setString(6, f.getCpf());
			stmt.setString(7, f.getIdentidade());
			stmt.setString(8, f.getEmail());
			stmt.setInt(9, f.getId());
					
			stmt.execute();
			stmt.close();
			retorno = true;
			System.out.println("AQUI NO ALTERAR DAO--"+f.getId());
		
 return retorno;
}

	public long buscacodigo() throws SQLException, ClassNotFoundException {
		Connection c = null;
		PreparedStatement stmt = null;

		c = ConectaBanco.getConexao();
		String sql = "";

		sql = "select MAX(id) as id from funcionario";
		stmt = c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long codigo = rs.getInt("id");
		rs.close();
		stmt.close();
		return codigo;
	}

	public ArrayList<Funcionario> getFuncionarios() throws ClassNotFoundException {

		ArrayList<Funcionario> log1 = new ArrayList<Funcionario>();
		Connection con = ConectaBanco.getConexao();
		Funcionario func;

		try {
			String sql = "select * from funcionario";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				func = new Funcionario();
				func.setId(rs.getInt("id"));
				func.setNome(rs.getString("nome"));
				func.setSiape(rs.getString("siape"));
				func.setRamal(rs.getString("ramal"));
				func.setCelular(rs.getString("celular"));
				func.setSala(rs.getString("sala"));
				func.setCpf(rs.getString("cpf"));
				func.setIdentidade(rs.getString("identidade"));
				func.setEmail(rs.getString("email"));

				log1.add(func);
				System.out.println("Adicionado no Array");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log1;
	}

	public Funcionario getfuncionario(int id) throws ClassNotFoundException {
		Connection con = ConectaBanco.getConexao();
		Funcionario func = new Funcionario();
		;
		try {
			String sql = "SELECT * FROM funcionario WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				func.setId(rs.getInt("id"));
				func.setNome(rs.getString("nome"));
				func.setSiape(rs.getString("siape"));
				func.setRamal(rs.getString("ramal"));
				func.setCelular(rs.getString("celular"));
				func.setSala(rs.getString("sala"));
				func.setCpf(rs.getString("cpf"));
				func.setIdentidade(rs.getString("identidade"));
				func.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return func;
	}
	
	public Funcionario pesquisaFuncionario(int id ) throws ClassNotFoundException, SQLException{
		
		Funcionario f = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from funcionario where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO FUNCIONARIO"+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				f = new Funcionario();	    
				
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setSiape(rs.getString("siape"));
				f.setRamal(rs.getString("ramal"));
				f.setCelular(rs.getString("celular"));
				f.setSala(rs.getString("sala"));
				f.setCpf(rs.getString("cpf"));
				f.setIdentidade(rs.getString("identidade"));
				f.setEmail(rs.getString("email"));
				
				System.out.println("funcionario DAO nome Funcionario----"+f.getNome());
		}
		return f;
	}
	
	public boolean deletarFuncionario(int id) throws SQLException, Exception {
        boolean deletar = false;
        Connection c = null;
		PreparedStatement stmt = null;
		
		c = ConectaBanco.getConexao();
		String sql=" delete from funcionario where id=?";
		stmt = c.prepareStatement(sql);
		stmt.setInt(1,id); 
		stmt.execute();
		stmt.close();
		deletar = true;
        
		return deletar;
    }
}
