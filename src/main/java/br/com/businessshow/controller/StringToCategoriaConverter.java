package br.com.businessshow.controller;

import br.com.businessshow.dao.implementacoes.CategoriaDao;
import br.com.businessshow.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoriaConverter implements Converter<String, Categoria> {

@Autowired
private CategoriaDao dao;

    @Override
    public Categoria convert(String idTexto) {
        // TODO Auto-generated method stub
        if(idTexto.isEmpty())
            return null;
        return dao.findById(Integer.parseInt(idTexto));
    }
}
