package br.com.businessshow.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="produtos")
public class Produto extends AbstractEntity<Integer>  {
	
	@Column(name = "descricao", length = 150, nullable = false)
    private String descricao;
     
	@Column(name = "qtde", nullable = false)
    private Integer qtde;
     
	@Column(name="data", nullable = false, columnDefinition = "DATE")
    private LocalDate data;
    
	@Column(name="valor", nullable = true, columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private BigDecimal valor;

//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.PERSIST,
//					CascadeType.MERGE
//			})
//	@JoinTable(name = "produtoimagem")
//	private List<Imagem> listaImagem;

//	public List<Imagem> getListaImagem() {
//		return listaImagem;
//	}
//
//	public void setListaImagem(List<Imagem> listaImagem) {
//		this.listaImagem = listaImagem;
//	}

	@NotNull(message = "Selecione a categoria do produto.")
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
    
    
    

}
