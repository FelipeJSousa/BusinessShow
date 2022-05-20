package br.com.businessshow.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

    @Column(name="admin", columnDefinition = "TINYINT(1)")
    private boolean admin;

    @Column(name="senha", length = 60, nullable = false)
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setEhAdmin(boolean admin) {
        this.admin = admin;
    }
}
