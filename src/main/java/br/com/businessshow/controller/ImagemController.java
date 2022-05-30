package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.ImagemDao;
import br.com.businessshow.entidades.Imagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
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

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> download(@PathVariable(value = "id") Integer id) throws IOException {
        var obj = daoimagem.findById(id);
        byte[] arquivo =Files.readAllBytes(Paths.get(obj.getDiretorio()));
        HttpHeaders httpHeaders = new HttpHeaders();
        var nome = obj.getNome();
        switch (nome.substring(nome.lastIndexOf(".") + 1).toUpperCase()) {
            case "JPG":
                httpHeaders.setContentType(MediaType.IMAGE_JPEG);break;
            case "GIF":
                httpHeaders.setContentType(MediaType.IMAGE_GIF); break;
            case "PNG":
                httpHeaders.setContentType(MediaType.IMAGE_PNG); break;
            default:
                break;
        } httpHeaders.setContentLength(arquivo.length);
        HttpEntity<byte[]> entity = new HttpEntity<byte[]>(arquivo, httpHeaders);
        return entity;
    }

}
