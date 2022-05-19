package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.UsuarioDao;
import br.com.businessshow.entidades.Categoria;
import br.com.businessshow.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UsuarioDao dao;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

//    @PostMapping("/login")
//    public String login(@Valid @ModelAttribute("login") Usuario login, BindingResult result, ModelMap model) {
//
//        dao.a
//
//        return index(model);
//    }

    @GetMapping("/home")
    public String index(ModelMap model) {
        model.addAttribute("usuario", dao.getUsuarioLogado().getNome());
        return "/home/index";
    }

    @GetMapping("/login-error")
    public String loginError(ModelMap model) {
        model.addAttribute("mensagem","Dados inválidos");
        return "/login";
    }

}
