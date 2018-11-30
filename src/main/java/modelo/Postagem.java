package modelo;

import java.sql.Timestamp;
import java.util.List;

public class Postagem{
    private Integer id;
    private String autor;
    private String titulo;
    private Timestamp data;
    private String conteudo;
    private List<Comentario> comentarios;
    
    public Postagem(){};

    public Postagem(Integer id, String titulo, String autor, Timestamp data, String conteudo, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.conteudo = conteudo;
        this.comentarios = comentarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    
}