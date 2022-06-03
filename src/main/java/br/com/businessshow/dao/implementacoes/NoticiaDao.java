package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.INoticiaDao;
import br.com.businessshow.entidades.Noticia;
import br.com.businessshow.entidades.Parceiro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticiaDao extends AbstractDao<Noticia, Integer> implements INoticiaDao {
    @Override
    public List<Noticia> getAtivos() {
        return this.createQuery("SELECT N FROM Noticia N WHERE ativo = ?1", true);
    }
}
