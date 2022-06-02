package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IParceiroDao;
import br.com.businessshow.entidades.Parceiro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParceiroDao extends AbstractDao<Parceiro,Integer> implements IParceiroDao {
    @Override
    public List<Parceiro> getAtivos() {
        return this.createQuery("SELECT P FROM Parceiro P WHERE ativo = ?1", true);
    }
}
