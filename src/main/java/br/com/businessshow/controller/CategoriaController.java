package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.CategoriaDao;
import br.com.businessshow.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaDao dao;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id,
                             ModelMap model) {

        model.addAttribute("objcategoria",dao.findById(id));

        return "/categoria/cadastro";

    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id,
                          ModelMap model) {

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
    public String salvar(@ModelAttribute Categoria objcategoria,
                         ModelMap model) {
        if(objcategoria.getId()==null){
            objcategoria.setDataCriacao(LocalDate.now());
            objcategoria.setDataAlteracao(LocalDate.now());
            dao.save(objcategoria);
        }
        else{
            var existente = dao.findById(objcategoria.getId());
            objcategoria.setDataCriacao(existente.getDataCriacao());
            objcategoria.setDataAlteracao(LocalDate.now());
            dao.update(objcategoria);
        }
        model.addAttribute("objcategoria",objcategoria);
        model.addAttribute("mensagem", "Dados Salvos");
        return "/categoria/listar";
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {

        model.addAttribute("objcategoria", new Categoria());

        return "categoria/cadastro";
    }
}
