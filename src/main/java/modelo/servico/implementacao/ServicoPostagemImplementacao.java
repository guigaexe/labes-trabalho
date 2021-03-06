package modelo.servico.implementacao;

import java.util.ArrayList;
import java.util.List;
import modelo.Postagem;
import modelo.dao.api.PostagemDAO;
import modelo.dao.implementacao.PostagemDAOMariaDB10;
import modelo.servico.api.ServicoPostagem;

public class ServicoPostagemImplementacao implements ServicoPostagem{

    @Override
    public int inserir(Postagem postagem) {
        PostagemDAO postagemDAO = new PostagemDAOMariaDB10();
        int resultado = postagemDAO.inserir(postagem);
        
        return resultado;
    }

    @Override
    public Postagem encontrarPorIdentificador(Integer id) {
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        Postagem postagem = postagemdao.encontrarPorIdentificador(id);
        
        return postagem;
    }

    @Override
    public List<Postagem> encontrarCincoPostagens() {
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        List<Postagem> listaPostagens = postagemdao.encontrarCincoPostagens();
        
        return listaPostagens;
    }
    
    @Override
    public List<Postagem> encontrarTudo(){
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        List<Postagem> listaPostagens = postagemdao.encontrarTudo();
        
        return listaPostagens;
    }

    @Override
    public int excluir(Integer idPostagem) {
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        int resultado = postagemdao.excluir(idPostagem);
        
        return resultado;
    }

    @Override
    public int alterar(Integer idPostagem, String titulo, String conteudo){
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        int resultado = postagemdao.alterar(idPostagem, titulo, conteudo);
        
        return resultado;
    }
}