package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.Privilegios;
import modelo.Usuario;
import modelo.dao.api.Fabrica;
import modelo.dao.api.UsuarioDAO;

public class UsuarioDAOMariaDB10 implements UsuarioDAO{
    private Connection conexao;
    
    public UsuarioDAOMariaDB10(){
        conexao = Fabrica.obterConexao();
    }
    
    @Override
    public int inserir(Usuario usuario) {
        int resultado = 0;
        try{
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO usuario VALUES(?, ?, ?, ?, ?)");
            comandoSQL.setString(1, usuario.getId().toString());
            comandoSQL.setString(2, usuario.getNome());
            comandoSQL.setString(3, usuario.getApelido());
            comandoSQL.setString(4, usuario.getEmail());
            comandoSQL.setString(5, usuario.getSenha());
            
            resultado = comandoSQL.executeUpdate();
            comandoSQL.close();
            
            return resultado;
        }
        catch(Exception excecao){
            
        }
        return resultado;
    }

    @Override
    public Usuario encontrarPorApelido(String apelido) {
        Usuario usuario = null;
        
        try{
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM usuario WHERE apelido_usuario = ?");
            comandoSQL.setString(1, apelido);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            usuario = new Usuario();
            usuario.setId(resultado.getLong(1));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}