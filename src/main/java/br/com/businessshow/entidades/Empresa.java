package br.com.businessshow.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="empresas")
public class Empresa extends AbstractEntity<Integer>{

    @Column(name="nome", length = 50, nullable = false )
    private String nome;

    @Column(name="descricao", length = 150 )
    private String descricao;

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCricao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

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

    public LocalDateTime getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
