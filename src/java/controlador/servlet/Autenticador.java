package controlador.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.servico.api.ServicoUsuario;
import modelo.servico.implementacao.ServicoUsuarioImplementacao;

@WebServlet("/Autenticador")
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
                System.out.println("Usuário logado!");
            }
            else{
                try{
                requisicao.setAttribute("autenticado", "MUDOU");
                contextoservlet.getRequestDispatcher("/index.jsp").forward(requisicao, resposta);                   
                }
                catch(Exception excecao){
                    System.out.println(excecao);
                }
            }
        }
}