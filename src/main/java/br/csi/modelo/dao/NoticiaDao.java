package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.csi.modelo.Noticia;
import br.csi.modelo.Professor;
import br.csi.util.ConectaBanco;

public class NoticiaDao {

	public boolean cadastraNoticia(Noticia n) throws SQLException{
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		
		String titulo = n.getTitulo();
		String texto = n.getTexto();
		
		try {
			c = ConectaBanco.getConexao();
			String sql="INSERT INTO noticia (titulo, texto) values(?,?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, texto);
			
			stmt.execute();
			stmt.close();
			retorno = true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}
	
	public boolean alteraNoticia(Noticia n) throws ClassNotFoundException, SQLException {
	    boolean retorno = false;
        Connection c = null;
		PreparedStatement stmt = null;

			c = ConectaBanco.getConexao();
			String sql="UPDATE noticia SET titulo=?, texto=? WHERE id=?";
			stmt = c.prepareStatement(sql);
			
			stmt.setString(1, n.getTitulo());
			stmt.setString(2, n.getTexto());
			stmt.setInt(3, n.getId());
					
			stmt.execute();
			stmt.close();
			retorno = true;
			System.out.println("AQUI NO ALTERAR DAO--"+n.getId());
		
 return retorno;
}

	public long buscacodigo() throws SQLException, ClassNotFoundException {
		Connection c = null;
		PreparedStatement stmt = null;

		c = ConectaBanco.getConexao();
		String sql = "";

		sql = "select MAX(id) as id from noticia";
		stmt = c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long codigo = rs.getInt("id");
		rs.close();
		stmt.close();
	return codigo;
}

	public ArrayList<Noticia> getNoticias() throws ClassNotFoundException {

		ArrayList<Noticia> log1 = new ArrayList<Noticia>();
		Connection con = ConectaBanco.getConexao();
		Noticia noti;

		try {
			String sql = "select * from noticia";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				noti = new Noticia();
				noti.setId(rs.getInt("id"));
				noti.setTitulo(rs.getString("titulo"));
				noti.setTexto(rs.getString("texto"));
				log1.add(noti);
				System.out.println("Adicionado no Array");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return log1;
}

	public Noticia getNoticia(int id) throws ClassNotFoundException {
		Connection con = ConectaBanco.getConexao();
		Noticia noti = new Noticia();
		
		try {
			String sql = "SELECT * FROM noticia WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				noti.setId(rs.getInt("id"));
				noti.setTitulo(rs.getString("titulo"));
				noti.setTexto(rs.getString("texto"));


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return noti;
}
	
	public Noticia pesquisaNoticia(int id ) throws ClassNotFoundException, SQLException{
		
		Noticia n = null;
		
		Connection c = ConectaBanco.getConexao();
		String sql = "select * from noticia where id=?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		
		System.out.println("ID NO DAO DO noticia"+id);
		
		stmtPre.setInt(1, id);
		
		ResultSet rs= stmtPre.executeQuery();
		while(rs.next()){
				n = new Noticia();	    
				
				n.setId(rs.getInt("id"));
				n.setTitulo(rs.getString("titulo"));
				n.setTexto(rs.getString("texto"));
				
				System.out.println("Noticia dao titulo noticia ----"+n.getTitulo());
		}
	return n;
}

	public boolean deletarNoticia(int id) throws SQLException, Exception {
        boolean deletar = false;
        Connection c = null;
		PreparedStatement stmt = null;
		
		c = ConectaBanco.getConexao();
		String sql=" delete from  noticia where id=?";
		stmt = c.prepareStatement(sql);
		stmt.setInt(1,id); 
		stmt.execute();
		stmt.close();
		deletar = true;
     return deletar;
   }
}
