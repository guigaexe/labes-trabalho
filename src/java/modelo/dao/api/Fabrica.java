package modelo.dao.api;

import java.sql.Connection;
import java.sql.DriverManager;

public class Fabrica {
    private static Connection conexao;
    private static final String BD_CAMINHO = "jdbc:mariadb://127.0.0.1/bdlabes";
    private static final String BD_USUARIO = "usuario";
    private static final String BD_SENHA = "usuario";
    
    private Fabrica(){};
    
    public static Connection obterConexao(){
        if(conexao == null){            
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                conexao = DriverManager.getConnection(BD_CAMINHO, BD_USUARIO, BD_SENHA);
            
                System.out.println("Conectou-se ao banco de dados.");
            }
            catch(Exception excecao){
                System.out.println("Erro de conexão ao banco de dados.");
            }
        }        
        return conexao;
    }    
}