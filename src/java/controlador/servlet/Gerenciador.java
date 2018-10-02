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

@WebServlet("/gerenciador")
public class Gerenciador extends HttpServlet{
    
    public void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
        ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
        List<Postagem> listaPostagens = servicopostagem.encontrarTudo();
        
        requisicao.setAttribute("gerenciarPostagens", listaPostagens);
        System.out.println(requisicao.getAttribute("gerenciarPostagens"));
        requisicao.getRequestDispatcher("gerenciar.jsp").forward(requisicao, resposta);
    }

}