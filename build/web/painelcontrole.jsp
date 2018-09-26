<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name ="viewport" content ="width=device-width, initial-scale=1">

		<link a href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
		<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

		<title>Julia Roberts | Painel de controle</title>

	</head>

	<body>
            <%
                Usuario usuario = (Usuario) request.getAttribute("usuarioLogado");
            %>
            
		<header>
        	<h1>Julia Roberts</h1>
            <h2>Um blog sobre a Julia Roberts.</h2>
		</header>
		<nav>
			<ul class="ul-nav">
				<li><a href="index.jsp">HOME</a></li>
				<li>SOBRE</li>
				<li><% out.print(usuario.getApelido()); %></li>
			</ul>
		</nav>

		<section class="section-corpo">
			<section class="section-painel">
                            <h1>Bem vindo, <% out.print(usuario.getApelido()); %>!</h1>
				<section class="section-acao">
					NOVA POSTAGEM
				</section>
                                
                                <%
                                    if(usuario.getPrivilegio().equals("ADMINISTRADOR")){
                                %>
                                
				<section class="section-acao">
					EXCLUIR USUÁRIOS
				</section>
				<section class="section-acao">
					EXCLUIR POSTAGENS
				</section>
                                
                                <%
                                    }
                                %>
                                
				<section class="section-acao">
					SAIR DA CONTA
				</section>
			</article>
		</section>

		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

	</body>

</html>