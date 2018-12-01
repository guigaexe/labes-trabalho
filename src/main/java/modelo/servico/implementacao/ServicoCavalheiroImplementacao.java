package modelo.servico.implementacao;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cavalheiro;
import modelo.servico.api.ServicoCavalheiro;

public class ServicoCavalheiroImplementacao implements ServicoCavalheiro{

    public Boolean verificaPalavra(String comentario){
        Cavalheiro cavalheiro = new Cavalheiro();
        Boolean julgamento = true;
        try{
            julgamento = cavalheiro.verificaPalavra(comentario);
        }
        catch(Exception excecao) {
            System.out.println(excecao);
        }
        
        return julgamento;
    }
        
}