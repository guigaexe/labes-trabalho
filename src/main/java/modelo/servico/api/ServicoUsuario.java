package modelo.servico.api;

import java.util.List;
import modelo.Usuario;

public interface ServicoUsuario {
    
    public int inserir(Usuario usuario);
    public Usuario encontrarPorApelido(String apelido);
    public List<Usuario> encontrarTodos();
    public int excluir(Integer idUsuario);
}