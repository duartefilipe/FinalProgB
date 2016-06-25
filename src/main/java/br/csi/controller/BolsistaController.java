package br.csi.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.csi.modelo.Bolsista;
import br.csi.modelo.dao.BolsistasDao;

@Controller
public class BolsistaController {
	
	@RequestMapping ("CadastrarBolsista")
	public String adiciona (Bolsista bolsista) throws ClassNotFoundException, SQLException{
		boolean retorno = new BolsistasDao().cadastraBolsistas(bolsista);
		if(retorno){
			return "CadastrarBolsista";
		}else{
			return "principal";
		}
	}
	
	@RequestMapping("RemoverBolsista")
	public String DeletaProfessor(int id , HttpServletRequest rq) throws SQLException, Exception{
		
		BolsistasDao bD = new BolsistasDao();
			
			
			System.out.println("bolsista :  "+id);
			
			boolean retorno = bD.deletarBolsista(id);
			if(retorno){
				rq.setAttribute("bolsistas", bD.getBolsistas());
				return "CadastrarBolsista";
			}else{
				rq.setAttribute("msg","roblema pra excluir");
				return "erro";
			}
		}
	
	@RequestMapping("AlteraBolsista")
	public String AlteraBolsista(Bolsista b, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
		
		BolsistasDao bD = new BolsistasDao();
		 System.out.println("bolsistas no ALTERA nome bolsista---"+b.getNome());
		
			boolean retorno = bD.alteraBolsista(b);
			System.out.println("No Altera bolsista  :   "+retorno);
			if(retorno){
				return "CadastrarBolsista";
			}else{
				rq.setAttribute("msg","problemas ao alterar professor");
				return "erro";
			}
	}		
}	
