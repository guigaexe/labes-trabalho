package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Cavalheiro {
    public Boolean verificaPalavra(String comentario) throws FileNotFoundException, IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("p.txt").getFile());
        
        System.out.println(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha = null;
        while ((linha = br.readLine()) != null){  
            System.out.println("entrou no while");
            String comparada = linha.toLowerCase();
            System.out.println(comparada);
            if(comentario.toLowerCase().contains(comparada)){
                return false;
            }
        }
        return true;
    }
}