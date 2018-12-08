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
            Montador montador = new Montador();
            ServicoPostagem servicopostagem = new ServicoPostagemImplementacao();
            Postagem postagem = montador.obterPostagemCompleta(idObjeto);
            System.out.println(postagem.getTitulo());
            if(postagem.getComentarios().isEmpty()){
                System.out.println("nao tem comentarios, pode excluir");
                resultado = servicopostagem.excluir(postagem.getId());
            }
            else{
                System.out.println("retornou 99");
                resultado = 99;
            }
        }
        return resultado;
    }
}