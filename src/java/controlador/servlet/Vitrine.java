package controlador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Postagem;
import modelo.servico.implementacao.Montador;

@WebServlet("/postagem")
public class Vitrine extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
        Montador montador = new Montador();
        Integer idPostagem = Integer.valueOf(requisicao.getParameter("id"));
        HttpSession sessao = requisicao.getSession();
        sessao.setAttribute("postClicado", idPostagem);
        
        Postagem postagem = montador.obterPostagemCompleta(idPostagem);

        requisicao.setAttribute("postagem", postagem);
        requisicao.getRequestDispatcher("postagem.jsp").forward(requisicao, resposta);         
        
    }
}