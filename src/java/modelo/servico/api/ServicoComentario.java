package modelo.servico.api;

import java.util.List;
import modelo.Comentario;

public interface ServicoComentario {

    public Comentario inserir(Comentario comentario);
    public List<Comentario> encontrarTodos(Integer idPostagem);
}