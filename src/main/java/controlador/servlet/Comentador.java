package controlador.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Usuario;
import modelo.servico.api.ServicoCavalheiro;
import modelo.servico.api.ServicoComentario;
import modelo.servico.implementacao.ServicoCavalheiroImplementacao;
import modelo.servico.implementacao.ServicoComentarioImplementacao;

@WebServlet("/comentador")
public class Comentador extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException{
        HttpSession sessao = requisicao.getSession();
        Integer idPostagem = (Integer) sessao.getAttribute("postClicado");
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        String comentarioConteudo = requisicao.getParameter("campo-comentario");        
        Timestamp data = new Timestamp(System.currentTimeMillis());
        
        Comentario comentario = new Comentario();
        comentario.setAutor(usuario.getApelido());
        comentario.setData(data);
        comentario.setConteudo(comentarioConteudo);
        
        ServicoCavalheiro servicocavalheiro = new ServicoCavalheiroImplementacao();
        Boolean julgamento = servicocavalheiro.verificaPalavra(comentarioConteudo);
        
        if(julgamento){
            ServicoComentario servicocomentario = new ServicoComentarioImplementacao();
            int resultado = servicocomentario.inserir(comentario, idPostagem);
        
            if(resultado == 1){
                try{
                    resposta.sendRedirect(requisicao.getContextPath() + "/postagem?id=" + idPostagem);
                }
                catch(Exception excecao){
                    System.out.println(excecao);
                }
            }
        }
        else{
            resposta.sendRedirect(requisicao.getContextPath() + "/postagem?id=" + idPostagem);
        }
    }
}