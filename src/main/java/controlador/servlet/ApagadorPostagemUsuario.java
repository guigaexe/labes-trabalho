package controlador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Postagem;
import modelo.servico.api.ServicoExcluir;
import modelo.servico.implementacao.ServicoExcluirImplementacao;

@WebServlet("/apagadorpostagemusuario")
public class ApagadorPostagemUsuario extends HttpServlet{
    
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        HttpSession sessao = requisicao.getSession();
        String editarExcluir = (String) requisicao.getParameter("input-gerenciar");
        System.out.println(editarExcluir);
        
        if(editarExcluir.equals("EXCLUIR")){
            Integer excluido =  Integer.valueOf(requisicao.getParameter("select-gerenciar"));
            Integer idOperacao = (Integer) sessao.getAttribute("codigoOperacaoSelecionado");
            ServicoExcluir servicoexcluir = new ServicoExcluirImplementacao();
            System.out.println("usuario:" + excluido);
            int resultado = servicoexcluir.excluirObjeto(excluido, idOperacao);
            
            switch(resultado){
                case 1:
                    try{
                        sessao.setAttribute("falha", false);
                        System.out.println("usuario/postagem excluido");
                        resposta.sendRedirect(requisicao.getContextPath() + "/painelcontrole.jsp");
                    }
                    catch(Exception excecao){
                        //System.out.println(excecao);
                    }
                    break;
                case 99:
                    try{
                        sessao.setAttribute("falha", true);
                        System.out.println("setou o atributo");
                        resposta.sendRedirect(requisicao.getContextPath() + "/painelcontrole.jsp");
                    }
                    catch(Exception excecao){
                        //System.out.println(excecao);
                    }
                    break;
            }
        }
    }
}