package modelo.servico;

import java.time.LocalDate;
import modelo.Identificador;

public class Comentario extends Identificador{
    private Long id;
    private String autor;
    private LocalDate data;
    private String conteudo;

    public Comentario(Long id, String autor, LocalDate data, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.data = data;
        this.conteudo = conteudo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
}