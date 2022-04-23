package br.com.businessshow.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="parceiros")
public class Parceiro extends AbstractEntity<Integer>{

    @Column(name="nomeFantasia", length = 50, nullable = false )
    private String nomeFantasia;

    @Column(name="razaoSocial", length = 50, nullable = false )
    private String razaoSocial;

    @Column(name="cnpj", length = 14, nullable = false )
    private String cnpj;

    @Column(name="dataCriacao", columnDefinition = "DATE")
    private LocalDate dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "DATE")
    private LocalDate dataAlteracao;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
