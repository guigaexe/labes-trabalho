package modelo.dao.api;

import java.util.List;
import modelo.servico.Comentario;

public interface ComentarioDAO {
    
    public Comentario inserir(Comentario comentario);
    public List<Comentario> encontrarTodos();
}