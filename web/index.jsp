<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

		<title>Um blog</title>

	</head>

	<body>
            
            <%
                String autenticado = (String) request.getAttribute("autenticado");
            %>

		<header>
                    <h1><%
                            out.print(autenticado);
                        %></h1>
			<h2>Um blog sobre a Julia Roberts.</h2>
		</header>
		<nav>
			<ul class="ul-nav">
				<li><a href="index.html">HOME</a></li>
				<li>SOBRE</li>
				<li><a href="#abrir-modal">ENTRAR</a></li>
			</ul>
		</nav>

		<section class="section-corpo">
			<article class="article-post">
				<h1 class="h1-titulo">Julia Roberts incentiva a felicidade em campanha da Lancôme</h1>
				<h2 class="h2-detalhes">por guilherme eric</h2>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
				</p>
			</article>
			<article class="article-post">
				<h1 class="h1-titulo">Julia Roberts confere musical de Uma Linda Mulher na Broadway</h1>
				<h2 class="h2-detalhes">por guilherme eric</h2>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
				</p>
			</article>
			<article class="article-post">
				<h1 class="h1-titulo">Julia Roberts confere musical de Uma Linda Mulher na Broadway</h1>
				<h2 class="h2-detalhes">por guilherme eric</h2>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
				</p>
			</article>
		</section>
	
		<footer>
			ALGUNS DIREITOS RESERVADOS. 2018.
		</footer>

		<aside id="abrir-modal" class="janela-modal">
			<div>
				<a href="#fechar" title="Fechar" class="fechar">X</a>
				<form class="form-login" name="form-entrar" action="Autenticador" method="post">
					USUÁRIO: <input type="text" name="campo-usuario" required>
					SENHA: <input type="password" name="campo-senha" required><br />

					<input type="submit" name="submit-enviar" value="ENTRAR">
				</form>
			</div>
		</aside>

	</body>

</html>
