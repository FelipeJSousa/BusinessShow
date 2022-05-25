package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.UsuarioDao;
import br.com.businessshow.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class HomeController {

    @Autowired
    private UsuarioDao dao;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("")
    public String index() {
        return login();
    }

    @GetMapping("/forbiden")
    public String forbiden(){
        return "/forbiden";
    }

    @GetMapping("/home")
    public String home(ModelMap model, HttpSession session) {
        var user = dao.getUsuarioLogado();
        session.setAttribute("usuario", user);
        return "/home/index";
    }

    @GetMapping("/login-error")
    public String loginError(ModelMap model) {
        model.addAttribute("mensagem","Dados inválidos");
        return "/login";
    }

}
