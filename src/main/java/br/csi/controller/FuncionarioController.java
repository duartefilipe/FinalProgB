package br.csi.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.csi.modelo.Funcionario;
import br.csi.modelo.dao.FuncionarioDao;

@Controller
public class FuncionarioController {
	
	@RequestMapping ("CadastrarFuncionario")
	public String adiciona (Funcionario funcionario) throws ClassNotFoundException, SQLException{
		boolean retorno = new FuncionarioDao().cadastraFuncionario(funcionario);
		if(retorno){
			return "CadastrarFuncionario";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverFuncionario")
	public String DeletaFuncionario(int id , HttpServletRequest rq) throws SQLException, Exception{
		
			FuncionarioDao fD = new FuncionarioDao();
			
			
			System.out.println("funcionario :  "+id);
			
			boolean retorno = fD.deletarFuncionario(id);
			if(retorno){
				rq.setAttribute("funcionarios", fD.getFuncionarios());
				return "CadastrarFuncionario";
			}else{
				rq.setAttribute("msg","roblema pra excluir");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraFuncionlario")
	public String AlteraFuncionario(Funcionario f, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		FuncionarioDao fD = new FuncionarioDao();
		 System.out.println("Funcionario no ALTERA nome funcionario---"+f.getNome());
		
		
			boolean retorno = fD.alteraFuncionario(f);
			
			System.out.println("No Altera funcionario  :   "+retorno);
			if(retorno){
				return "CadastrarFuncionario";
			}else{
				rq.setAttribute("msg","problemas ao alterar professor");
				return "erro";
			}
	}
	
		
}	
