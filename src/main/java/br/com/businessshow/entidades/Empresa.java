package br.com.businessshow.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="empresas")
public class Empresa extends AbstractEntity<Integer>{

    @Column(name="nome", length = 50, nullable = false )
    private String nome;

    @Column(name="descricao", length = 150 )
    private String descricao;

    @Column(name="dataCriacao", columnDefinition = "DATE")
    private LocalDate dataCricao;

    @Column(name="dataAlteracao", columnDefinition = "DATE")
    private LocalDate dataAlteracao;

    @OneToMany(mappedBy = "empresa")
    private List<Usuario> listaUsuario;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "empresaparceiro")
//    private List<Imagem> listaParceiro;

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDate dataCricao) {
        this.dataCricao = dataCricao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
