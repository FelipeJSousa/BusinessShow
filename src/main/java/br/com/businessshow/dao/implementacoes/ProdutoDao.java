package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IProdutoDao;
import br.com.businessshow.entidades.Parceiro;
import br.com.businessshow.entidades.Produto;
import br.com.businessshow.entidades.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao extends AbstractDao<Produto, Integer> implements IProdutoDao {

    @Override
    public List<Produto> getAtivos() {
        return this.createQuery("SELECT P FROM Produto P WHERE ativo = ?1", true);
    }

    @Override
    public List<Produto> getPorTermo(String termo) {
        var obj = this.createQuery("SELECT DISTINCT P " +
                "FROM Produto P INNER JOIN P.categoria c LEFT JOIN P.listaImagem I WHERE P.ativo = true AND (P.nome like lower(?1) OR P.descricao like lower(?1) or c.nome like lower(?1))", "%" + termo.toLowerCase() + "%");
        for (Produto item : obj){
            item.getCategoria().setListaprodutos(new ArrayList<Produto>());
            item.getEmpresa().setListaProduto(new ArrayList<Produto>());
            item.getEmpresa().setListaParceiro(new ArrayList<Parceiro>());
            item.getEmpresa().setListaUsuario(new ArrayList<Usuario>());
        }

        return obj;
    }

}
