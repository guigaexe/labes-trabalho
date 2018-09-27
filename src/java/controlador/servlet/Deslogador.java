package controlador.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Deslogador extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        requisicao.getSession().invalidate();
        try{
            resposta.sendRedirect(requisicao.getContextPath() + "/index.jsp");
        }
        catch(Exception excecao) {
            System.out.println(excecao);
        }
    }

}