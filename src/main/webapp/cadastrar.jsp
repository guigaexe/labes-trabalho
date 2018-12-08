<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
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
				<form class="form-login" name="form-cadastrar" action="registro" method="post">
					NOME: <input type="text" name="campo-nome" required>
					USUÁRIO: <input type="text" name="campo-usuario" required>
					EMAIL: <input type="email" name="campo-email" required>
					SENHA: <input type="password" name="campo-senha" required><br />

					<input type="submit" name="submit-enviar" value="ENTRAR">
				</form>
		</section>

		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

	</body>

</html>