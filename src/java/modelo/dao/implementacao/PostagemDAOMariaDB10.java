package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Postagem;
import modelo.dao.api.Fabrica;
import modelo.dao.api.PostagemDAO;

public class PostagemDAOMariaDB10 implements PostagemDAO{
    private final Connection CONEXAO;
    
    public PostagemDAOMariaDB10() {
        CONEXAO = Fabrica.obterConexao();
    }

    @Override
    public int inserir(Postagem postagem) {
        int resultado = 0;
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("INSERT INTO postagem"
                    + "(fk_postagem_usuario_apelido, titulo_postagem, data_postagem, conteudo_postagem)"
                    + " VALUES(?, ?, ?, ?)");
            //comandoSQL.setString(1, "id_postagem");
            comandoSQL.setString(1, postagem.getAutor());
            comandoSQL.setString(2, postagem.getTitulo());
            comandoSQL.setTimestamp(3, postagem.getData());
            comandoSQL.setString(4, postagem.getConteudo());
            
            resultado = comandoSQL.executeUpdate();
            comandoSQL.close();
            
            return resultado;
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return resultado;
    }
    
    @Override
    public Postagem encontrarPorIdentificador(Integer id) {
        Postagem postagem = null;
        
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("SELECT u.apelido_usuario, p.id_postagem,"
                    + "p.titulo_postagem, p.data_postagem, p.conteudo_postagem "
                    + "FROM usuario u "
                    + "JOIN postagem p "
                    + "ON u.id_usuario = p.fk_postagem_usuario_id "
                    + "WHERE p.id_postagem = ?");
            comandoSQL.setString(1, id.toString());
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            postagem = new Postagem();
            postagem.setId(resultado.getInt(2));
            postagem.setAutor(resultado.getString(1));
            postagem.setTitulo(resultado.getString(3));
            postagem.setData(resultado.getTimestamp(4));
            postagem.setConteudo(resultado.getString(5));
            
            comandoSQL.close();
            resultado.close();            
        }
        catch (Exception excecao){
            System.out.println(excecao);
        }
        return postagem;
    }

    @Override
    public List<Postagem> encontrarCincoPostagens() {
        List<Postagem> listaPosts = new ArrayList();
        Postagem postagem = null;
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("SELECT * FROM postagem ORDER BY data_postagem DESC LIMIT 5");
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()){
                postagem = new Postagem();
                
                postagem.setId(resultado.getInt(1));
                postagem.setAutor(resultado.getString(2));
                postagem.setTitulo(resultado.getString(3));
                postagem.setData(resultado.getTimestamp(4));
                postagem.setConteudo(resultado.getString(5));               
                
                listaPosts.add(postagem);
            }
            
            comandoSQL.close();
            resultado.close();  
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return listaPosts;
    }

}