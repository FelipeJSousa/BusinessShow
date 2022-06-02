package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.ParceiroDao;
import br.com.businessshow.entidades.Parceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/parceiro")
public class ParceiroController {

    @Autowired
    ParceiroDao dao;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("objparceiro",dao.findById(id));
        return "/parceiro/cadastro";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, ModelMap model) {
        var existente = dao.findById(id);
        existente.setAtivo(false);
        existente.setDataAlteracao(LocalDateTime.now());
        dao.update(existente);
        return listar(model);
    }

    @ModelAttribute("listaparceiros")
    public List<Parceiro> getParceiro(){
        return dao.findAll();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("lista", dao.getAtivos());
        return "/parceiro/listar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("objparceiro") Parceiro objparceiro, BindingResult result, ModelMap model) {
        if(result.hasErrors())
            return "parceiro/cadastro";
        if(objparceiro.getId() == null){
            objparceiro.setAtivo(true);
            objparceiro.setDataCriacao(LocalDateTime.now());
            objparceiro.setDataAlteracao(LocalDateTime.now());
            dao.save(objparceiro);
        }
        else{
            var existente = dao.findById(objparceiro.getId());
            objparceiro.setDataCriacao(existente.getDataCriacao());
            objparceiro.setDataAlteracao(LocalDateTime.now());
            dao.update(objparceiro);
        }
        model.addAttribute("objparceiro",objparceiro);
        model.addAttribute("mensagem", "Dados Salvos");
        return listar(model);
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {
        model.addAttribute("objparceiro", new Parceiro());
        return "parceiro/cadastro";
    }
}
