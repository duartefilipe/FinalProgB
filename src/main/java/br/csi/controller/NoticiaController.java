package br.csi.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.modelo.Funcionario;
import br.csi.modelo.Noticia;
import br.csi.modelo.dao.FuncionarioDao;
import br.csi.modelo.dao.NoticiaDao;

@Controller
public class NoticiaController {
	
	@RequestMapping("cadastrarNoticia")
	public String adiciona(Noticia noticia) throws ClassNotFoundException, SQLException{		
		boolean retorno = new NoticiaDao().cadastraNoticia(noticia);
		if(retorno){
			return "CadastrarNoticia";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverNoticia")
	public String DeletaNoticia(int id , HttpServletRequest rq) throws SQLException, Exception{
		
			NoticiaDao nD = new NoticiaDao();
			
			
			System.out.println("notiica :  "+id);
			
			boolean retorno = nD.deletarNoticia(id);
			if(retorno){
				rq.setAttribute("noticia", nD.getNoticias());
				return "CadastrarNoticia";
			}else{
				rq.setAttribute("msg","roblema pra excluir");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraNoticia")
	public String AlteraNoticia(Noticia n, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		NoticiaDao nD = new NoticiaDao();
		 System.out.println("noticia no ALTERA titulo funcionario ---"+n.getTitulo());
		
		
			boolean retorno = nD.alteraNoticia(n);
			
			System.out.println("No Altera noticia  :   "+retorno);
			if(retorno){
				return "CadastrarNoticia";
			}else{
				rq.setAttribute("msg","problemas ao alterar Noticia");
				return "erro";
			}
	}
	
	
	
}
