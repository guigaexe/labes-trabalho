package controlador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.servico.api.ServicoComentario;
import modelo.servico.implementacao.ServicoComentarioImplementacao;

@WebServlet("/apagador")
public class Apagador extends HttpServlet{
    
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        HttpSession sessao = requisicao.getSession();
        Integer idPostagem = (Integer) sessao.getAttribute("postClicado");
        Integer idComentario = Integer.valueOf(requisicao.getParameter("button-apagar"));
        System.out.println(idComentario);
        
        ServicoComentario servicocomentario = new ServicoComentarioImplementacao();
        int resultado = servicocomentario.excluirPorIdentificador(idComentario);
        
        if(resultado == 1){
            try{
                resposta.sendRedirect(requisicao.getContextPath() + "/postagem?id=" + idPostagem);
            }
            catch(Exception excecao){
                System.out.println(excecao);
            }
        }
    }
}