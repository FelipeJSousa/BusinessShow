package br.com.businessshow.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="categoriaproduto")
public class Categoria extends AbstractEntity<Integer> {
	
	@Column(name="nome", length = 50, nullable = false )
	private String nome;

	@Column(name="descricao", length = 150 )
	private String descricao;

	@Column(name="dataCriacao", columnDefinition = "DATE")
	private LocalDate dataCriacao;

	@Column(name="descricao", columnDefinition = "DATE")
	private LocalDate dataAlteracao;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> listaprodutos;

	public List<Produto> getListaprodutos() {
		return listaprodutos;
	}

	public void setListaprodutos(List<Produto> listaprodutos) {
		this.listaprodutos = listaprodutos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
