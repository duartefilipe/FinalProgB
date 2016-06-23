package br.csi.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.csi.modelo.Professor;
import br.csi.modelo.dao.ProfessorDao;

@Controller
public class ProfessorController {
	
	@RequestMapping ("CadastrarProfessor")
	public String adiciona (Professor professor) throws ClassNotFoundException, SQLException{
		boolean retorno = new ProfessorDao().cadastraProfessor(professor);
		if(retorno){
			return "CadastrarProfessor";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverProfessor")
	public String DeletaProfessor(int id , HttpServletRequest rq) throws SQLException, Exception{
		
			ProfessorDao pD = new ProfessorDao();
			
			
			System.out.println("professor :  "+id);
			
			boolean retorno = pD.deletarProfessor(id);
			if(retorno){
				rq.setAttribute("professores", pD.getProfessores());
				return "CadastrarProfessor";
			}else{
				rq.setAttribute("msg","roblema pra excluir");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraProfessor")
	public String AlteraProfessor(Professor p, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		ProfessorDao pD = new ProfessorDao();
		 System.out.println("PROFESSOR no ALTERA nomeProfessor---"+p.getNome());
		
		
			boolean retorno = pD.alteraProfessor(p);
			
			System.out.println("No Altera professor  :   "+retorno);
			if(retorno){
				return "CadastrarProfessor";
			}else{
				rq.setAttribute("msg","problemas ao alterar professor");
				return "erro";
			}
	}
	
		
}	
