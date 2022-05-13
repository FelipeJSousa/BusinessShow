package br.com.businessshow.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="parceiros")
public class Parceiro extends AbstractEntity<Integer>{

    @Column(name="nomeFantasia", length = 50, nullable = false )
    private String nomeFantasia;

    @Column(name="razaoSocial", length = 50, nullable = false )
    private String razaoSocial;

    @Column(name="cnpj", length = 14, nullable = false )
    private String cnpj;

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

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
