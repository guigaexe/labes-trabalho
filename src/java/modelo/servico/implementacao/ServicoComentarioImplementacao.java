package modelo.servico.implementacao;

import java.util.List;
import modelo.Comentario;
import modelo.dao.api.ComentarioDAO;
import modelo.dao.implementacao.ComentarioDAOMariaDB10;
import modelo.servico.api.ServicoComentario;

public class ServicoComentarioImplementacao implements ServicoComentario{

    @Override
    public Comentario inserir(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> encontrarTodos(Integer idPostagem) {
        ComentarioDAO comentariodao = new ComentarioDAOMariaDB10();
        List<Comentario> listaComentarios = comentariodao.encontrarTodos(idPostagem);
        
        return listaComentarios;
    }    
}