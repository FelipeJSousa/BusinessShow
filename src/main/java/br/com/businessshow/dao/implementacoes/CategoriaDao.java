package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.ICategoriaDao;
import br.com.businessshow.entidades.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDao extends AbstractDao<Categoria, Integer> implements ICategoriaDao {

}
