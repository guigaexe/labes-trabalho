package modelo.servico.implementacao;

import java.util.List;
import modelo.Usuario;
import modelo.dao.api.UsuarioDAO;
import modelo.dao.implementacao.UsuarioDAOMariaDB10;
import modelo.servico.api.ServicoUsuario;

public class ServicoUsuarioImplementacao implements ServicoUsuario{

    @Override
    public int inserir(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario encontrarPorApelido(String apelido) {
        UsuarioDAO usuarioDAO = new UsuarioDAOMariaDB10();
        Usuario usuario = usuarioDAO.encontrarPorApelido(apelido);
        
        return usuario;
    }

    @Override
    public List<Usuario> encontrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}