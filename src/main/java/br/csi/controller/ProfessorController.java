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
	public String adiciona (Professor professor) throws ClassNotFoundException{
		boolean retorno = new ProfessorDao().cadastrar(professor);
		if(retorno){
			return "CadastrarProfessor";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverProfessor")
	public String DeletaProfessor(int id , HttpServletRequest rq) throws SQLException, Exception{
		
			ProfessorDao pD = new ProfessorDao();
			
			
			System.out.println("ID DO PROFESSOR NO DELETA PROFESSOR CONTROLER---"+id);
			
			boolean retorno = pD.deletarProfessor(id);
			if(retorno){
				rq.setAttribute("professores", pD.getProfessores());
				return "CadastrarProfessor";
			}else{
				rq.setAttribute("msg","PROBLEMAS AO EXCLUIR O PROFESSOR");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraProfessor")
	public String AlteraProfessor(Professor p, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException{
		
		ProfessorDao pD = new ProfessorDao();
		
		//u.setSenha(senhaHash);
		
			boolean retorno = pD.cadastrar(p);
			System.out.println("AQUI NO Altera professor------------------"+retorno);
			if(retorno){
				return "CadastrarProfessor";
			}else{
				rq.setAttribute("msg","PROBLEMAS AO ALTERAR O PROFESSOR");
				return "erro";
			}
	}
	
		
}	
