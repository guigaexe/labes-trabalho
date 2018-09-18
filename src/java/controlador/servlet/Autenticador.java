package controlador.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticador extends HttpServlet{
      
        public void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
            String usuario = requisicao.getParameter("campo-usuario");
            String senha = requisicao.getParameter("campo-senha");
        }
        
}