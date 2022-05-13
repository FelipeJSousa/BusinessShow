package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IParceiroDao;
import br.com.businessshow.entidades.Parceiro;
import org.springframework.stereotype.Repository;

@Repository
public class ParceiroDao extends AbstractDao<Parceiro,Integer> implements IParceiroDao {
}
