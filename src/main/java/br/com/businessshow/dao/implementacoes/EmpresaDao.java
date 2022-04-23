package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IEmpresaDao;
import br.com.businessshow.entidades.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDao extends AbstractDao<Empresa, Integer> implements IEmpresaDao {
}
