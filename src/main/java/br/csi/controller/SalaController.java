package br.csi.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.csi.modelo.Sala;
import br.csi.modelo.dao.SalaDao;

@Controller
public class SalaController {
	
	@RequestMapping ("CadastrarSala")
	public String adiciona (Sala sala) throws ClassNotFoundException, SQLException{
		boolean retorno = new SalaDao().cadastraSala(sala);
		if(retorno){
			return "principal";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverSala")
	public String DeletaSala(int id , HttpServletRequest rq) throws SQLException, Exception{
		
		SalaDao sD = new SalaDao();
			
			
			System.out.println("sala :  "+id);
			
			boolean retorno = sD.deletarSala(id);
			if(retorno){
				rq.setAttribute("salas", sD.getSalas());
				return "principal";
			}else{
				rq.setAttribute("msg","roblema pra excluir");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraSala")
	public String AlteraSala(Sala s, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		SalaDao sD = new SalaDao();
		
			boolean retorno = sD.alteraSala(s);
			System.out.println("No Altera sala  :   "+retorno);
			if(retorno){
				return "principal";
			}else{
				rq.setAttribute("msg","problemas ao alterar professor");
				return "erro";
			}
	}		
}	
