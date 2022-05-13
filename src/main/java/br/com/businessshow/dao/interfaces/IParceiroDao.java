package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Parceiro;

import java.util.List;

public interface IParceiroDao extends IDao<Parceiro>{

    List<Parceiro> getAtivos();

}
