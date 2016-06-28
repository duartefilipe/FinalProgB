package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.csi.modelo.Sala;
import br.csi.util.ConectaBanco;

public class SalaDao {
	public boolean cadastraSala(Sala s) throws SQLException{
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		
		
		String sala = s.getSala();
		String pertence = s.getPertence();
		String local = s.getLocal();
		
		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO sala (sala, pertence, local) values(?,?,?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, sala);
			stmt.setString(2, pertence);
			stmt.setString(3, local);

			stmt.execute();
			stmt.close();
			retorno = true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}
	
	public boolean alteraSala(Sala s) throws ClassNotFoundException, SQLException {
	    boolean retorno = false;
        Connection c = null;
		PreparedStatement stmt = null;

			c = ConectaBanco.getConexao();
			String sql="UPDATE bolsista SET sala=?, pertence=?, local=? WHERE id=?";
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, s.getSala());
			stmt.setString(2, s.getPertence());
			stmt.setString(3, s.getLocal());
			stmt.setInt(4, s.getId());
					
			stmt.execute();
			stmt.close();
			retorno = true;
			System.out.println("AQUI NO ALTERAR DAO--"+s.getId());
		
 return retorno;
}
	
	public long buscacodigo() throws SQLException, ClassNotFoundException {
		Connection c = null;
		PreparedStatement stmt = null;

		c = ConectaBanco.getConexao();
		String sql = "";

		sql = "select MAX(id) as id from sala";
		stmt = c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long codigo = rs.getInt("id");
		rs.close();
		stmt.close();
		return codigo;
	}

	public ArrayList<Sala> getSalas() throws ClassNotFoundException {

		ArrayList<Sala> log4 = new ArrayList<Sala>();
		Connection con = ConectaBanco.getConexao();
		Sala sala;

		try {
			String sql = "SELECT * FROM sala ORDER BY sala ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sala = new Sala();
				sala.setId(rs.getInt("id"));
				sala.setSala(rs.getString("sala"));
				sala.setPertence(rs.getString("pertence"));
				sala.setLocal(rs.getString("local"));

				log4.add(sala);
				System.out.println("Adicionado no Array");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log4;
	}

	public Sala getsala(int id) throws ClassNotFoundException {
		Connection con = ConectaBanco.getConexao();
		Sala sala = new Sala();
		
		try {
			String sql = "SELECT * FROM sala WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sala.setId(rs.getInt("id"));
				sala.setSala(rs.getString("sala"));
				sala.setPertence(rs.getString("pertence"));
				sala.setLocal(rs.getString("local"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sala;
	}
	
	
	public Sala pesquisaSala(int id ) throws ClassNotFoundException, SQLException{
		
		Sala s = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from sala where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO sala "+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				s = new Sala();	    
				s.setId(rs.getInt("id"));
				s.setSala(rs.getString("sala"));
				s.setPertence(rs.getString("pertence"));
				s.setLocal(rs.getString("local"));
			
				System.out.println("bolsista dao nome sala----"+s.getSala());
		}
		return s;
	}
	

	public boolean deletarSala(int id) throws SQLException, Exception {
        boolean deletar = false;
        Connection c = null;
		PreparedStatement stmt = null;
		
		c = ConectaBanco.getConexao();
		String sql=" delete from  sala where id=?";
		stmt = c.prepareStatement(sql);
		stmt.setInt(1,id); 
		stmt.execute();
		stmt.close();
		deletar = true;
        
		return deletar;
    }
}
