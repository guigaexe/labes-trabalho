package modelo.servico.api;

import java.util.List;
import modelo.Comentario;

public interface ServicoComentario {

    public int inserir(Comentario comentario, Integer idPostagem);
    public List<Comentario> encontrarTodos(Integer idPostagem);
}