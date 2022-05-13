package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.CategoriaDao;
import br.com.businessshow.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaDao dao;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("objcategoria",dao.findById(id));
        return "/categoria/cadastro";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, ModelMap model) {
        dao.delete(id);
        return listar(model);
    }

    @ModelAttribute("listacategorias")
    public List<Categoria> getCategoria(){
        return dao.findAll();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("lista", dao.findAll());
        return "/categoria/listar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("objcategoria") Categoria objcategoria, BindingResult result, ModelMap model) {
        if(result.hasErrors())
            return "categoria/cadastro";
        if(objcategoria.getId()==null){
            objcategoria.setDataCriacao(LocalDateTime.now());
            objcategoria.setDataAlteracao(LocalDateTime.now());
            dao.save(objcategoria);
        }
        else{
            var existente = dao.findById(objcategoria.getId());
            objcategoria.setDataCriacao(existente.getDataCriacao());
            objcategoria.setDataAlteracao(LocalDateTime.now());
            dao.update(objcategoria);
        }
        model.addAttribute("objcategoria",objcategoria);
        model.addAttribute("mensagem", "Dados Salvos");
        return listar(model);
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {
        model.addAttribute("objcategoria", new Categoria());
        return "categoria/cadastro";
    }
}
