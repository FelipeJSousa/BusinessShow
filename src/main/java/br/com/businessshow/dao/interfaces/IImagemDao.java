package br.com.businessshow.dao.interfaces;

import br.com.businessshow.entidades.Imagem;
import org.springframework.web.multipart.MultipartFile;

public interface IImagemDao extends IDao<Imagem>{

    Imagem save(Imagem obj, MultipartFile file);

}
