let trocou = false;
let criou = false;

function trocaBoolean(){
	let trocou_local = trocou;
	const closure = function(){
		trocou_local = !trocou_local;
		return trocou_local
	}
	return closure;
}

function mudaAtriz(){
	let titulo = document.getElementsByTagName("H1");
	let subtitulo = document.getElementsByTagName("H2");
	let trocar = trocaBoolean()
	console.log(trocou);
	if(!trocou){
		titulo[0].innerHTML = "Sandra Bullock";
		subtitulo[0].innerHTML = "Um blog sobre Sandra Bullock";
		$("header").addClass("generico");
		$("header > h2").css("color", "black");
		trocou = trocar();
	}
	else{
		titulo[0].innerHTML = "Julia Roberts";
		subtitulo[0].innerHTML = "Um blog sobre a Julia Roberts.";
		$("header").removeClass("generico");
		$("header > h2").css("color", "#738D9C");
		trocou = trocar();
	}
	if(!criou){
		let span = document.createElement("SPAN");
		let texto = document.createTextNode("Oi, 	professor.");
		span.appendChild(texto);
		document.getElementsByTagName("HEADER")[0].appendChild(span);
		criou = true;
	}
}

window.onload = function(){
	document.getElementById("botaosecreto").onclick = function(){mudaAtriz()};
}