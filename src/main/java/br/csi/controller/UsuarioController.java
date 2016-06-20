package br.csi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.modelo.Usuario;
import br.csi.modelo.dao.UsuarioDao;

@Controller
public class UsuarioController {
	
	@RequestMapping("login")
	public String executa(String login, String senha) throws ClassNotFoundException {

		UsuarioDao ud = new UsuarioDao();
		boolean retorno;
		retorno = ud.autenticar(login, senha);

		if (retorno != false) {
			return "principal";
		}
		return "index";
	}
}
