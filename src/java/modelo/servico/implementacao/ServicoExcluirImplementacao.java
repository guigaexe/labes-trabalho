package modelo.servico.implementacao;

import modelo.Postagem;
import modelo.Usuario;
import modelo.servico.api.ServicoExcluir;
import modelo.servico.api.ServicoPostagem;
import modelo.servico.api.ServicoUsuario;

public class ServicoExcluirImplementacao implements ServicoExcluir{
    
    public int excluirObjeto(Integer idObjeto, Integer idOperacao){
        int resultado = 0;
        
        if(idOperacao == 1){
            ServicoUsuario servicousuario = new ServicoUsuarioImplementacao();
            resultado = servicousuario.excluir(idObjeto);
        }
        else if(idOperacao == 2){
            ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
            resultado = servicopostagem.excluir(idObjeto);
        }
        return resultado;
    }
}