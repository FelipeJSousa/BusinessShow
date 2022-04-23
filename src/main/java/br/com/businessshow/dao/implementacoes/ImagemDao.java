package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IImagemDao;
import br.com.businessshow.entidades.Imagem;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemDao extends AbstractDao<Imagem, Integer> implements IImagemDao {
}
