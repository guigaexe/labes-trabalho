package modelo.servico.api;

import modelo.Postagem;

public interface ServicoExcluir {
    
    public int excluirObjeto(Integer idObjeto, Integer idOperacao);
    public Boolean checaComentado(Postagem postagem);
}