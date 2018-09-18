package modelo.dao.api;

import java.util.List;
import modelo.Usuario;

public interface UsuarioDAO {
    
    public Usuario inserir(Usuario usuario);
    public Usuario encontrarApelido(String apelido);
    public List<Usuario> encontrarTodos();
}