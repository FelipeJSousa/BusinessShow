package br.com.businessshow.entidades;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="imagens")
public class Imagem extends AbstractEntity<Integer>{

    public Imagem(){
        this.setAtivo(true);
        this.setDataCriacao(LocalDateTime.now());
    }

    public Imagem(MultipartFile file){
        this();
        this.setDiretorio(System.getProperty("user.dir") +"\\src\\main\\resources\\static\\image\\" + file.getOriginalFilename());
        this.setNome(file.getOriginalFilename());
    }
    @Column(name="diretorio", length = 250, nullable = false )
    private String diretorio;

    @Column(name="nome", length = 100, nullable = false )
    private String nome;

    @Column(name="ativo", columnDefinition = "TINYINT(1)")
    private boolean ativo;

    @Column(name="dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name="dataAlteracao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAlteracao;

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
