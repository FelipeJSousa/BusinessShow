package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Usuario;

public interface IUsuarioDao extends IDao<Usuario>{

    Usuario getUsuarioLogado();

    Usuario findByUserName(String email);

}
