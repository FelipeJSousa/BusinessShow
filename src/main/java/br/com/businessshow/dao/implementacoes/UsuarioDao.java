package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IUsuarioDao;
import br.com.businessshow.entidades.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDao extends AbstractDao<Usuario,Integer> implements IUsuarioDao, UserDetailsService {

    public Usuario getUsuarioLogado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String nome;

        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }
        return findByUserName(nome);
    }

    @Override
    public Usuario findByUserName(String username) {
        List<Usuario> lista =  this.createQuery("select u from Usuario u where u.email like ?1", username) ;
        return lista.isEmpty() ? null : lista.get(0);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = findByUserName(username);
        List<GrantedAuthority> listaAdmin = AuthorityUtils.createAuthorityList("USUARIO", "GERENTE");
        List<GrantedAuthority> listaUser = AuthorityUtils.createAuthorityList("USUARIO");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(), user.isAdmin() ? listaAdmin : listaUser);
    }
}
