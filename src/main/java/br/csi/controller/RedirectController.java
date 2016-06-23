package br.csi.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("index.htm")
	public String redirect(HttpServletRequest rq) throws ClassNotFoundException{
		//NoticiaDao nD = new NoticiaDao();
		//ARRAY CRIADO PARA RECEBR O ARRAY DE NOTICIAS DO DAO
		//ArrayList<Noticia> log = nD.getNoticias();
		//ENVIANDO ARRAY PARA JSP ATRAVES DE REQUEST
		//rq.setAttribute("noticia", log);
		return "index";
	}
	
	@RequestMapping("RedSobre")
	public String redirectSobre(HttpServletRequest rq) throws ClassNotFoundException{
		return "Sobre";
	}
	
	@RequestMapping("RedCadastraNot")
	public String redirectNot(HttpServletRequest rq) throws ClassNotFoundException{
		return "CadastrarNoticia";
	}
	
	@RequestMapping("RedCadastraProf")
	public String redirectProfessor(HttpServletRequest rq) throws ClassNotFoundException{
		return "CadastrarProfessor";
	}
	
	@RequestMapping("RedAlteraProf")
	public String redirectAlteraProfessor(HttpServletRequest rq) throws ClassNotFoundException{
		return "AlterarProfessor";
	}
	
}
