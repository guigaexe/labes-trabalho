package modelo.dao.api;

import java.util.List;
import modelo.Postagem;

public interface PostagemDAO {
    
    public int inserir(Postagem postagem);
    public Postagem encontrarPorIdentificador(Long id);
    public List<Postagem> encontrarCincoPostagens();
}