package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Noticia;

import java.util.List;

public interface INoticiaDao extends IDao<Noticia>{
    List<Noticia> getAtivos();
}
