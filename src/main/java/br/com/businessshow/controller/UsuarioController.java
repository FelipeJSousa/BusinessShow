package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.EmpresaDao;
import br.com.businessshow.dao.implementacoes.UsuarioDao;
import br.com.businessshow.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioDao dao;

    @Autowired
    EmpresaDao empresaDao;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("objusuario",dao.findById(id));
        model.addAttribute("listaEmpresa", empresaDao.findAll());
        return "/usuario/cadastro";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, ModelMap model) {
        var objusuario = dao.findById(id);
        objusuario.setAtivo(false);
        dao.update(objusuario);
        return listar(model);
    }

    @ModelAttribute("listausuarios")
    public List<Usuario> getUsuario(){
        return dao.findAll();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("lista", dao.getAtivos());
        return "/usuario/listar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("objusuario") Usuario objusuario, BindingResult result, ModelMap model) {
        if(result.hasErrors())
            return "usuario/cadastro";

        objusuario.setAtivo(true);
        objusuario.setDataCriacao(LocalDateTime.now());
        objusuario.setDataAlteracao(LocalDateTime.now());

        if(objusuario.getId()==null){
            objusuario.EncodeSenha();
            dao.save(objusuario);
        }
        else{
            var existente = dao.findById(objusuario.getId());
            if(objusuario.getSenha() == "" ){
                objusuario.setSenha(existente.getSenha());
            }
            else {
                objusuario.EncodeSenha();
            }
            dao.update(objusuario);
        }
        model.addAttribute("objusuario",objusuario);
        model.addAttribute("mensagem", "Dados Salvos");
        return listar(model);
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {
        model.addAttribute("objusuario", new Usuario());
        model.addAttribute("listaEmpresa", empresaDao.findAll());
        return "usuario/cadastro";
    }
}
