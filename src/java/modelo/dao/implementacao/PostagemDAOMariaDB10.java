package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;
import modelo.Postagem;
import modelo.dao.api.Fabrica;
import modelo.dao.api.PostagemDAO;

public class PostagemDAOMariaDB10 implements PostagemDAO{
    private Connection conexao;
    
    public PostagemDAOMariaDB10() {
        conexao = Fabrica.obterConexao();
    }

    @Override
    public int inserir(Postagem postagem) {
        int resultado = 0;
        try{
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO postagem"
                    + "(fk_postagem_usuario_apelido, titulo_postagem, data_postagem, conteudo_postagem)"
                    + " VALUES(?, ?, ?, ?)");
            //comandoSQL.setString(1, "id_postagem");
            comandoSQL.setString(1, postagem.getAutor());
            comandoSQL.setString(2, postagem.getTitulo());
            comandoSQL.setDate(3, postagem.getData());
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
    
    //Acochambração iminente.
    public static void main(String[] args) {
        System.out.println("Foi pro main.");
        Postagem postagem = null;
        System.out.println("Criou objeto vazio de uma postagem.");
        PostagemDAO pdao = new PostagemDAOMariaDB10();
        System.out.println("Criou objeto de postagemdao.");
        
        postagem = pdao.encontrarPorIdentificador(Long.valueOf(1));
        System.out.println("Populou o objeto postagem. \n");
        
        //System.out.println(postagem);
        
        System.out.println("Dados da postagem: \n"
                + "Identificador do post: " + postagem.getId() + "\n" +
                "Autor do post:" + postagem.getAutor() + "\n" +
                "Título do post: " + postagem.getTitulo() + "\n" +
                "Data do post: " + postagem.getData() + "\n" +
                "Conteúdo do post: " + postagem.getConteudo());
        
    }

    @Override
    public Postagem encontrarPorIdentificador(Long id) {
        Postagem postagem = null;
        
        try{
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT u.apelido_usuario, p.id_postagem,"
                    + "p.titulo_postagem, p.data_postagem, p.conteudo_postagem "
                    + "FROM usuario u "
                    + "JOIN postagem p "
                    + "ON u.id_usuario = p.fk_postagem_usuario_id "
                    + "WHERE p.id_postagem = ?");
            comandoSQL.setString(1, id.toString());
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            postagem = new Postagem();
            postagem.setId(resultado.getLong(2));
            postagem.setAutor(resultado.getString(1));
            postagem.setTitulo(resultado.getString(3));
            postagem.setData(resultado.getDate(4));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}