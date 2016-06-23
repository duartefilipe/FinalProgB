package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.modelo.Noticia;
import br.csi.modelo.dao.NoticiaDao;

@Controller
public class NoticiaController {
	
	@RequestMapping("cadastrarNoticia")
	public String adiciona(Noticia noticia) throws ClassNotFoundException{		
		boolean retorno = new NoticiaDao().cadastrar(noticia);
		if(retorno){
			return "CadastrarNoticia";
		}else{
			return "principal";
		}
	}
	
	
}
