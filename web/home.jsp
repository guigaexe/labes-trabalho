<%@page import="modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    List<Postagem> listaPostagens = (List<Postagem>) request.getAttribute("listaPostagens");
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name ="viewport" content ="width=device-width, initial-scale=1">

		<link a href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
		<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

		<title>Julia Roberts | Página Inicial</title>

	</head>

	<body>
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %> 
		<section class="section-corpo">
                    <%for(Postagem postagem : listaPostagens){ %>
			<article class="article-post">
                            <h1 class="h1-titulo"><a href="postagem?id=<%= postagem.getId() %>"><%= postagem.getTitulo() %></a></h1>
				<h2 class="h2-detalhes">por <%= postagem.getAutor() %></h2>
				<p>
                                    <%= postagem.getConteudo() %>
				</p>
			</article>
                    <% } %>
		</section>
	
		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>
                
                <% 
                    if(usuario == null){
                %>

                    <%@include file= "modallogin.jsp" %> 
                    
                <%
                    }
                %>

	</body>

</html>
