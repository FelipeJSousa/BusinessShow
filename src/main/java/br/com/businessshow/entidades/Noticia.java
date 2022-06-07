package br.com.businessshow.entidades;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="noticias")
public class Noticia extends AbstractEntity<Integer> {

    @Column(name="titulo", length = 50, nullable = false )
    private String titulo;

    @Column(name="conteudo", length = 4000, nullable = false )
    private String conteudo;

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "noticiaimagem")
    private List<Imagem> listaImagem;

    public List<Imagem> getListaImagem() {
        return listaImagem;
    }

    public void setListaImagem(List<Imagem> listaImagem) {
        this.listaImagem = listaImagem;
    }

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
