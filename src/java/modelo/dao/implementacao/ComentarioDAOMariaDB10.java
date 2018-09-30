package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Comentario;
import modelo.dao.api.ComentarioDAO;
import modelo.dao.api.Fabrica;

public class ComentarioDAOMariaDB10 implements ComentarioDAO{
    
    private final Connection CONEXAO;

    public ComentarioDAOMariaDB10() {
        CONEXAO = Fabrica.obterConexao();
    }

    @Override
    public int inserir(Comentario comentario, Integer idPostagem) {
        int resultado = 0;
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("INSERT INTO comentario"
                    + "(fk_comentario_postagem_id, fk_comentario_usuario_apelido, data_comentario,"
                    + "conteudo_comentario) VALUES(?, ?, ?, ?)");
            comandoSQL.setInt(1, idPostagem);
            comandoSQL.setString(2, comentario.getAutor());
            comandoSQL.setTimestamp(3, comentario.getData());
            comandoSQL.setString(4, comentario.getConteudo());
            
            resultado = comandoSQL.executeUpdate();
            comandoSQL.close();
        }
        catch(Exception excecao){
            System.out.println(excecao); 
        }
        return resultado;
    }

    @Override
    public List<Comentario> encontrarTodos(Integer idPostagem) {
        List<Comentario> listaComentarios = new ArrayList();
        Comentario comentario = null;
        
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("SELECT "
                    + "id_comentario, fk_comentario_usuario_apelido, data_comentario, "
                    + "conteudo_comentario FROM comentario WHERE fk_comentario_postagem_id = ? "
                    + "ORDER BY data_comentario DESC");
            comandoSQL.setInt(1, idPostagem);
        
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()){
                comentario = new Comentario();
                
                comentario.setId(resultado.getInt(1));
                comentario.setAutor(resultado.getString(2));
                comentario.setData(resultado.getTimestamp(3));
                comentario.setConteudo(resultado.getString(4));
                
                listaComentarios.add(comentario);
            }
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return listaComentarios;

    }
    
}