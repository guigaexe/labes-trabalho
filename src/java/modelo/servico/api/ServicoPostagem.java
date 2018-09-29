package modelo.servico.api;

import java.util.List;
import modelo.Postagem;

public interface ServicoPostagem{

    public int inserir(Postagem postagem);
    public Postagem encontrarPorIdentificador(Long id);
    public List<Postagem> encontrarCincoPostagens();
}