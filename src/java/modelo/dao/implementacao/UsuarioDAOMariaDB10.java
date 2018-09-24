package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.Usuario;
import modelo.dao.api.Fabrica;
import modelo.dao.api.UsuarioDAO;

public class UsuarioDAOMariaDB10 implements UsuarioDAO{
    private Connection conexao;
    
    public UsuarioDAOMariaDB10(){
        conexao = Fabrica.obterConexao();
    }
    
    //Acochambração iminente.
    public static void main(String[] args) {
        System.out.println("Foi pro main.");
        Usuario u = new Usuario(Long.valueOf(5), "Zero", "Zero", "Zero@fatec.sp.gov.br", "123");
        System.out.println("Criou objeto de usuário.");
        UsuarioDAO udao = new UsuarioDAOMariaDB10();
        System.out.println("Criou objeto de usuariodao.");
        
        int resultado;
        
        resultado = udao.inserir(u);
        System.out.println("Tentou inserir. Resultado: " + resultado);
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
    public Usuario encontrarApelido(String apelido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> encontrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}