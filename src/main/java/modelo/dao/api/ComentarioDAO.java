package modelo.dao.api;

import java.util.List;
import modelo.Comentario;

public interface ComentarioDAO {
    
    public int inserir(Comentario comentario, Integer idPostagem);
    public List<Comentario> encontrarTodos(Integer idPostagem);
    public int excluirPorIdentificador(Integer idComentario);
}