package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.csi.modelo.Professor;
import br.csi.util.ConectaBanco;

public class ProfessorDao {
	
	public boolean cadastraProfessor(Professor p) throws SQLException{
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		
		String nome = p.getNome();
		String siape = p.getSiape();
		String ramal = p.getRamal();
		String celular = p.getCelular();
		String sala = p.getSala();
		String cpf = p.getCpf();
		String identidade = p.getIdentidade();
		String email = p.getEmail();
		
		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO professor (nome,siape, ramal, celular, sala, cpf, identidade, email) values(?,?,?,?,?,?,?,?)";
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
	
	public boolean alteraProfessor(Professor p) throws ClassNotFoundException, SQLException {
	    boolean retorno = false;
        Connection c = null;
		PreparedStatement stmt = null;

			c = ConectaBanco.getConexao();
			String sql="UPDATE professor SET nome=?, siape=?, ramal=?, celular=?, sala=?, cpf=?, identidade=?, email=? WHERE id=?";
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getSiape());
			stmt.setString(3, p.getRamal());
			stmt.setString(4, p.getCelular());
			stmt.setString(5, p.getSala());
			stmt.setString(6, p.getCpf());
			stmt.setString(7, p.getIdentidade());
			stmt.setString(8, p.getEmail());
			stmt.setInt(9, p.getId());
					
			stmt.execute();
			stmt.close();
			retorno = true;
			System.out.println("AQUI NO ALTERAR DAO--"+p.getId());
		
 return retorno;
}

	public long buscacodigo() throws SQLException, ClassNotFoundException {
		Connection c = null;
		PreparedStatement stmt = null;

		c = ConectaBanco.getConexao();
		String sql = "";

		sql = "select MAX(id) as id from professor";
		stmt = c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long codigo = rs.getInt("id");
		rs.close();
		stmt.close();
		return codigo;
	}

	public ArrayList<Professor> getProfessores() throws ClassNotFoundException {

		ArrayList<Professor> log1 = new ArrayList<Professor>();
		Connection con = ConectaBanco.getConexao();
		Professor prof;

		try {
			String sql = "SELECT * FROM professor ORDER BY nome ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				prof = new Professor();
				prof.setId(rs.getInt("id"));
				prof.setNome(rs.getString("nome"));
				prof.setSiape(rs.getString("siape"));
				prof.setRamal(rs.getString("ramal"));
				prof.setCelular(rs.getString("celular"));
				prof.setSala(rs.getString("sala"));
				prof.setCpf(rs.getString("cpf"));
				prof.setIdentidade(rs.getString("identidade"));
				prof.setEmail(rs.getString("email"));

				log1.add(prof);
				System.out.println("Adicionado no Array");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log1;
	}

	public Professor getprofessor(int id) throws ClassNotFoundException {
		Connection con = ConectaBanco.getConexao();
		Professor prof = new Professor();
		
		try {
			String sql = "SELECT * FROM professor WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				prof.setId(rs.getInt("id"));
				prof.setNome(rs.getString("nome"));
				prof.setSiape(rs.getString("siape"));
				prof.setRamal(rs.getString("ramal"));
				prof.setCelular(rs.getString("celular"));
				prof.setSala(rs.getString("sala"));
				prof.setCpf(rs.getString("cpf"));
				prof.setIdentidade(rs.getString("identidade"));
				prof.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prof;
	}
	
	public Professor pesquisaProfessor(int id ) throws ClassNotFoundException, SQLException{
		
		Professor p = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from professor where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO PROFESSOR"+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				p = new Professor();	    
				
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setSiape(rs.getString("siape"));
				p.setRamal(rs.getString("ramal"));
				p.setCelular(rs.getString("celular"));
				p.setSala(rs.getString("sala"));
				p.setCpf(rs.getString("cpf"));
				p.setIdentidade(rs.getString("identidade"));
				p.setEmail(rs.getString("email"));
				
				System.out.println("PROFESSORDAO nome Professor----"+p.getNome());
		}
		return p;
	}
	
public Professor pesquisaProfessor2(int id ) throws ClassNotFoundException, SQLException{
		
		Professor p = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from professor where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO PROFESSOR"+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				p = new Professor();	    
				
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setSiape(rs.getString("siape"));
				p.setRamal(rs.getString("ramal"));
				p.setCelular(rs.getString("celular"));
				p.setSala(rs.getString("sala"));
				p.setCpf(rs.getString("cpf"));
				p.setIdentidade(rs.getString("identidade"));
				p.setEmail(rs.getString("email"));
				
				System.out.println("PROFESSORDAO nome Professor----"+p.getNome());
		}
		return p;
	}
	

	public boolean deletarProfessor(int id) throws SQLException, Exception {
        boolean deletar = false;
        Connection c = null;
		PreparedStatement stmt = null;
		
		c = ConectaBanco.getConexao();
		String sql=" delete from  professor where id=?";
		stmt = c.prepareStatement(sql);
		stmt.setInt(1,id); 
		stmt.execute();
		stmt.close();
		deletar = true;
        
		return deletar;
    }
}
