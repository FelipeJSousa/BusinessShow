package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IProdutoDao;
import br.com.businessshow.entidades.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDao extends AbstractDao<Produto, Integer> implements IProdutoDao {
}
