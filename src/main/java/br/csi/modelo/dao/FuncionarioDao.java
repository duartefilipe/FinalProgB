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
		int siape = f.getSiape();
		int ramal = f.getRamal();
		int celular = f.getCelular();
		String sala = f.getSala();
		int cpf = f.getCpf();
		int identidade = f.getIdentidade();
		String email = f.getEmail();
		
		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO funcionario (nome,siape,ramal,celular,sala,cpf,identidade,email) values(?,?,?,?,?,?,?,?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setInt(2, siape);
			stmt.setInt(3, ramal);
			stmt.setInt(4, celular);
			stmt.setString(5, sala);
			stmt.setInt(6, cpf);
			stmt.setInt(7, identidade);
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
			stmt.setInt(2, f.getSiape());
			stmt.setInt(3, f.getRamal());
			stmt.setInt(4, f.getCelular());
			stmt.setString(5, f.getSala());
			stmt.setInt(6, f.getCpf());
			stmt.setInt(7, f.getIdentidade());
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
				func.setSiape(rs.getInt("siape"));
				func.setRamal(rs.getInt("ramal"));
				func.setCelular(rs.getInt("celular"));
				func.setSala(rs.getString("sala"));
				func.setCpf(rs.getInt("cpf"));
				func.setIdentidade(rs.getInt("identidade"));
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
				func.setSiape(rs.getInt("siape"));
				func.setRamal(rs.getInt("ramal"));
				func.setCelular(rs.getInt("celular"));
				func.setSala(rs.getString("sala"));
				func.setCpf(rs.getInt("cpf"));
				func.setIdentidade(rs.getInt("identidade"));
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
				f.setSiape(rs.getInt("siape"));
				f.setRamal(rs.getInt("ramal"));
				f.setCelular(rs.getInt("celular"));
				f.setSala(rs.getString("sala"));
				f.setCpf(rs.getInt("cpf"));
				f.setIdentidade(rs.getInt("identidade"));
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
