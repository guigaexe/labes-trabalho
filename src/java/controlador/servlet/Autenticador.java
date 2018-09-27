package controlador.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.servico.api.ServicoUsuario;
import modelo.servico.implementacao.ServicoUsuarioImplementacao;

@WebServlet("/autenticador")
public class Autenticador extends HttpServlet{
      
        public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
            String usuario = requisicao.getParameter("campo-usuario");
            String senha = requisicao.getParameter("campo-senha");
            
            System.out.println(usuario);
            System.out.println(senha);
            
            ServicoUsuario servicousuario = new ServicoUsuarioImplementacao();
            Usuario usuarioBD = servicousuario.encontrarPorApelido(usuario);
            
            ServletContext contextoservlet = requisicao.getServletContext();
            
            if(usuario.equals(usuarioBD.getApelido()) && senha.equals(usuarioBD.getSenha())){
                try{
                    HttpSession sessao = requisicao.getSession();
                    sessao.setAttribute("usuarioLogado", usuarioBD);
                    contextoservlet.getRequestDispatcher("/painelcontrole.jsp").forward(requisicao, resposta);
                }
                catch(Exception excecao){
                    System.out.println(excecao);;
                }
            }
            else{
                try{
                    System.out.println("Algo deu errado.");
                }
                catch(Exception excecao){
                    System.out.println(excecao);
                }
            }
        }
}