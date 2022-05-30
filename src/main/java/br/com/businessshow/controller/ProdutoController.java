package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.CategoriaDao;
import br.com.businessshow.dao.implementacoes.ImagemDao;
import br.com.businessshow.dao.implementacoes.ProdutoDao;
import br.com.businessshow.entidades.Imagem;
import br.com.businessshow.entidades.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoDao dao;

    @Autowired
    CategoriaDao daoCategoria;

    @Autowired
    ImagemDao daoImagem;

    @GetMapping("/prealterar")
    public String prealterar(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("objproduto",dao.findById(id));
        model.addAttribute("listaCategoria", daoCategoria.findAll());
        return "/produto/cadastro";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, ModelMap model) {
        var objproduto = dao.findById(id);
        objproduto.setAtivo(false);
        dao.update(objproduto);
        return listar(model);
    }

    @ModelAttribute("listaprodutos")
    public List<Produto> getProduto(){
        return dao.findAll();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("lista", dao.getAtivos());
        return "/produto/listar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("objproduto") Produto objproduto, BindingResult result, ModelMap model,  @RequestParam("image") List<MultipartFile> image) {
        if(objproduto.getCategoria().getId() == 0)
            result.addError(new FieldError("objproduto", "categoria", "Selecione uma Categoria."));

        if(result.hasErrors()){
            model.addAttribute("listaCategoria", daoCategoria.findAll());
            return "produto/cadastro";
        }

        List<Imagem> listImagem = new ArrayList<Imagem>();
        for (MultipartFile file: image) {
            var obj = this.salvarImagens(file);
            listImagem.add(obj);
        }

        if(listImagem.size() > 0){
            objproduto.setListaImagem(listImagem);
        }

        objproduto.setAtivo(true);
        objproduto.setDataAlteracao(LocalDateTime.now());

        if(objproduto.getId()==null){
            objproduto.setDataCriacao(LocalDateTime.now());
            dao.save(objproduto);
        }
        else{
            var existente = dao.findById(objproduto.getId());
            if(listImagem.size() < 1 ){
                objproduto.setListaImagem(existente.getListaImagem());
            }
            objproduto.setDataCriacao(existente.getDataCriacao());
            dao.update(objproduto);
        }

        return listar(model);
    }

    @GetMapping("/new")
    public String novo(ModelMap model) {
        model.addAttribute("objproduto", new Produto());
        model.addAttribute("listaCategoria", daoCategoria.findAll());
        return "produto/cadastro";
    }

    private Imagem salvarImagens(MultipartFile file){
        var obj = new Imagem(file);
        daoImagem.save(obj, file);
        return obj;
    }
}
