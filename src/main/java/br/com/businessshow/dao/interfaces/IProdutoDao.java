package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Produto;

import java.util.List;

public interface IProdutoDao  extends IDao<Produto> {

    List<Produto> getAtivos();

    List<Produto> getPorTermo(String termo);
}
