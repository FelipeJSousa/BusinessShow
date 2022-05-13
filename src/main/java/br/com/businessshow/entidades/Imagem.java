package br.com.businessshow.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="imagens")
public class Imagem extends AbstractEntity<Integer>{

    @Column(name="diretorio", length = 250, nullable = false )
    private String diretorio;

    @Column(name="nome", length = 100, nullable = false )
    private String nome;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private boolean dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private boolean dataAlteracao;

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(boolean dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(boolean dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
