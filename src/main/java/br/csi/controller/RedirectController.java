package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.modelo.Noticia;
import br.csi.modelo.dao.NoticiaDao;

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
}
