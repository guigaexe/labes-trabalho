<%@page import="modelo.Usuario"%>

<nav>
    <ul class="ul-nav">
        <li><a href="index.jsp">HOME</a></li>
        <li>SOBRE</li>
        <li><a href="#abrir-modal"><%= usuario != null? "<a href=\"painelcontrole.jsp\">" + usuario.getApelido() + "</a>" : "ENTRAR" %></a></li>
    </ul>
</nav>