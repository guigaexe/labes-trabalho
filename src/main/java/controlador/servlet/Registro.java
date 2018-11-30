package controlador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Privilegios;
import modelo.Usuario;
import modelo.servico.api.ServicoUsuario;
import modelo.servico.implementacao.ServicoUsuarioImplementacao;

@WebServlet("/registro")
public class Registro extends HttpServlet{
    
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        String usuario = requisicao.getParameter("campo-usuario");
        String nome = requisicao.getParameter("campo-nome");
        String email = requisicao.getParameter("campo-email");
        String senha = requisicao.getParameter("campo-senha");
        
        ServicoUsuario servicousuario = new ServicoUsuarioImplementacao();
        Usuario usuarioBD = new Usuario();
        
        usuarioBD.setApelido(usuario);
        usuarioBD.setNome(nome);
        usuarioBD.setEmail(email);
        usuarioBD.setSenha(senha);
        usuarioBD.setPrivilegio(Privilegios.values()[1].toString());
        
        int resultado = servicousuario.inserir(usuarioBD);
        System.out.println(resultado);
        if(resultado == 1){
            try{
                HttpSession sessao = requisicao.getSession();
                sessao.setAttribute("usuarioLogado", usuarioBD);
                requisicao.getRequestDispatcher("/painelcontrole.jsp").forward(requisicao, resposta);
            }
            catch(Exception excecao){
                System.out.println(excecao);
            }
        }
    }
}