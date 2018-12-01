<%@page import="modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    List<Postagem> listaPostagens = (List<Postagem>) request.getAttribute("gerenciarPostagens");
    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("gerenciarUsuarios");
    Integer codigoOperacao = (Integer) request.getAttribute("codigoOperacao");
%>

<html>

	<head>
		<meta charset="utf-8">
		<meta name ="viewport" content ="width=device-width, initial-scale=1">
                <script src="scripts/mudaLogin.js"></script>
		<script src="scripts/jquery.js"></script>
		<link a href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
		<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

		<title>Julia Roberts | Gerenciar</title>
	</head>

	<body>           
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %>
		<section class="section-corpo">
                    <section class="section-painel">
			<form action="apagadorpostagemusuario" method="post">
                            <select class="select-postagem" name="select-gerenciar">
                                <% if(listaUsuarios != null && codigoOperacao == 1){
                                        for(Usuario usuariof : listaUsuarios){                                            
                                %>
                                            <option value="<%= usuariof.getId() %>"> <%= usuariof.getApelido() %> </option>
                                <%
                                        }
                                    }
                                    else if(listaPostagens != null && codigoOperacao == 2){
                                        for(Postagem postagem : listaPostagens){
                                %>
                                            <option value="<%= postagem.getId() %>"> <%= postagem.getTitulo() %> </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                            <section class="section-gerenciar">
                                <input type="submit" name="input-gerenciar" class="section-acao-gerenciar" value="EXCLUIR">
                                </input>
                                <% if(codigoOperacao == 2){ %>
                                    <input type="submit" name="input-gerenciar" class="section-acao-gerenciar" value="EDITAR">
                                <% } %>
                                </input>
                            </section>
			</form>
		</section>

		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

	</body>

</html>