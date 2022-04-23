package br.com.businessshow.entidades;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="noticias")
public class Noticia extends AbstractEntity<Integer> {

    @Column(name="titulo", length = 50, nullable = false )
    private String titulo;

    @Column(name="conteudo", length = 150, nullable = false )
    private String conteudo;

    @Column(name="dataCriacao", columnDefinition = "DATE")
    private LocalDate dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "DATE")
    private LocalDate dataAlteracao;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "noticiaimagem")
    private List<Imagem> listaImagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
