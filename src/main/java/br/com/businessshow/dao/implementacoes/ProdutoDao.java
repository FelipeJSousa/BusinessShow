package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IProdutoDao;
import br.com.businessshow.entidades.Produto;
import br.com.businessshow.entidades.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoDao extends AbstractDao<Produto, Integer> implements IProdutoDao {

    @Override
    public List<Produto> getAtivos() {
        return this.createQuery("SELECT P FROM Produto P WHERE ativo = ?1", true);
    }

}
