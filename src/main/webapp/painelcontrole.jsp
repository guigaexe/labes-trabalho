<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    Boolean falha = (Boolean) session.getAttribute("falha");
%>

<html>

	<head>
		<meta charset="utf-8">
		<meta name ="viewport" content ="width=device-width, initial-scale=1">
                <script src="scripts/mudaLogin.js"></script>
		<script src="scripts/jquery.js"></script>
		<link a href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

		<title>Julia Roberts | Painel de controle</title>
	</head>

	<body>           
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %>
		<section class="section-corpo">
			<section class="section-painel">
                            <h1>Bem vindo, <%= usuario.getApelido() %>!</h1>
                            <% if(falha != null && falha == true){ %>
                                <h2>NAO EH POSSIVEL EXCLUIR POSTAGENS COMENTADAS!</h2>
                            <% } %>
				<section class="section-acao">
                                    <a href="novapostagem.jsp">NOVA POSTAGEM</a>
				</section>
                                
                                <% 
                                    if(usuario.getPrivilegio().equals("ADMINISTRADOR")){
                                %>
                                
				<section class="section-acao">
					<a href="gerenciador?codigo=1">EXCLUIR USUÁRIOS</a>
				</section>
				<section class="section-acao">
                                    <a href="gerenciador?codigo=2">EXCLUIR POSTAGENS</a>
				</section>
                                
                                <%
                                    }
                                %>
                                
				<section class="section-acao">
                                    <form action="logout" method="post">
                                        <input class="input-logout" type="submit" value="SAIR DA CONTA">
                                    </form>
				</section>
			</article>
		</section>

		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

	</body>

</html>