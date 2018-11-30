function mudaLogin(){
	let formulario = document.getElementsByClassName("form-login")[0];

	let campoNome = document.createElement("input");
	campoNome.type = "text";
	campoNome.name = "campo-nome";

	let campoEmail = document.createElement("input");
	campoEmail.type = "text";
	campoEmail.name = "campo-email";

	formulario.appendChild(campoNome);
	formulario.appendChild(campoEmail);
}