package br.csi.controller;

import java.sql.SQLException;

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
	public String AutenticaUsuario(String login, String senha , HttpServletRequest rq) throws ClassNotFoundException, SQLException {
		
		
		if(login!=null && senha!=null){
		
				System.out.println("controller atuenticar");
				HttpSession sessao = rq.getSession(true);
	
				System.out.println("login : "+login);
				System.out.println("senha : "+senha);
				
				UsuarioDao uD =  new UsuarioDao();
				
				
				boolean retorno;
				
				retorno = uD.autenticar(login,senha); 
				System.out.println("RETORNO no CONTROLLER para LOGIN"+retorno);
				
				if(retorno != false){
				        rq.getSession().invalidate();
				        rq.getSession().setAttribute("usuario", retorno);
						return "principal";
					}else{
						rq.setAttribute("msg","Problemas ao Logar");
						return "erro";
			    }
		}
		return "index";
	}
}
