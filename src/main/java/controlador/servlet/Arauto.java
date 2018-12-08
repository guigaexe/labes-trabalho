package controlador.servlet;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Postagem;
import modelo.Usuario;
import modelo.servico.api.ServicoPostagem;
import modelo.servico.implementacao.ServicoPostagemImplementacao;

@WebServlet("/arauto")
public class Arauto extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        HttpSession sessao = requisicao.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        String editarPostar = (String) requisicao.getParameter("submit-postareditar");
        
        if(editarPostar.equals("POSTAR")){
            Postagem postagem = new Postagem();
            ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
        
            String autor = usuario.getApelido();
            String titulo = requisicao.getParameter("campo-titulo");
            Timestamp data = new Timestamp(System.currentTimeMillis());
            String conteudo = requisicao.getParameter("campo-postagem");
        
            postagem.setAutor(autor);
            postagem.setTitulo(titulo);
            postagem.setData(data);
            postagem.setConteudo(conteudo);
        
            System.out.println("Autor: " + autor + "\n"
            + "Titulo: " + titulo + "\n"
            + "Data: " + data + "\n"
            + "Conteudo: " + conteudo + "\n");
        
            int resultado = servicopostagem.inserir(postagem);
        
            if(resultado == 1){
                try{
                    resposta.sendRedirect(requisicao.getContextPath() + "/index.jsp");;
                }
                catch(Exception excecao){
                    System.out.println(excecao);
                }
            }
        }
        else if(editarPostar.equals("EDITAR")){
            Integer id = Integer.valueOf(requisicao.getParameter("campo-id"));
            String titulo = requisicao.getParameter("campo-titulo");
            String conteudo = requisicao.getParameter("campo-postagem");
            System.out.println("postagem:");
            ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
            int resultado = servicopostagem.alterar(id, titulo, conteudo);
            
            if(resultado == 1){
                try{
                    resposta.sendRedirect(requisicao.getContextPath() + "/index.jsp");;
                }
                catch(Exception excecao){
                    System.out.println(excecao);
                }
            }
        }
    }
}