package modelo.servico.implementacao;

import java.util.List;
import modelo.Comentario;
import modelo.dao.api.ComentarioDAO;
import modelo.dao.implementacao.ComentarioDAOMariaDB10;
import modelo.servico.api.ServicoComentario;

public class ServicoComentarioImplementacao implements ServicoComentario{

    @Override
    public int inserir(Comentario comentario, Integer idPostagem) {
        ComentarioDAO comentariodao = new ComentarioDAOMariaDB10();
        int resultado = comentariodao.inserir(comentario, idPostagem);
        
        return resultado;
    }

    @Override
    public List<Comentario> encontrarTodos(Integer idPostagem) {
        ComentarioDAO comentariodao = new ComentarioDAOMariaDB10();
        List<Comentario> listaComentarios = comentariodao.encontrarTodos(idPostagem);
        
        return listaComentarios;
    }    

    @Override
    public int excluirPorIdentificador(Integer idComentario) {
        ComentarioDAO comentariodao = new ComentarioDAOMariaDB10();
        int resultado = comentariodao.excluirPorIdentificador(idComentario);
        
        return resultado;
    }
}