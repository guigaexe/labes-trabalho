package controlador.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class Codificador implements Filter{

    @Override
    public void doFilter(ServletRequest requisicao, ServletResponse resposta, FilterChain corrente) throws IOException, ServletException {
        requisicao.setCharacterEncoding("UTF-8");
        corrente.doFilter(requisicao, resposta);
    }
    
    @Override
    public void destroy(){}
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{}
}