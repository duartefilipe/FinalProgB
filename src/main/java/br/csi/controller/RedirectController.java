package br.csi.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.modelo.Bolsista;
import br.csi.modelo.Funcionario;
import br.csi.modelo.Noticia;
import br.csi.modelo.Professor;
import br.csi.modelo.dao.BolsistasDao;
import br.csi.modelo.dao.FuncionarioDao;
import br.csi.modelo.dao.NoticiaDao;
import br.csi.modelo.dao.ProfessorDao;

@Controller
public class RedirectController {
	
	@RequestMapping("index")
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
	@RequestMapping("RedPrin")
	public String redirectPrin(HttpServletRequest rq) throws ClassNotFoundException{
		return "principal";
	}
	
	@RequestMapping("Redlocal")
	public String redirectLocal(HttpServletRequest rq) throws ClassNotFoundException{
		return "Localizacao";
	}
	
	//--------------------------noticia----------------------------------------------------------------
	@RequestMapping("RedCadastraNot")
	public String redirectNot(HttpServletRequest rq) throws ClassNotFoundException{
		return "CadastrarNoticia";
	}
	
	@RequestMapping("RedAlteraNoti")
	public String redirectAlteraNoticia(HttpServletRequest rq) throws ClassNotFoundException, SQLException{
		
		int id =  Integer.parseInt(rq.getParameter("id"));
		
		System.out.println("AQUI NO REDIRECT noticia ALTERA"+id);
		
		Noticia n = new Noticia();
		NoticiaDao nD = new NoticiaDao();
		
		n = nD.pesquisaNoticia(id);
		
		System.out.println("NOME noticia NO REDIRECT-----------"+n.getTitulo());
		rq.setAttribute("noti", n);
		return "AlterarNoticia";
	}
	//--------------------------noticia----------------------------------------------------------------
	
	//--------------------------professor----------------------------------------------------------------
	@RequestMapping("RedCadastraProf")
	public String redirectProfessor(HttpServletRequest rq) throws ClassNotFoundException{
		return "CadastrarProfessor";
	}
	
	@RequestMapping("RedAlteraProf")
	public String redirectAlteraProfessor(HttpServletRequest rq) throws ClassNotFoundException, SQLException{
		
		int id =  Integer.parseInt(rq.getParameter("id"));
		
		System.out.println("AQUI NO REDIRECT PROFESSOR ALTERA"+id);
		
		Professor p = new Professor();
		ProfessorDao pD = new ProfessorDao();
		
		p = pD.pesquisaProfessor(id);
		
		System.out.println("NOME PROFESSOR NO REDIRECT-----------"+p.getNome());
		rq.setAttribute("prof", p);
		return "AlterarProfessor";
	}
	
	//--------------------------professor----------------------------------------------------------------
	
	
	//-----------------------------------------funcionario------------------------------------------------
	@RequestMapping("RedCadastraFunc")
	public String redirectFuncionario(HttpServletRequest rq) throws ClassNotFoundException{
		return "CadastrarFuncionario";
	}
	
	@RequestMapping("RedAlteraFunc")
	public String redirectAlteraFuncionario(HttpServletRequest rq) throws ClassNotFoundException, SQLException{
		
		int id =  Integer.parseInt(rq.getParameter("id"));
		
		System.out.println("AQUI NO REDIRECT FUNCIONARIO ALTERA"+id);
		
		Funcionario f = new Funcionario();
		FuncionarioDao fD = new FuncionarioDao();
		
		f = fD.pesquisaFuncionario(id);
		
		System.out.println("NOME FUNCIONARIO NO REDIRECT-----------"+f.getNome());
		rq.setAttribute("func", f);
		return "AlterarFuncionario";
	}
	
	//-----------------------------------------funcionario------------------------------------------------
	
	//-----------------------------------------bolsista------------------------------------------------
		@RequestMapping("RedCadastraBol")
		public String redirectBolsista(HttpServletRequest rq) throws ClassNotFoundException{
			return "CadastrarBolsista";
		}
		
		@RequestMapping("RedAlteraBol")
		public String redirectAlteraBolsista(HttpServletRequest rq) throws ClassNotFoundException, SQLException{
			
			int id =  Integer.parseInt(rq.getParameter("id"));
			
			System.out.println("AQUI NO REDIRECT BOLSISTA ALTERA"+id);
			
			Bolsista b = new Bolsista();
			BolsistasDao bD = new BolsistasDao();
			
			b = bD.pesquisaBolsista(id);
			
			System.out.println("NOME bolsista NO REDIRECT-----------"+b.getNome());
			rq.setAttribute("bol", b);
			return "AlterarBolsista";
		}
		
		//-----------------------------------------bolsista------------------------------------------------
	
}
