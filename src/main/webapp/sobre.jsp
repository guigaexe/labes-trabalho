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
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

		<title>Julia Roberts | Sobre</title>

	</head>

	<body>
                <%@include file= "cabecalho.jsp" %>
                <%@include file= "menu.jsp" %> 
		<section class="section-corpo">
			<article class="article-post">
				<h1 class="h1-titulo">Sobre o blog</h1>
				<h2 class="h2-detalhes">por guilherme eric</h2>
				<p>
					Este blog tem o intuito de mostrar notícias e curiosidades da queridíssima atriz Julia Roberts, conhecida por atuar em filmes como "Uma Linda Mulher", "Onze Homens e um Segredo" e "A Menina e o Porquinho".
				</p>
				<p>
					Julia Fiona Roberts (Smyrna, 28 de outubro de 1967) é uma atriz e produtora americana. Roberts tornou-se uma das atrizes mais bem pagas do mundo, superando anual "lista de poder" do The Hollywood Reporter das melhores estrelas femininas que mais rendem 2005-2006. Seu pagamento por Pretty Women em 1990 foi de 300,000 dólares; em 2003, foi pago 25 milhões para seu papel em Mona Lisa Smile. A partir de 2010, o patrimônio líquido da atriz foi estimado em 140 milhões de dólares.
				</p>
				<p>
					Roberts foi nomeada onze vezes pela revista People como uma das "50 Pessoas Mais Bonitas do Mundo", empatada com Halle Berry. Além de ser a detentora do recorde da publicação como "A mulher mais bonita", ela já ganhou esse título por cinco vezes. 
				</p>
				<p>
					Não confundir com Sandra Bullock, a atriz que atuou junto a Keanu Reeves em "Velocidade Máxima".
				</p>
			</article>
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