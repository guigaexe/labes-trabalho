package controlador.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Postagem;
import modelo.Usuario;
import modelo.servico.api.ServicoPostagem;
import modelo.servico.api.ServicoUsuario;
import modelo.servico.implementacao.ServicoPostagemImplementacao;
import modelo.servico.implementacao.ServicoUsuarioImplementacao;

@WebServlet("/gerenciador")
public class Gerenciador extends HttpServlet{
    
    public void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
        Integer codigoOperacao = Integer.valueOf(requisicao.getParameter("codigo"));
        HttpSession sessao = requisicao.getSession();
        
        if(codigoOperacao == 2){
            ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
            List<Postagem> listaPostagens = servicopostagem.encontrarTudo();
            requisicao.setAttribute("gerenciarPostagens", listaPostagens);
            sessao.setAttribute("codigoOperacaoSelecionado", codigoOperacao);
        }
        else if(codigoOperacao == 1){
            ServicoUsuario servicousuario = new ServicoUsuarioImplementacao();
            List<Usuario> listaUsuarios = servicousuario.encontrarTodos();
            requisicao.setAttribute("gerenciarUsuarios", listaUsuarios);
            sessao.setAttribute("codigoOperacaoSelecionado", codigoOperacao);
        }
        
        requisicao.setAttribute("codigoOperacao", codigoOperacao);
        requisicao.getRequestDispatcher("gerenciar.jsp").forward(requisicao, resposta);
    }

}