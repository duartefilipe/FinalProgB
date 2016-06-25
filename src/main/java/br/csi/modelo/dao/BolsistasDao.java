package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.csi.modelo.Bolsista;
import br.csi.modelo.Funcionario;
import br.csi.util.ConectaBanco;

public class BolsistasDao {
	public boolean cadastraBolsistas(Bolsista b) throws SQLException{
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		
		
		String nome = b.getNome();
		String matricula = b.getMatricula();
		String curso = b.getCurso();
		String identidade = b.getIdentidade();
		String celular = b.getCelular();
		String email = b.getEmail();

		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO bolsista (nome, matricula, curso, identidade, celular, email) values(?,?,?,?,?,?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, matricula);
			stmt.setString(3, curso);
			stmt.setString(4, identidade);
			stmt.setString(5, celular);
			stmt.setString(6, email);

			
			stmt.execute();
			stmt.close();
			retorno = true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}
	
	public boolean alteraBolsista(Bolsista b) throws ClassNotFoundException, SQLException {
	    boolean retorno = false;
        Connection c = null;
		PreparedStatement stmt = null;

			c = ConectaBanco.getConexao();
			String sql="UPDATE bolsista SET nome=?, matricula=?, curso=?, identidade=?, celular=?, email=? WHERE id=?";
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, b.getNome());
			stmt.setString(2, b.getMatricula());
			stmt.setString(3, b.getCurso());
			stmt.setString(4, b.getIdentidade());
			stmt.setString(5, b.getCelular());
			stmt.setString(6, b.getEmail());
			stmt.setInt(7, b.getId());
					
			stmt.execute();
			stmt.close();
			retorno = true;
			System.out.println("AQUI NO ALTERAR DAO--"+b.getId());
		
 return retorno;
}
	
	/*
	// Cadastrar e alterar
	public boolean cadastrar(Professor prof) throws ClassNotFoundException {

		Connection con = ConectaBanco.getConexao();

		boolean retorno = false;

		try {

			// caso seja novo
			if (prof.getId() <= 0) {
				System.out.println("Cadastro de novo professor");
				String nome = prof.getNome();
				int siape = prof.getSiape();
				int ramal = prof.getRamal();
				int celular = prof.getCelular();
				String sala = prof.getSala();
				int cpf = prof.getCpf();
				int identidade = prof.getIdentidade();
				String email = prof.getEmail();

				System.out.println("nome: " + prof.getNome());
				System.out.println("siape: " + prof.getSiape());
				System.out.println("ramal: " + prof.getRamal());
				System.out.println("celular: " + prof.getCelular());
				System.out.println("sala: " + prof.getSala());
				System.out.println("cpf: " + prof.getCpf());
				System.out.println("identidade: " + prof.getIdentidade());
				System.out.println("email: " + prof.getEmail());

				String sql = "INSERT INTO professor (nome,siape, ramal, celular, sala, cpf, identidade, email) values(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);

				stmt.setString(1, nome);
				stmt.setInt(2, siape);
				stmt.setInt(3, ramal);
				stmt.setInt(4, celular);
				stmt.setString(5, sala);
				stmt.setInt(6, cpf);
				stmt.setInt(7, identidade);
				stmt.setString(8, email);

				stmt.executeUpdate();
				retorno = true;

				// caso seja update
			} else {
				System.out.println("Update de professor");
				String nome = prof.getNome();
				int siape = prof.getSiape();
				int ramal = prof.getRamal();
				int celular = prof.getCelular();
				String sala = prof.getSala();
				int cpf = prof.getCpf();
				int identidade = prof.getIdentidade();
				String email = prof.getEmail();

				String sql = "UPDATE professor SET nome=?, siape=?, ramal=?, celular=?, sala=?, cpf=?, identidade=?, email=? WHERE id=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, siape);
				stmt.setInt(3, ramal);
				stmt.setInt(4, celular);
				stmt.setString(5, sala);
				stmt.setInt(6, cpf);
				stmt.setInt(7, identidade);
				stmt.setString(8, email);
				stmt.executeUpdate();
				retorno = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

*/

	public long buscacodigo() throws SQLException, ClassNotFoundException {
		Connection c = null;
		PreparedStatement stmt = null;

		c = ConectaBanco.getConexao();
		String sql = "";

		sql = "select MAX(id) as id from bolsista";
		stmt = c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long codigo = rs.getInt("id");
		rs.close();
		stmt.close();
		return codigo;
	}

	public ArrayList<Bolsista> getBolsistas() throws ClassNotFoundException {

		ArrayList<Bolsista> log1 = new ArrayList<Bolsista>();
		Connection con = ConectaBanco.getConexao();
		Bolsista bol;

		try {
			String sql = "select * from bolsista";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				bol = new Bolsista();
				bol.setId(rs.getInt("id"));
				bol.setNome(rs.getString("nome"));
				bol.setMatricula(rs.getString("matricula"));
				bol.setCurso(rs.getString("curso"));
				bol.setIdentidade(rs.getString("identidade"));
				bol.setCelular(rs.getString("celular"));
				bol.setEmail(rs.getString("email"));


				log1.add(bol);
				System.out.println("Adicionado no Array");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log1;
	}

	public Bolsista getbolsista(int id) throws ClassNotFoundException {
		Connection con = ConectaBanco.getConexao();
		Bolsista bol = new Bolsista();
		;
		try {
			String sql = "SELECT * FROM bolsista WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				bol.setId(rs.getInt("id"));
				bol.setNome(rs.getString("nome"));
				bol.setMatricula(rs.getString("matricula"));
				bol.setCurso(rs.getString("curso"));
				bol.setIdentidade(rs.getString("identidade"));
				bol.setCelular(rs.getString("celular"));
				bol.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bol;
	}
	
	
	public Bolsista pesquisaBolsista(int id ) throws ClassNotFoundException, SQLException{
		
		Bolsista b = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from bolsista where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO BOLSISTA "+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				b = new Bolsista();	    
				b.setId(rs.getInt("id"));
				b.setNome(rs.getString("nome"));
				b.setMatricula(rs.getString("matricula"));
				b.setCurso(rs.getString("curso"));
				b.setIdentidade(rs.getString("identidade"));
				b.setCelular(rs.getString("celular"));
				b.setEmail(rs.getString("email"));

				
				System.out.println("bolsista dao nome bolsista----"+b.getNome());
		}
		return b;
	}
	

	public boolean deletarBolsista(int id) throws SQLException, Exception {
        boolean deletar = false;
        Connection c = null;
		PreparedStatement stmt = null;
		
		c = ConectaBanco.getConexao();
		String sql=" delete from  bolsista where id=?";
		stmt = c.prepareStatement(sql);
		stmt.setInt(1,id); 
		stmt.execute();
		stmt.close();
		deletar = true;
        
		return deletar;
    }
}
