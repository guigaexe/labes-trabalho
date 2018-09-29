package controlador.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Postagem;
import modelo.servico.api.ServicoPostagem;
import modelo.servico.implementacao.ServicoPostagemImplementacao;

@WebServlet("/index.jsp")
public class Carregador extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
        ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
        List<Postagem> listaPostagens = servicopostagem.encontrarCincoPostagens();
        
        //System.out.println(listaPostagens);
        
        requisicao.setAttribute("listaPostagens", listaPostagens);
        requisicao.getRequestDispatcher("home.jsp").forward(requisicao, resposta);        
    }
}