package modelo.dao.api;

import java.util.List;
import modelo.Postagem;

public interface PostagemDAO {
    
    public Postagem inserir(Postagem postagem);
    public Postagem encontrarIdentificador(Long id);
    public List<Postagem> encontrarTodos();
}