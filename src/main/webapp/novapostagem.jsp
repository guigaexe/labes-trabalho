<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
%>

<!DOCTYPE html>
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

		<title>Julia Roberts | Nova postagem</title>

	</head>

	<body>
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %> 
		<section class="section-corpo">
			<form class="form-postagem" action="arauto" method="post" accept-charset="UTF-8">
				TÍTULO DA POSTAGEM
				<input type="text" class="input-titulo input-geral" name="campo-titulo" required>
				CORPO DA POSTAGEM
				<textarea class="input-postagem input-geral" name="campo-postagem" cols="1" required></textarea>
				<input type="submit" class="submit-postar" value="POSTAR">
			</form>
		</section>
	
		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

	</body>

</html>