package br.com.businessshow.entidades;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produtos")
public class Produto extends AbstractEntity<Integer>  {

	@Column(name = "nome", length = 150, nullable = false)
    private String nome;

	@Column(name = "descricao", length = 150, nullable = false)
    private String descricao;
     
	@Column(name = "qtde", nullable = false)
    private Integer qtde;
     
	@Column(name="dataCriacao", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

	@Column(name="dataAlteracao", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

	@Column(name="valor", nullable = true, columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#0.00")
    private BigDecimal valor;

	@Column(name="ativo", columnDefinition = "TINYINT(1)")
	private boolean ativo;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "produtoimagem")
	private List<Imagem> listaImagem;

	@NotNull(message = "Selecione a categoria do produto.")
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;

	@NotNull(message = "Selecione a empresa do produto.")
	@ManyToOne
	@JoinColumn(name="empresa")
	private Empresa empresa;

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

	public List<Imagem> getListaImagem() {
		return listaImagem;
	}

	public void setListaImagem(List<Imagem> listaImagem) {
		this.listaImagem = listaImagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDescricaoAbreviada() {

		return this.getDescricao().length() > 17 ? this.getDescricao().substring(0,17) + "..." : this.getDescricao();
	}

	public String getDescricaoLonga() {

		return this.getDescricao().length() > 30 ? this.getDescricao().substring(0,30) + "..." : this.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime data) {
		this.dataCriacao = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
