package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Privilegios;
import modelo.Usuario;
import modelo.dao.api.Fabrica;
import modelo.dao.api.UsuarioDAO;

public class UsuarioDAOMariaDB10 implements UsuarioDAO{
    private final Connection CONEXAO;
    
    public UsuarioDAOMariaDB10(){
        CONEXAO = Fabrica.obterConexao();
    }
    
    @Override
    public int inserir(Usuario usuario) {
        int resultado = 0; 
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("INSERT INTO "
                    + "usuario(nome_usuario, apelido_usuario, email_usuario, senha_usuario, privilegio_usuario)"
                    + " VALUES(?, ?, ?, ?, ?)");
            comandoSQL.setString(1, usuario.getNome());
            comandoSQL.setString(2, usuario.getApelido());
            comandoSQL.setString(3, usuario.getEmail());
            comandoSQL.setString(4, usuario.getSenha());
            comandoSQL.setInt(5, Privilegios.values()[1].ordinal());
            
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
    public Usuario encontrarPorApelido(String apelido) {
        Usuario usuario = null;
        
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("SELECT * FROM usuario WHERE apelido_usuario = ?");
            comandoSQL.setString(1, apelido);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            usuario = new Usuario();
            usuario.setId(resultado.getInt(1));
            usuario.setNome(resultado.getString(2));
            usuario.setApelido(resultado.getString(3));
            usuario.setEmail(resultado.getString(4));
            usuario.setSenha(resultado.getString(5));
            usuario.setPrivilegio(Privilegios.values()[resultado.getInt(6)].toString());
            
            comandoSQL.close();
            resultado.close();
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return usuario;
    }

    @Override
    public List<Usuario> encontrarTodos() {
        List<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario = null;
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("SELECT id_usuario, apelido_usuario FROM usuario");
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()){
                usuario = new Usuario();
                
                usuario.setId(resultado.getInt(1));                
                usuario.setApelido(resultado.getString(2)); 
                listaUsuarios.add(usuario);
            }
            
            comandoSQL.close();
            resultado.close();  
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return listaUsuarios; 
    }

    @Override
    public int excluir(Integer idUsuario) {
        int resultado = 0;
        try{
            PreparedStatement comandoSQL = CONEXAO.prepareStatement("DELETE FROM usuario "
                    + "WHERE id_usuario = ?");
            comandoSQL.setInt(1, idUsuario);
            
            resultado = comandoSQL.executeUpdate();
            comandoSQL.close();
        }
        catch(Exception excecao){
            System.out.println(excecao);
        }
        return resultado;
    }

}