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

            if(resultado == 1){
                try{
                    System.out.println("usuario/postagem excluido");
                    resposta.sendRedirect(requisicao.getContextPath() + "/painelcontrole.jsp");
                }
                catch(Exception excecao){
                    //System.out.println(excecao);
                }
            }
            else{
                System.out.println("resultado: " + resultado);
            }
        }
        else if(editarExcluir.equals("EDITAR")){
            try{
               resposta.sendRedirect(requisicao.getContextPath() + "/novapostagem.jsp"); //Mock.
            }
            catch(Exception excecao){
                System.out.println(excecao);
            }
        }
    }
}