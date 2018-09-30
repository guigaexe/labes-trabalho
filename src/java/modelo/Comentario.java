package modelo;

import java.sql.Timestamp;
import java.util.List;

public class Comentario{
    private Integer id;
    private String autor;
    private Timestamp data;
    private String conteudo;
    private List<Comentario> comentarios;

    public Comentario(Integer id, String autor, Timestamp data, String conteudo, List<Comentario> comentarios) {
        this.id = id;
        this.autor = autor;
        this.data = data;
        this.conteudo = conteudo;
        this.comentarios = comentarios;
    }

    public Comentario() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
}