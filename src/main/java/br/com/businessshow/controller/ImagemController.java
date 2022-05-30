package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.ImagemDao;
import br.com.businessshow.entidades.Imagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/imagem")
public class ImagemController {

    private String pasta = System.getProperty("user.dir") +"\\src\\main\\resources\\static\\image\\celular3.jpg";
    @Autowired
    private ImagemDao daoimagem;

    @PostMapping(path ="", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> salvarImagem(@ModelAttribute("imagem") Imagem imagem, ModelMap model, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Não foi possível obter o arquivo." , HttpStatus.BAD_REQUEST);
        }
        imagem.setDiretorio(System.getProperty("user.dir") +"\\src\\main\\resources\\static\\image\\" + file.getOriginalFilename());
        imagem.setNome(file.getOriginalFilename());
        imagem.setAtivo(true);
        imagem.setDataCriacao(LocalDateTime.now());
        daoimagem.save(imagem, file);

        return new ResponseEntity<Object>(imagem, HttpStatus.OK);
    }
}
