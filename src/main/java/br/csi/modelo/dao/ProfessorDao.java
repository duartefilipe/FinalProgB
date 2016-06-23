package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.csi.modelo.Professor;
import br.csi.util.ConectaBanco;

public class ProfessorDao {
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

				String sql = "UPDATE professor SET nome=?, siape=?, ramal=?, celular,?, sala=?, cpf=?, identidade=?, email=? WHERE id=?";
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
			String sql = "select * from professor";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				prof = new Professor();
				prof.setId(rs.getInt("id"));
				prof.setNome(rs.getString("nome"));
				prof.setSiape(rs.getInt("siape"));
				prof.setRamal(rs.getInt("ramal"));
				prof.setCelular(rs.getInt("celular"));
				prof.setSala(rs.getString("sala"));
				prof.setCpf(rs.getInt("cpf"));
				prof.setIdentidade(rs.getInt("identidade"));
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
		;
		try {
			String sql = "SELECT * FROM professor WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				prof.setId(rs.getInt("id"));
				prof.setNome(rs.getString("nome"));
				prof.setSiape(rs.getInt("siape"));
				prof.setRamal(rs.getInt("ramal"));
				prof.setCelular(rs.getInt("celular"));
				prof.setSala(rs.getString("sala"));
				prof.setCpf(rs.getInt("cpf"));
				prof.setIdentidade(rs.getInt("identidade"));
				prof.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prof;
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
