package modelo.servico.implementacao;

import java.util.List;
import modelo.Comentario;
import modelo.Postagem;
import modelo.servico.api.ServicoComentario;
import modelo.servico.api.ServicoPostagem;

public class Montador {
    
    public Postagem obterPostagemCompleta(Integer idPostagem){
        ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
        Postagem postagem = servicopostagem.encontrarPorIdentificador(idPostagem);
        
        ServicoComentario servicocomentario = new ServicoComentarioImplementacao();
        List<Comentario> listaComentarios = servicocomentario.encontrarTodos(idPostagem);
        
        postagem.setComentarios(listaComentarios);
        
        return postagem;
    }
}