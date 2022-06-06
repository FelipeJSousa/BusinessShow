package br.com.businessshow.config;

import br.com.businessshow.dao.implementacoes.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioDao service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home/**", "/noticia/visualizar?**", "/imagem/**", "/produto/detalhes?**").permitAll()
                .antMatchers("/webjars/**", "/static/css/**", "/static/image/**", "/static/js/**").permitAll()
                .antMatchers("/", "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css").permitAll()
                .antMatchers("/parceiro/**", "/categoria/**", "/usuario/**", "/produto/**").hasAuthority("GERENTE")
                .antMatchers("/noticia/listar", "/noticia/visualizar", "/produto/detalhes").hasAuthority("USUARIO")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()

                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/forbiden");
    }
}
