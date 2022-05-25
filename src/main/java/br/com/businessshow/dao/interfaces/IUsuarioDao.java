package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Usuario;

import java.util.List;

public interface IUsuarioDao extends IDao<Usuario>{

    Usuario getUsuarioLogado();

    Usuario findByUserName(String email);

    List<Usuario> getAtivos();

}
