package br.com.businessshow.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="usuarios")
public class Usuario extends AbstractEntity<Integer>{

    @Column(name="nome", length = 50, nullable = false)
    private String nome;

    @Column(name="sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Column(name="cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name="email", length = 100, nullable = false)
    private String email;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;

    @Column(name="dataCriacao", columnDefinition = "DATE")
    private LocalDate dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "DATE")
    private LocalDate dataAlteracao;

    @ManyToOne
    @JoinColumn(name="empresas")
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
}
