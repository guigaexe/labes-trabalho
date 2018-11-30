package modelo.servico.api;

import java.util.List;
import modelo.Postagem;

public interface ServicoPostagem{

    public int inserir(Postagem postagem);
    public Postagem encontrarPorIdentificador(Integer id);
    public List<Postagem> encontrarCincoPostagens();
    public List<Postagem> encontrarTudo();
    public int excluir(Integer idPostagem);
}