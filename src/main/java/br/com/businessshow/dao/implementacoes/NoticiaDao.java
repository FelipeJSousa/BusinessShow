package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.INoticiaDao;
import br.com.businessshow.entidades.Noticia;
import org.springframework.stereotype.Repository;

@Repository
public class NoticiaDao extends AbstractDao<Noticia, Integer> implements INoticiaDao {
}
