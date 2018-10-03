<%@page import="modelo.Comentario"%>
<%@page import="modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    Postagem postagem = (Postagem) request.getAttribute("postagem");
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

		<title>Julia Roberts | <%= postagem.getTitulo() %></title>

	</head>

	<body>
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %> 
		<section class="section-corpo">
			<article class="article-post">
                            <h1 class="h1-titulo"><a href="postagem?id=<%= postagem.getId() %>"><%= postagem.getTitulo() %></a></h1>
				<h2 class="h2-detalhes">por <%= postagem.getAutor() %></h2>
                                <h2 class="h2-detalhes">em <%= postagem.getData() %></h2>
				<p>
                                    <%= postagem.getConteudo() %>
				</p>
			</article>
		</section>
                
		<section class="section-comentario">
                    <h1>COMENTÁRIOS</h1>
                <% for(Comentario comentario: postagem.getComentarios()){ %>
                        <article class="article-comentario">
                            <h2>por <%= comentario.getAutor() %></h2>
                            <h3>em <%= comentario.getData() %></h3>
                            <p>
                                <%= comentario.getConteudo() %>
                            </p>
                            <% if(usuario != null && usuario.getPrivilegio().equals("ADMINISTRADOR")){ %>
                                <form class="form-apagar-comentario" action="apagador" method="post">
                                    <button type="submit" name="button-apagar" value="<%= comentario.getId() %>">EXCLUIR</button>
                                </form>
                            <% } %>
                        </article>
                <% } %>
                <% if(usuario != null){ %>
                    <%@include file="comentar.jsp" %>
                <% } %>
		</section>                
	
		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>
                
                <% 
                    if(usuario == null){
                %>

                    <%@include file="modallogin.jsp" %> 
                    
                <%
                    }
                %>

	</body>

</html>
