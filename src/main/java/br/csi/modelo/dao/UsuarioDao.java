package br.csi.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import br.csi.modelo.Usuario;
import br.csi.util.ConectaBanco;

public class UsuarioDao {

	public boolean autenticar(String login, String senha) throws ClassNotFoundException, SQLException {

		Connection con = ConectaBanco.getConexao();

		System.out.println("Autenticando...");

			String sql = "SELECT * FROM usuario where login =? and senha=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Achou usuario");
				System.out.println(" " + rs.getString("login"));
				System.out.println(" " + rs.getString("senha"));
				return true;
			}
			return false;
	}

}
