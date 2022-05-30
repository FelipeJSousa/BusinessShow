package br.com.businessshow.dao.implementacoes;

import br.com.businessshow.dao.interfaces.IImagemDao;
import br.com.businessshow.entidades.Imagem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class ImagemDao extends AbstractDao<Imagem, Integer> implements IImagemDao {

    @Transactional
    public Imagem save(Imagem obj, MultipartFile file){
        getEntityManager().persist(obj);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(obj.getDiretorio());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
