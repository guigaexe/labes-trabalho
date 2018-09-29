package modelo;

import java.sql.Date;
import java.util.List;

public class Postagem extends Identificador{
    private Long id;
    private String autor;
    private String titulo;
    private Date data;
    private String conteudo;
    private List<Comentario> comentarios;
    
    public Postagem(){};

    public Postagem(Long id, String titulo, String autor, Date data, String conteudo, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.conteudo = conteudo;
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}