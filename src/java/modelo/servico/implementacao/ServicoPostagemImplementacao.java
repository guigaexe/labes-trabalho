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
    public Postagem encontrarPorIdentificador(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Postagem> encontrarCincoPostagens() {
        List<Postagem> listaPostagens = new ArrayList();
        PostagemDAO postagemdao = new PostagemDAOMariaDB10();
        
        return listaPostagens;
    }     
}