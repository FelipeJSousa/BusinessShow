package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.ImagemDao;
import br.com.businessshow.dao.implementacoes.NoticiaDao;
import br.com.businessshow.entidades.Imagem;
import br.com.businessshow.entidades.Noticia;
import br.com.businessshow.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/noticia")
@Scope("session")
public class NoticiaController {

    @Autowired
    NoticiaDao dao;
    @Autowired
    ImagemDao daoImagem;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("objnoticia",dao.findById(id));
        return "/noticia/cadastro";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, ModelMap model, HttpSession session) {
        var existente = dao.findById(id);
        existente.setAtivo(false);
        existente.setDataAlteracao(LocalDateTime.now());
        dao.update(existente);
        return listar(model, session);
    }

    @ModelAttribute("listanoticias")
    public List<Noticia> getNoticia(){
        return dao.findAll();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model, HttpSession session) {
        model.addAttribute("lista",((Usuario)session.getAttribute("usuario")).isAdmin() ? dao.findAll() : dao.getAtivos());
        return "/noticia/listar";
    }

    @GetMapping("/visualizar")
    public String detalhe(@RequestParam("id") int id, ModelMap model){
        var objnoticia = dao.findById(id);
        model.addAttribute("noticiaObj", objnoticia);
        return "/noticia/visualizar";
    }


    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("objnoticia") Noticia objnoticia, BindingResult result, ModelMap model, @RequestParam("image") List<MultipartFile> image, HttpSession session) {

        List<Imagem> listImagem = new ArrayList<>();
        for (MultipartFile file: image) {
            var obj = this.salvarImagens(file);
            listImagem.add(obj);
        }

        if(listImagem.size() > 0){
            objnoticia.setListaImagem(listImagem);
        }

        objnoticia.setAtivo(true);
        objnoticia.setDataAlteracao(LocalDateTime.now());

        if(objnoticia.getId()==null){
            objnoticia.setDataCriacao(LocalDateTime.now());
            dao.save(objnoticia);
        }
        else{
            var existente = dao.findById(objnoticia.getId());
            if(listImagem.size() < 1 ){
                objnoticia.setListaImagem(existente.getListaImagem());
            }
            objnoticia.setDataCriacao(existente.getDataCriacao());
            dao.update(objnoticia);
        }

        return listar(model, session);
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {
        model.addAttribute("objnoticia", new Noticia());
        return "noticia/cadastro";
    }

    private Imagem salvarImagens(MultipartFile file){
        var obj = new Imagem(file);
        daoImagem.save(obj, file);
        return obj;
    }

}
